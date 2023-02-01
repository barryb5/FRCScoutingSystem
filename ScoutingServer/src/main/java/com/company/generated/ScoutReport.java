
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
    "uuid",
    "tournamentKey",
    "matchKey",
    "scouterName",
    "teamNumber",
    "startTime",
    "autoChallengeResult",
    "events",
    "autoClimbingChallenge",
    "climbingChallenge",
    "challengeResult",
    "robotRole",
    "notes"
})
@Generated("jsonschema2pojo")
public class ScoutReport {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("tournamentKey")
    private String tournamentKey;
    @JsonProperty("matchKey")
    private String matchKey;
    @JsonProperty("scouterName")
    private String scouterName;
    @JsonProperty("teamNumber")
    private Integer teamNumber;
    @JsonProperty("startTime")
    private Integer startTime;
    @JsonProperty("autoChallengeResult")
    private Integer autoChallengeResult;
    @JsonProperty("events")
    private List<List<Integer>> events;
    @JsonProperty("autoClimbingChallenge")
    private Integer autoClimbingChallenge;
    @JsonProperty("climbingChallenge")
    private Integer climbingChallenge;
    @JsonProperty("challengeResult")
    private Integer challengeResult;
    @JsonProperty("robotRole")
    private Integer robotRole;
    @JsonProperty("notes")
    private String notes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("tournamentKey")
    public String getTournamentKey() {
        return tournamentKey;
    }

    @JsonProperty("tournamentKey")
    public void setTournamentKey(String tournamentKey) {
        this.tournamentKey = tournamentKey;
    }

    @JsonProperty("matchKey")
    public String getMatchKey() {
        return matchKey;
    }

    @JsonProperty("matchKey")
    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    @JsonProperty("scouterName")
    public String getScouterName() {
        return scouterName;
    }

    @JsonProperty("scouterName")
    public void setScouterName(String scouterName) {
        this.scouterName = scouterName;
    }

    @JsonProperty("teamNumber")
    public Integer getTeamNumber() {
        return teamNumber;
    }

    @JsonProperty("teamNumber")
    public void setTeamNumber(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }

    @JsonProperty("startTime")
    public Integer getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("autoChallengeResult")
    public Integer getAutoChallengeResult() {
        return autoChallengeResult;
    }

    @JsonProperty("autoChallengeResult")
    public void setAutoChallengeResult(Integer autoChallengeResult) {
        this.autoChallengeResult = autoChallengeResult;
    }

    @JsonProperty("events")
    public List<List<Integer>> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<List<Integer>> events) {
        this.events = events;
    }

    @JsonProperty("autoClimbingChallenge")
    public Integer getAutoClimbingChallenge() {
        return autoClimbingChallenge;
    }

    @JsonProperty("autoClimbingChallenge")
    public void setAutoClimbingChallenge(Integer autoClimbingChallenge) {
        this.autoClimbingChallenge = autoClimbingChallenge;
    }

    @JsonProperty("climbingChallenge")
    public Integer getClimbingChallenge() {
        return climbingChallenge;
    }

    @JsonProperty("climbingChallenge")
    public void setClimbingChallenge(Integer climbingChallenge) {
        this.climbingChallenge = climbingChallenge;
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

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
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
        sb.append(ScoutReport.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uuid");
        sb.append('=');
        sb.append(((this.uuid == null)?"<null>":this.uuid));
        sb.append(',');
        sb.append("tournamentKey");
        sb.append('=');
        sb.append(((this.tournamentKey == null)?"<null>":this.tournamentKey));
        sb.append(',');
        sb.append("matchKey");
        sb.append('=');
        sb.append(((this.matchKey == null)?"<null>":this.matchKey));
        sb.append(',');
        sb.append("scouterName");
        sb.append('=');
        sb.append(((this.scouterName == null)?"<null>":this.scouterName));
        sb.append(',');
        sb.append("teamNumber");
        sb.append('=');
        sb.append(((this.teamNumber == null)?"<null>":this.teamNumber));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("autoChallengeResult");
        sb.append('=');
        sb.append(((this.autoChallengeResult == null)?"<null>":this.autoChallengeResult));
        sb.append(',');
        sb.append("events");
        sb.append('=');
        sb.append(((this.events == null)?"<null>":this.events));
        sb.append(',');
        sb.append("autoClimbingChallenge");
        sb.append('=');
        sb.append(((this.autoClimbingChallenge == null)?"<null>":this.autoClimbingChallenge));
        sb.append(',');
        sb.append("climbingChallenge");
        sb.append('=');
        sb.append(((this.climbingChallenge == null)?"<null>":this.climbingChallenge));
        sb.append(',');
        sb.append("challengeResult");
        sb.append('=');
        sb.append(((this.challengeResult == null)?"<null>":this.challengeResult));
        sb.append(',');
        sb.append("robotRole");
        sb.append('=');
        sb.append(((this.robotRole == null)?"<null>":this.robotRole));
        sb.append(',');
        sb.append("notes");
        sb.append('=');
        sb.append(((this.notes == null)?"<null>":this.notes));
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
