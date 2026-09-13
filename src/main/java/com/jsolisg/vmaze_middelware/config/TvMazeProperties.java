package com.jsolisg.vmaze_middelware.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tvmaze")
public record TvMazeProperties(String baseUrl) {
}
