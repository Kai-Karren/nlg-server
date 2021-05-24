
package de.kaikarren.nlg.api.request;

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
    "intent",
    "entities",
    "text",
    "message_id",
    "metadata",
    "intent_ranking"
})
@Generated("jsonschema2pojo")
public class ParseData {

    @JsonProperty("intent")
    private Intent__1 intent;
    @JsonProperty("entities")
    private List<Object> entities = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("metadata")
    private Metadata__1 metadata;
    @JsonProperty("intent_ranking")
    private List<IntentRanking__1> intentRanking = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("intent")
    public Intent__1 getIntent() {
        return intent;
    }

    @JsonProperty("intent")
    public void setIntent(Intent__1 intent) {
        this.intent = intent;
    }

    @JsonProperty("entities")
    public List<Object> getEntities() {
        return entities;
    }

    @JsonProperty("entities")
    public void setEntities(List<Object> entities) {
        this.entities = entities;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("message_id")
    public String getMessageId() {
        return messageId;
    }

    @JsonProperty("message_id")
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @JsonProperty("metadata")
    public Metadata__1 getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__1 metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("intent_ranking")
    public List<IntentRanking__1> getIntentRanking() {
        return intentRanking;
    }

    @JsonProperty("intent_ranking")
    public void setIntentRanking(List<IntentRanking__1> intentRanking) {
        this.intentRanking = intentRanking;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
