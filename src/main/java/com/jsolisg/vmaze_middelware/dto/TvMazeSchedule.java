package com.jsolisg.vmaze_middelware.dto;

import java.util.List;

public record TvMazeSchedule(
        String time,
        List<String> days
) {
}
