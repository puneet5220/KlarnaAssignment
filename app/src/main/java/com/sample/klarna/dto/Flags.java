
package com.sample.klarna.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flags {

    @JsonProperty("sources")
    private List<String> sources = null;
    @JsonProperty("meteoalarm-license")
    private String meteoalarmLicense;
    @JsonProperty("nearest-station")
    private Float nearestStation;
    @JsonProperty("units")
    private String units;

    public List<String> getSources() {
        return sources;
    }

    public String getMeteoalarmLicense() {
        return meteoalarmLicense;
    }

    public Float getNearestStation() {
        return nearestStation;
    }

    public String getUnits() {
        return units;
    }
}
