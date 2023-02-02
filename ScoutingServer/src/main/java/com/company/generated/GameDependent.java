
package com.company.generated;

import java.util.LinkedHashMap;
import java.util.List;
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
    "events",
    "autoChallengeResult",
    "challengeResult",
    "robotRole"
})
@Generated("jsonschema2pojo")
public class GameDependent {

    @JsonProperty("events")
    private List<List<Integer>> events;
    @JsonProperty("autoChallengeResult")
    private Integer autoChallengeResult;
    @JsonProperty("challengeResult")
    private Integer challengeResult;
    @JsonProperty("robotRole")
    private Integer robotRole;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("events")
    public List<List<Integer>> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<List<Integer>> events) {
        this.events = events;
    }

    @JsonProperty("autoChallengeResult")
    public Integer getAutoChallengeResult() {
        return autoChallengeResult;
    }

    @JsonProperty("autoChallengeResult")
    public void setAutoChallengeResult(Integer autoChallengeResult) {
        this.autoChallengeResult = autoChallengeResult;
    }

    @JsonProperty("challengeResult")
    public Integer getChallengeResult() {
        return challengeResult;
    }

    @JsonProperty("challengeResult")
    public void setChallengeResult(Integer challengeResult) {
        this.challengeResult = challengeResult;
    }

    @JsonProperty("robotRole")
    public Integer getRobotRole() {
        return robotRole;
    }

    @JsonProperty("robotRole")
    public void setRobotRole(Integer robotRole) {
        this.robotRole = robotRole;
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
        sb.append(GameDependent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("events");
        sb.append('=');
        sb.append(((this.events == null)?"<null>":this.events));
        sb.append(',');
        sb.append("autoChallengeResult");
        sb.append('=');
        sb.append(((this.autoChallengeResult == null)?"<null>":this.autoChallengeResult));
        sb.append(',');
        sb.append("challengeResult");
        sb.append('=');
        sb.append(((this.challengeResult == null)?"<null>":this.challengeResult));
        sb.append(',');
        sb.append("robotRole");
        sb.append('=');
        sb.append(((this.robotRole == null)?"<null>":this.robotRole));
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
