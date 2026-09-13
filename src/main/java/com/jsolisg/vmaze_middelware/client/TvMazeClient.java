package com.jsolisg.vmaze_middelware.client;

import com.jsolisg.vmaze_middelware.config.TvMazeProperties;
import com.jsolisg.vmaze_middelware.dto.TvMazeSearchItem;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Component
public class TvMazeClient {
    private final RestClient restClient;
    public TvMazeClient(TvMazeProperties properties) {
        this.restClient = RestClient.builder()
                .baseUrl(properties.baseUrl())
                .build();
    }

    public List<TvMazeSearchItem> searchShows(String query){
        TvMazeSearchItem[] response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/shows")
                        .queryParam("q", query)
                        .build())
                .retrieve()
                .body(TvMazeSearchItem[].class);

        return response != null ? Arrays.asList(response) : List.of();
    }
}
