package com.jsolisg.vmaze_middelware.mapper;

import com.jsolisg.vmaze_middelware.dto.*;
import com.jsolisg.vmaze_middelware.percistence.document.*;
import org.springframework.stereotype.Component;

@Component
public class ShowDocumentMapper {
    public ShowDocument toDocument(TvMazeShowResponse source) {

        ShowDocument document = new ShowDocument();

        document.setId(source.id());
        document.setUrl(source.url());
        document.setName(source.name());
        document.setType(source.type());
        document.setLanguage(source.language());
        document.setGenres(source.genres());
        document.setStatus(source.status());
        document.setRuntime(source.runtime());
        document.setAverageRuntime(source.averageRuntime());
        document.setPremiered(source.premiered());
        document.setEnded(source.ended());
        document.setOfficialSite(source.officialSite());
        document.setWeight(source.weight());
        document.setSummary(source.summary());
        document.setUpdated(source.updated());
        document.setLinks(source.links());

        if (source.schedule() != null) {
            document.setSchedule(
                    new ScheduleDocument(
                            source.schedule().time(),
                            source.schedule().days()
                    )
            );
        }

        if (source.rating() != null) {
            document.setRating(
                    new RatingDocument(
                            source.rating().average()
                    )
            );
        }

        if (source.network() != null) {
            document.setNetwork(
                    new NetworkDocument(
                            source.network().id(),
                            source.network().name()
                    )
            );
        }

        if (source.webChannel() != null) {
            document.setWebChannel(
                    new NetworkDocument(
                            source.webChannel().id(),
                            source.webChannel().name()
                    )
            );
        }

        if (source.dvdCountry() != null) {
            document.setDvdCountry(
                    new CountryDocument(
                            source.dvdCountry().name(),
                            source.dvdCountry().code(),
                            source.dvdCountry().timezone()
                    )
            );
        }

        if (source.externals() != null) {
            document.setExternals(
                    new ExternalsDocument(
                            source.externals().tvrage(),
                            source.externals().thetvdb(),
                            source.externals().imdb()
                    )
            );
        }

        if (source.image() != null) {
            document.setImage(
                    new ImageDocument(
                            source.image().medium(),
                            source.image().original()
                    )
            );
        }

        return document;
    }

    public ShowResponse toResponse(ShowDocument source) {

        return new ShowResponse(
                source.getId(),
                source.getUrl(),
                source.getName(),
                source.getType(),
                source.getLanguage(),
                source.getGenres(),
                source.getStatus(),
                source.getRuntime(),
                source.getAverageRuntime(),
                source.getPremiered(),
                source.getEnded(),
                source.getOfficialSite(),
                source.getSchedule() != null
                        ? new TvMazeSchedule(
                        source.getSchedule().time(),
                        source.getSchedule().days()
                )
                        : null,
                source.getRating() != null
                        ? new TvMazeRating(
                        source.getRating().average()
                )
                        : null,
                source.getWeight(),
                source.getNetwork() != null
                        ? new TvMazeNetwork(
                        source.getNetwork().id(),
                        source.getNetwork().name()
                )
                        : null,
                source.getWebChannel() != null
                        ? new TvMazeNetwork(
                        source.getWebChannel().id(),
                        source.getWebChannel().name()
                )
                        : null,
                source.getDvdCountry() != null
                        ? new TvMazeCountry(
                        source.getDvdCountry().name(),
                        source.getDvdCountry().code(),
                        source.getDvdCountry().timezone()
                )
                        : null,
                source.getExternals() != null
                        ? new TvMazeExternals(
                        source.getExternals().tvrage(),
                        source.getExternals().thetvdb(),
                        source.getExternals().imdb()
                )
                        : null,
                source.getImage() != null
                        ? new TvMazeImage(
                        source.getImage().medium(),
                        source.getImage().original()
                )
                        : null,
                source.getSummary(),
                source.getUpdated(),
                source.getLinks()
        );
    }
}
