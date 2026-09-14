package com.jsolisg.vmaze_middelware.service;

import com.jsolisg.vmaze_middelware.client.TvMazeClient;
import com.jsolisg.vmaze_middelware.dto.*;
import com.jsolisg.vmaze_middelware.mapper.ShowDocumentMapper;
import com.jsolisg.vmaze_middelware.mapper.ShowMapper;
import com.jsolisg.vmaze_middelware.percistence.document.CommentDocument;
import com.jsolisg.vmaze_middelware.percistence.document.ShowDocument;
import com.jsolisg.vmaze_middelware.percistence.repository.CommentRepository;
import com.jsolisg.vmaze_middelware.percistence.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShowService {
    private final TvMazeClient tvMazeClient;
    private final ShowMapper  showMapper;

    private final ShowRepository showRepository;
    private final ShowDocumentMapper showDocumentMapper;

    private final CommentRepository commentRepository;

    public ShowService(
            TvMazeClient tvMazeClient,
            ShowMapper showMapper,
            ShowRepository showRepository,
            ShowDocumentMapper showDocumentMapper,
            CommentRepository commentRepository) {

        this.tvMazeClient = tvMazeClient;
        this.showMapper = showMapper;
        this.showRepository = showRepository;
        this.showDocumentMapper = showDocumentMapper;
        this.commentRepository = commentRepository;
    }

    public List<SearchShowResponse> searchShows(String query){
        List<TvMazeSearchItem> tvMazeResults =
                tvMazeClient.searchShows(query);

        List<Long> showIds = tvMazeResults.stream()
                .map(item -> item.show().id())
                .toList();

        List<CommentDocument> comments =
                commentRepository.findByShowIdIn(showIds);

        Map<Long, List<ShowCommentResponse>> commentsByShow =
                comments.stream()
                        .collect(Collectors.groupingBy(
                                CommentDocument::getShowId,
                                Collectors.mapping(
                                        comment -> new ShowCommentResponse(
                                                comment.getComment(),
                                                comment.getRating()
                                        ),
                                        Collectors.toList()
                                )
                        ));

        return tvMazeResults.stream()
                .map(item -> {

                    SearchShowResponse response =
                            showMapper.toSearchResponse(item.show());

                    List<ShowCommentResponse> showComments =
                            commentsByShow.getOrDefault(
                                    response.id(),
                                    List.of()
                            );

                    return new SearchShowResponse(
                            response.id(),
                            response.name(),
                            response.channel(),
                            response.summary(),
                            response.genres(),
                            showComments
                    );
                })
                .toList();
    }

    public ShowResponse getShow(Long showId){
        ShowResponse show = showRepository.findById(showId)
                .map(showDocumentMapper::toResponse)
                .orElseGet(() -> fetchAndCacheShow(showId));

        List<ShowCommentResponse> comments = commentRepository.findByShowId(showId)
                .stream()
                .map(comment -> new ShowCommentResponse(
                        comment.getComment(),
                        comment.getRating()
                ))
                .toList();

        return new ShowResponse(
                show.id(),
                show.url(),
                show.name(),
                show.type(),
                show.language(),
                show.genres(),
                show.status(),
                show.runtime(),
                show.averageRuntime(),
                show.premiered(),
                show.ended(),
                show.officialSite(),
                show.schedule(),
                show.rating(),
                show.weight(),
                show.network(),
                show.webChannel(),
                show.dvdCountry(),
                show.externals(),
                show.image(),
                show.summary(),
                show.updated(),
                show.links(),
                comments
        );
    }

    private ShowResponse fetchAndCacheShow(Long showId) {

        TvMazeShowResponse tvMazeShow = tvMazeClient.getShow(showId);

        ShowDocument document =
                showDocumentMapper.toDocument(tvMazeShow);

        ShowDocument savedDocument =
                showRepository.save(document);

        return showDocumentMapper.toResponse(savedDocument);
    }
}
