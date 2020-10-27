package com.example.localstackclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Url data holder.
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = {"id", "url"})
@ToString(of = {"id", "url", "domain", "type", "status", "removalValidation"})
public class UrlData {
    /**
     * The domain where the data comes from.
     */
    private String domain;

    /**
     * Url type.
     */
    private String type;

    /**
     * Id from result_data_v2.
     */
    private Integer id;

    /**
     * Url string.
     */
    private String url;

    /**
     * Headers used in the request.
     */
    @JsonIgnore
    private Map<String, String> headers;

    /**
     * Text to compare with the response Html.
     */
    private List<String> textToCompare;

    /**
     * Timestamp to last update.
     */
    private String lastUpdateTime;

    /**
     * Direct url.
     */
    private String finalUrl;

    /**
     * Link status.
     */
    private Integer status;

    /**
     * Indicate if the site was crawled to validate that the movie was removed.
     */
    private boolean removalValidation;

    /**
     * HTTP status.
     */
    private int httpStatus;

    /**
     * Selector data on the infringing web page.
     */
    @JsonIgnore
    private String selectorData;

    /**
     * Useful message for tracing.
     */
    private String message;

    /**
     * HTML text from response.
     */
    @Nullable
    private String htmlContent;

    /**
    * Record invalid status date.
    * */
    private String removedAt;

    /**
     * Crawler Domain Id
     */
    private Integer domainId;

}
