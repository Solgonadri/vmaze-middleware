package com.jsolisg.vmaze_middelware.controller;

import com.jsolisg.vmaze_middelware.dto.SearchShowResponse;
import com.jsolisg.vmaze_middelware.dto.ShowResponse;
import com.jsolisg.vmaze_middelware.dto.TvMazeSearchItem;
import com.jsolisg.vmaze_middelware.service.ShowService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{showId}")
    public ShowResponse  getShow(@PathVariable Long showId){
        return service.getShow(showId);
    }
}
