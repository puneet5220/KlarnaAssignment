
package com.sample.klarna.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sample.klarna.utils.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hourly {

    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("data")
    private List<Currently> data = null;

    public String getSummary() {
        return StringUtils.emptyIfNull(summary);
    }

    public String getIcon() {
        return icon;
    }

    public List<Currently> getData() {
        return data;
    }
}
