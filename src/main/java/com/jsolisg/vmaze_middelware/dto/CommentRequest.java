package com.jsolisg.vmaze_middelware.dto;

import jakarta.validation.constraints.*;

public record CommentRequest(
        @NotNull(message = "show_id is required")
        @Positive(message = "show_id must be greater than 0")
        Long show_id,

        @NotBlank(message = "comment must not be blank")
        String comment,

        @NotNull(message = "rating is required")
        @Min(value = 0, message = "rating must be at least 0")
        @Max(value = 5, message = "rating must be at most 5")
        Integer rating
) {
}
