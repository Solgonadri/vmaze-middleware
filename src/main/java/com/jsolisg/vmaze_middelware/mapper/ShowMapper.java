package com.jsolisg.vmaze_middelware.mapper;

import com.jsolisg.vmaze_middelware.dto.SearchShowResponse;
import com.jsolisg.vmaze_middelware.dto.TvMazeNetwork;
import com.jsolisg.vmaze_middelware.dto.TvMazeShow;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {
    public SearchShowResponse toSearchResponse(TvMazeShow show) {
        return new SearchShowResponse(
                show.id(),
                show.name(),
                resolveChannel(show),
                show.summary(),
                show.genres()
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
}
