
package com.sample.klarna.dto;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.klarna.utils.StringUtils;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponse {

    @JsonProperty("latitude")
    private Float latitude;
    @JsonProperty("longitude")
    private Float longitude;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("currently")
    private Currently currently;
    @JsonProperty("hourly")
    private Hourly hourly;
    @JsonProperty("daily")
    private Daily daily;
    @JsonProperty("alerts")
    private List<Alert> alerts = null;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("offset")
    private Integer offset;

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    @NonNull
    public String getTimezone() {
        return StringUtils.emptyIfNull(timezone);
    }

    public Currently getCurrently() {
        return currently;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public Flags getFlags() {
        return flags;
    }

    public Integer getOffset() {
        return offset;
    }
}
