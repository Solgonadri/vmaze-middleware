package com.jsolisg.vmaze_middelware.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record ShowResponse(
        Long id,
        String url,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        Integer runtime,
        Integer averageRuntime,
        String premiered,
        String ended,
        String officialSite,
        TvMazeSchedule schedule,
        TvMazeRating rating,
        Double weight,
        TvMazeNetwork network,
        TvMazeNetwork webChannel,
        TvMazeCountry dvdCountry,
        TvMazeExternals externals,
        TvMazeImage image,
        String summary,
        Long updated,
        @JsonProperty("_links")
        Map<String, Object> links
) {
}
