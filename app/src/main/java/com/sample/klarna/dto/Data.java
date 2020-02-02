
package com.sample.klarna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("time")
    private Integer time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sunriseTime")
    private Integer sunriseTime;
    @JsonProperty("sunsetTime")
    private Integer sunsetTime;
    @JsonProperty("moonPhase")
    private Float moonPhase;
    @JsonProperty("precipIntensity")
    private Float precipIntensity;
    @JsonProperty("precipIntensityMax")
    private Float precipIntensityMax;
    @JsonProperty("precipIntensityMaxTime")
    private Integer precipIntensityMaxTime;
    @JsonProperty("precipProbability")
    private Float precipProbability;
    @JsonProperty("precipType")
    private String precipType;
    @JsonProperty("temperatureHigh")
    private Float temperatureHigh;
    @JsonProperty("temperatureHighTime")
    private Integer temperatureHighTime;
    @JsonProperty("temperatureLow")
    private Float temperatureLow;
    @JsonProperty("temperatureLowTime")
    private Integer temperatureLowTime;
    @JsonProperty("apparentTemperatureHigh")
    private Float apparentTemperatureHigh;
    @JsonProperty("apparentTemperatureHighTime")
    private Integer apparentTemperatureHighTime;
    @JsonProperty("apparentTemperatureLow")
    private Float apparentTemperatureLow;
    @JsonProperty("apparentTemperatureLowTime")
    private Integer apparentTemperatureLowTime;
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
    @JsonProperty("windGustTime")
    private Integer windGustTime;
    @JsonProperty("windBearing")
    private Integer windBearing;
    @JsonProperty("cloudCover")
    private Float cloudCover;
    @JsonProperty("uvIndex")
    private Integer uvIndex;
    @JsonProperty("uvIndexTime")
    private Integer uvIndexTime;
    @JsonProperty("visibility")
    private Float visibility;
    @JsonProperty("ozone")
    private Float ozone;
    @JsonProperty("temperatureMin")
    private Float temperatureMin;
    @JsonProperty("temperatureMinTime")
    private Integer temperatureMinTime;
    @JsonProperty("temperatureMax")
    private Float temperatureMax;
    @JsonProperty("temperatureMaxTime")
    private Integer temperatureMaxTime;
    @JsonProperty("apparentTemperatureMin")
    private Float apparentTemperatureMin;
    @JsonProperty("apparentTemperatureMinTime")
    private Integer apparentTemperatureMinTime;
    @JsonProperty("apparentTemperatureMax")
    private Float apparentTemperatureMax;
    @JsonProperty("apparentTemperatureMaxTime")
    private Integer apparentTemperatureMaxTime;
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

    public Integer getSunriseTime() {
        return sunriseTime;
    }

    public Integer getSunsetTime() {
        return sunsetTime;
    }

    public Float getMoonPhase() {
        return moonPhase;
    }

    public Float getPrecipIntensity() {
        return precipIntensity;
    }

    public Float getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public Integer getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public Float getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public Float getTemperatureHigh() {
        return temperatureHigh;
    }

    public Integer getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public Float getTemperatureLow() {
        return temperatureLow;
    }

    public Integer getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public Float getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public Integer getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public Float getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public Integer getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
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

    public Integer getWindGustTime() {
        return windGustTime;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public Float getCloudCover() {
        return cloudCover;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public Integer getUvIndexTime() {
        return uvIndexTime;
    }

    public Float getVisibility() {
        return visibility;
    }

    public Float getOzone() {
        return ozone;
    }

    public Float getTemperatureMin() {
        return temperatureMin;
    }

    public Integer getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public Float getTemperatureMax() {
        return temperatureMax;
    }

    public Integer getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public Float getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public Integer getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public Float getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public Integer getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public Float getPrecipAccumulation() {
        return precipAccumulation;
    }
}
