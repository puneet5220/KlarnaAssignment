
package com.sample.klarna.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert {

    @JsonProperty("title")
    private String title;
    @JsonProperty("regions")
    private List<String> regions = null;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("expires")
    private Integer expires;
    @JsonProperty("description")
    private String description;
    @JsonProperty("uri")
    private String uri;

    public String getTitle() {
        return title;
    }

    public List<String> getRegions() {
        return regions;
    }

    public String getSeverity() {
        return severity;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getExpires() {
        return expires;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }
}
