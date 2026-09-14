package com.jsolisg.vmaze_middelware.dto;

import java.util.List;

public record SearchShowResponse(
        Long id,
        String name,
        String channel,
        String summary,
        List<String> genres,
        List<ShowCommentResponse> comments
) {
}
