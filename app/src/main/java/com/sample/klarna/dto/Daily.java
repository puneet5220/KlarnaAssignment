
package com.sample.klarna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.klarna.utils.StringUtils;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Daily {

    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("data")
    private List<Data> data;

    public String getSummary() {
        return StringUtils.emptyIfNull(summary);
    }

    public String getIcon() {
        return icon;
    }

    public List<Data> getData() {
        return data;
    }
}
