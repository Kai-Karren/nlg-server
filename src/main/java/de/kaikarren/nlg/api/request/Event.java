
package de.kaikarren.nlg.api.request;

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
    "event",
    "timestamp",
    "name",
    "policy",
    "confidence",
    "text",
    "parse_data",
    "input_channel",
    "message_id",
    "metadata"
})
@Generated("jsonschema2pojo")
public class Event {

    @JsonProperty("event")
    private String event;
    @JsonProperty("timestamp")
    private Double timestamp;
    @JsonProperty("name")
    private String name;
    @JsonProperty("policy")
    private Object policy;
    @JsonProperty("confidence")
    private Object confidence;
    @JsonProperty("text")
    private String text;
    @JsonProperty("parse_data")
    private ParseData parseData;
    @JsonProperty("input_channel")
    private String inputChannel;
    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("metadata")
    private Metadata__2 metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(String event) {
        this.event = event;
    }

    @JsonProperty("timestamp")
    public Double getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("policy")
    public Object getPolicy() {
        return policy;
    }

    @JsonProperty("policy")
    public void setPolicy(Object policy) {
        this.policy = policy;
    }

    @JsonProperty("confidence")
    public Object getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(Object confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("parse_data")
    public ParseData getParseData() {
        return parseData;
    }

    @JsonProperty("parse_data")
    public void setParseData(ParseData parseData) {
        this.parseData = parseData;
    }

    @JsonProperty("input_channel")
    public String getInputChannel() {
        return inputChannel;
    }

    @JsonProperty("input_channel")
    public void setInputChannel(String inputChannel) {
        this.inputChannel = inputChannel;
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
    public Metadata__2 getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__2 metadata) {
        this.metadata = metadata;
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
