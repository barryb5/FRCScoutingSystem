
package com.company.generated;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchKey",
    "key",
    "status"
})
@Generated("jsonschema2pojo")
public class MatchScoutedStatus {

    public MatchScoutedStatus(String matchKey, String key) {
        this.matchKey = matchKey;
        this.key = key;
        status = true;
    }

    public MatchScoutedStatus(String key) {
        this.key = key;
        status = false;
    }


    @JsonProperty("matchKey")
    private String matchKey;
    @JsonProperty("key")
    private String key;
    @JsonProperty("status")
    private Boolean status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("matchKey")
    public String getMatchKey() {
        return matchKey;
    }

    @JsonProperty("matchKey")
    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MatchScoutedStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("matchKey");
        sb.append('=');
        sb.append(((this.matchKey == null)?"<null>":this.matchKey));
        sb.append(',');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
