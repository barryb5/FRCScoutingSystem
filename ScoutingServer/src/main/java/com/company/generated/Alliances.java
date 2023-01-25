
package com.company.generated;

import java.util.HashMap;
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
    "red",
    "blue"
})
@Generated("jsonschema2pojo")
public class Alliances {

    @JsonProperty("red")
    private Red red;
    @JsonProperty("blue")
    private Blue blue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("red")
    public Red getRed() {
        return red;
    }

    @JsonProperty("red")
    public void setRed(Red red) {
        this.red = red;
    }

    @JsonProperty("blue")
    public Blue getBlue() {
        return blue;
    }

    @JsonProperty("blue")
    public void setBlue(Blue blue) {
        this.blue = blue;
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
        sb.append(Alliances.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("red");
        sb.append('=');
        sb.append(((this.red == null)?"<null>":this.red));
        sb.append(',');
        sb.append("blue");
        sb.append('=');
        sb.append(((this.blue == null)?"<null>":this.blue));
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
