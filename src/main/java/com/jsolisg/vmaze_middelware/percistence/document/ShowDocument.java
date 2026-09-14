package com.jsolisg.vmaze_middelware.percistence.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection  = "shows")
public class ShowDocument {
    @Id
    private Long id;

    private String url;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private Integer runtime;
    private Integer averageRuntime;
    private String premiered;
    private String ended;
    private String officialSite;
    private ScheduleDocument schedule;
    private RatingDocument rating;
    private Double weight;
    private NetworkDocument network;
    private NetworkDocument webChannel;
    private CountryDocument dvdCountry;
    private ExternalsDocument externals;
    private ImageDocument image;
    private String summary;
    private Long updated;
    private Map<String, Object> links;

    public ShowDocument() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Integer getAverageRuntime() {
        return averageRuntime;
    }

    public void setAverageRuntime(Integer averageRuntime) {
        this.averageRuntime = averageRuntime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public ScheduleDocument getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDocument schedule) {
        this.schedule = schedule;
    }

    public RatingDocument getRating() {
        return rating;
    }

    public void setRating(RatingDocument rating) {
        this.rating = rating;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public NetworkDocument getNetwork() {
        return network;
    }

    public void setNetwork(NetworkDocument network) {
        this.network = network;
    }

    public NetworkDocument getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(NetworkDocument webChannel) {
        this.webChannel = webChannel;
    }

    public CountryDocument getDvdCountry() {
        return dvdCountry;
    }

    public void setDvdCountry(CountryDocument dvdCountry) {
        this.dvdCountry = dvdCountry;
    }

    public ExternalsDocument getExternals() {
        return externals;
    }

    public void setExternals(ExternalsDocument externals) {
        this.externals = externals;
    }

    public ImageDocument getImage() {
        return image;
    }

    public void setImage(ImageDocument image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Map<String, Object> getLinks() {
        return links;
    }

    public void setLinks(Map<String, Object> links) {
        this.links = links;
    }
}
