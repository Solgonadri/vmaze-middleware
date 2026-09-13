package com.jsolisg.vmaze_middelware.service;

import com.jsolisg.vmaze_middelware.client.TvMazeClient;
import com.jsolisg.vmaze_middelware.dto.SearchShowResponse;
import com.jsolisg.vmaze_middelware.dto.TvMazeSearchItem;
import com.jsolisg.vmaze_middelware.mapper.ShowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    private final TvMazeClient tvMazeClient;
    private final ShowMapper  showMapper;

    public ShowService(TvMazeClient tvMazeClient, ShowMapper showMapper) {
        this.tvMazeClient = tvMazeClient;
        this.showMapper = showMapper;
    }

    public List<SearchShowResponse> searchShows(String query){
        List<TvMazeSearchItem> shows = tvMazeClient.searchShows(query);

        return shows.stream()
                .map(TvMazeSearchItem::show)
                .map(showMapper::toSearchResponse)
                .toList();
    }
}
