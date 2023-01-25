
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
    "score",
    "team_keys",
    "surrogate_team_keys",
    "dq_team_keys"
})
@Generated("jsonschema2pojo")
public class Blue {

    @JsonProperty("score")
    private Integer score;
    @JsonProperty("team_keys")
    private List<String> teamKeys = null;
    @JsonProperty("surrogate_team_keys")
    private List<String> surrogateTeamKeys = null;
    @JsonProperty("dq_team_keys")
    private List<String> dqTeamKeys = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("team_keys")
    public List<String> getTeamKeys() {
        return teamKeys;
    }

    @JsonProperty("team_keys")
    public void setTeamKeys(List<String> teamKeys) {
        this.teamKeys = teamKeys;
    }

    @JsonProperty("surrogate_team_keys")
    public List<String> getSurrogateTeamKeys() {
        return surrogateTeamKeys;
    }

    @JsonProperty("surrogate_team_keys")
    public void setSurrogateTeamKeys(List<String> surrogateTeamKeys) {
        this.surrogateTeamKeys = surrogateTeamKeys;
    }

    @JsonProperty("dq_team_keys")
    public List<String> getDqTeamKeys() {
        return dqTeamKeys;
    }

    @JsonProperty("dq_team_keys")
    public void setDqTeamKeys(List<String> dqTeamKeys) {
        this.dqTeamKeys = dqTeamKeys;
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
        sb.append(Blue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("teamKeys");
        sb.append('=');
        sb.append(((this.teamKeys == null)?"<null>":this.teamKeys));
        sb.append(',');
        sb.append("surrogateTeamKeys");
        sb.append('=');
        sb.append(((this.surrogateTeamKeys == null)?"<null>":this.surrogateTeamKeys));
        sb.append(',');
        sb.append("dqTeamKeys");
        sb.append('=');
        sb.append(((this.dqTeamKeys == null)?"<null>":this.dqTeamKeys));
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
