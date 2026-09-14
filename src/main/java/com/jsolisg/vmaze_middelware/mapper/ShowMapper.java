package com.jsolisg.vmaze_middelware.mapper;

import com.jsolisg.vmaze_middelware.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowMapper {
    public SearchShowResponse toSearchResponse(TvMazeShow show) {
        return new SearchShowResponse(
                show.id(),
                show.name(),
                resolveChannel(show),
                show.summary(),
                show.genres(),
                show.comments()
        );
    }

    private String resolveChannel(TvMazeShow show) {
        TvMazeNetwork network = show.network();
        if(network != null && network.name() != null){
            return network.name();
        }
        TvMazeNetwork webChannel = show.webChannel();
        if (webChannel != null && webChannel.name() != null){
            return webChannel.name();
        }
        return null;
    }

    public ShowResponse toShowResponse(TvMazeShowResponse show) {
        return new ShowResponse(
                show.id(),
                show.url(),
                show.name(),
                show.type(),
                show.language(),
                show.genres(),
                show.status(),
                show.runtime(),
                show.averageRuntime(),
                show.premiered(),
                show.ended(),
                show.officialSite(),
                show.schedule(),
                show.rating(),
                show.weight(),
                show.network(),
                show.webChannel(),
                show.dvdCountry(),
                show.externals(),
                show.image(),
                show.summary(),
                show.updated(),
                show.links(),
                List.of()
        );
    }
}
