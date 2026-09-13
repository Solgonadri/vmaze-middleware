package com.jsolisg.vmaze_middelware.dto;

import java.util.Date;
import java.util.List;

public record TvMazeShow(
        Long id,
        String name,
        TvMazeNetwork network,
        TvMazeNetwork webChannel,
        String summary,
        List<String> genres
) {
}
