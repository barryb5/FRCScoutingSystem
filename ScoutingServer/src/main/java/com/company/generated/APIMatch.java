
package com.company.generated;

import java.util.HashMap;
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
    "key",
    "comp_level",
    "set_number",
    "match_number",
    "alliances",
    "winning_alliance",
    "event_key",
    "time",
    "actual_time",
    "predicted_time",
    "post_result_time",
    "score_breakdown",
    "videos"
})
@Generated("jsonschema2pojo")
public class APIMatch {

    @JsonProperty("key")
    private String key;
    @JsonProperty("comp_level")
    private String compLevel;
    @JsonProperty("set_number")
    private Integer setNumber;
    @JsonProperty("match_number")
    private Integer matchNumber;
    @JsonProperty("alliances")
    private Alliances alliances;
    @JsonProperty("winning_alliance")
    private String winningAlliance;
    @JsonProperty("event_key")
    private String eventKey;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("actual_time")
    private Integer actualTime;
    @JsonProperty("predicted_time")
    private Integer predictedTime;
    @JsonProperty("post_result_time")
    private Integer postResultTime;
    @JsonProperty("score_breakdown")
    private ScoreBreakdown scoreBreakdown;
    @JsonProperty("videos")
    private List<Video> videos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("comp_level")
    public String getCompLevel() {
        return compLevel;
    }

    @JsonProperty("comp_level")
    public void setCompLevel(String compLevel) {
        this.compLevel = compLevel;
    }

    @JsonProperty("set_number")
    public Integer getSetNumber() {
        return setNumber;
    }

    @JsonProperty("set_number")
    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    @JsonProperty("match_number")
    public Integer getMatchNumber() {
        return matchNumber;
    }

    @JsonProperty("match_number")
    public void setMatchNumber(Integer matchNumber) {
        this.matchNumber = matchNumber;
    }

    @JsonProperty("alliances")
    public Alliances getAlliances() {
        return alliances;
    }

    @JsonProperty("alliances")
    public void setAlliances(Alliances alliances) {
        this.alliances = alliances;
    }

    @JsonProperty("winning_alliance")
    public String getWinningAlliance() {
        return winningAlliance;
    }

    @JsonProperty("winning_alliance")
    public void setWinningAlliance(String winningAlliance) {
        this.winningAlliance = winningAlliance;
    }

    @JsonProperty("event_key")
    public String getEventKey() {
        return eventKey;
    }

    @JsonProperty("event_key")
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonProperty("actual_time")
    public Integer getActualTime() {
        return actualTime;
    }

    @JsonProperty("actual_time")
    public void setActualTime(Integer actualTime) {
        this.actualTime = actualTime;
    }

    @JsonProperty("predicted_time")
    public Integer getPredictedTime() {
        return predictedTime;
    }

    @JsonProperty("predicted_time")
    public void setPredictedTime(Integer predictedTime) {
        this.predictedTime = predictedTime;
    }

    @JsonProperty("post_result_time")
    public Integer getPostResultTime() {
        return postResultTime;
    }

    @JsonProperty("post_result_time")
    public void setPostResultTime(Integer postResultTime) {
        this.postResultTime = postResultTime;
    }

    @JsonProperty("score_breakdown")
    public ScoreBreakdown getScoreBreakdown() {
        return scoreBreakdown;
    }

    @JsonProperty("score_breakdown")
    public void setScoreBreakdown(ScoreBreakdown scoreBreakdown) {
        this.scoreBreakdown = scoreBreakdown;
    }

    @JsonProperty("videos")
    public List<Video> getVideos() {
        return videos;
    }

    @JsonProperty("videos")
    public void setVideos(List<Video> videos) {
        this.videos = videos;
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
        sb.append(APIMatch.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("compLevel");
        sb.append('=');
        sb.append(((this.compLevel == null)?"<null>":this.compLevel));
        sb.append(',');
        sb.append("setNumber");
        sb.append('=');
        sb.append(((this.setNumber == null)?"<null>":this.setNumber));
        sb.append(',');
        sb.append("matchNumber");
        sb.append('=');
        sb.append(((this.matchNumber == null)?"<null>":this.matchNumber));
        sb.append(',');
        sb.append("alliances");
        sb.append('=');
        sb.append(((this.alliances == null)?"<null>":this.alliances));
        sb.append(',');
        sb.append("winningAlliance");
        sb.append('=');
        sb.append(((this.winningAlliance == null)?"<null>":this.winningAlliance));
        sb.append(',');
        sb.append("eventKey");
        sb.append('=');
        sb.append(((this.eventKey == null)?"<null>":this.eventKey));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("actualTime");
        sb.append('=');
        sb.append(((this.actualTime == null)?"<null>":this.actualTime));
        sb.append(',');
        sb.append("predictedTime");
        sb.append('=');
        sb.append(((this.predictedTime == null)?"<null>":this.predictedTime));
        sb.append(',');
        sb.append("postResultTime");
        sb.append('=');
        sb.append(((this.postResultTime == null)?"<null>":this.postResultTime));
        sb.append(',');
        sb.append("scoreBreakdown");
        sb.append('=');
        sb.append(((this.scoreBreakdown == null)?"<null>":this.scoreBreakdown));
        sb.append(',');
        sb.append("videos");
        sb.append('=');
        sb.append(((this.videos == null)?"<null>":this.videos));
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
