
package com.sample.klarna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Datum {

    @JsonProperty("time")
    private Integer time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("precipIntensity")
    private Integer precipIntensity;
    @JsonProperty("precipProbability")
    private Integer precipProbability;
    @JsonProperty("temperature")
    private Float temperature;
    @JsonProperty("apparentTemperature")
    private Float apparentTemperature;
    @JsonProperty("dewPoint")
    private Float dewPoint;
    @JsonProperty("humidity")
    private Float humidity;
    @JsonProperty("pressure")
    private Float pressure;
    @JsonProperty("windSpeed")
    private Float windSpeed;
    @JsonProperty("windGust")
    private Float windGust;
    @JsonProperty("windBearing")
    private Integer windBearing;
    @JsonProperty("cloudCover")
    private Integer cloudCover;
    @JsonProperty("uvIndex")
    private Integer uvIndex;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("ozone")
    private Float ozone;
    @JsonProperty("precipType")
    private String precipType;
    @JsonProperty("precipAccumulation")
    private Float precipAccumulation;

    public Integer getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getPrecipIntensity() {
        return precipIntensity;
    }

    public Integer getPrecipProbability() {
        return precipProbability;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getApparentTemperature() {
        return apparentTemperature;
    }

    public Float getDewPoint() {
        return dewPoint;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public Float getWindGust() {
        return windGust;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Float getOzone() {
        return ozone;
    }

    public String getPrecipType() {
        return precipType;
    }

    public Float getPrecipAccumulation() {
        return precipAccumulation;
    }
}
