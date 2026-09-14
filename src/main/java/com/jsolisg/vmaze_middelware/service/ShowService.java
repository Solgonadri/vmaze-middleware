package com.jsolisg.vmaze_middelware.service;

import com.jsolisg.vmaze_middelware.client.TvMazeClient;
import com.jsolisg.vmaze_middelware.dto.*;
import com.jsolisg.vmaze_middelware.mapper.ShowDocumentMapper;
import com.jsolisg.vmaze_middelware.mapper.ShowMapper;
import com.jsolisg.vmaze_middelware.percistence.document.ShowDocument;
import com.jsolisg.vmaze_middelware.percistence.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    private final TvMazeClient tvMazeClient;
    private final ShowMapper  showMapper;

    private final ShowRepository showRepository;
    private final ShowDocumentMapper showDocumentMapper;

    public ShowService(
            TvMazeClient tvMazeClient,
            ShowMapper showMapper,
            ShowRepository showRepository,
            ShowDocumentMapper showDocumentMapper) {

        this.tvMazeClient = tvMazeClient;
        this.showMapper = showMapper;
        this.showRepository = showRepository;
        this.showDocumentMapper = showDocumentMapper;
    }

    public List<SearchShowResponse> searchShows(String query){
        List<TvMazeSearchItem> shows = tvMazeClient.searchShows(query);

        return shows.stream()
                .map(TvMazeSearchItem::show)
                .map(showMapper::toSearchResponse)
                .toList();
    }

    public ShowResponse getShow(Long showId){
        return showRepository.findById(showId)
                .map(showDocumentMapper::toResponse)
                .orElseGet(() -> fetchAndCacheShow(showId));
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
