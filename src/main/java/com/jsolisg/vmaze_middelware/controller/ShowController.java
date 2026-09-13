package com.jsolisg.vmaze_middelware.controller;

import com.jsolisg.vmaze_middelware.dto.SearchShowResponse;
import com.jsolisg.vmaze_middelware.dto.TvMazeSearchItem;
import com.jsolisg.vmaze_middelware.service.ShowService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@Validated
public class ShowController {
    private final ShowService service;

    public ShowController(ShowService service){
        this.service = service;
    }

    @GetMapping("/search")
    public List<SearchShowResponse> searchShows(
            @RequestParam("search_query")
            String query){
        return service.searchShows(query);
    }
}
