
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
    "sender_id",
    "slots",
    "latest_message",
    "latest_event_time",
    "followup_action",
    "paused",
    "events",
    "latest_input_channel",
    "active_loop",
    "latest_action_name"
})
@Generated("jsonschema2pojo")
public class Tracker {

    @JsonProperty("sender_id")
    private String senderId;
    @JsonProperty("slots")
    private Slots slots;
    @JsonProperty("latest_message")
    private LatestMessage latestMessage;
    @JsonProperty("latest_event_time")
    private Double latestEventTime;
    @JsonProperty("followup_action")
    private Object followupAction;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("events")
    private List<Event> events = null;
    @JsonProperty("latest_input_channel")
    private String latestInputChannel;
    @JsonProperty("active_loop")
    private ActiveLoop activeLoop;
    @JsonProperty("latest_action_name")
    private String latestActionName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sender_id")
    public String getSenderId() {
        return senderId;
    }

    @JsonProperty("sender_id")
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @JsonProperty("slots")
    public Slots getSlots() {
        return slots;
    }

    @JsonProperty("slots")
    public void setSlots(Slots slots) {
        this.slots = slots;
    }

    @JsonProperty("latest_message")
    public LatestMessage getLatestMessage() {
        return latestMessage;
    }

    @JsonProperty("latest_message")
    public void setLatestMessage(LatestMessage latestMessage) {
        this.latestMessage = latestMessage;
    }

    @JsonProperty("latest_event_time")
    public Double getLatestEventTime() {
        return latestEventTime;
    }

    @JsonProperty("latest_event_time")
    public void setLatestEventTime(Double latestEventTime) {
        this.latestEventTime = latestEventTime;
    }

    @JsonProperty("followup_action")
    public Object getFollowupAction() {
        return followupAction;
    }

    @JsonProperty("followup_action")
    public void setFollowupAction(Object followupAction) {
        this.followupAction = followupAction;
    }

    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    @JsonProperty("events")
    public List<Event> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @JsonProperty("latest_input_channel")
    public String getLatestInputChannel() {
        return latestInputChannel;
    }

    @JsonProperty("latest_input_channel")
    public void setLatestInputChannel(String latestInputChannel) {
        this.latestInputChannel = latestInputChannel;
    }

    @JsonProperty("active_loop")
    public ActiveLoop getActiveLoop() {
        return activeLoop;
    }

    @JsonProperty("active_loop")
    public void setActiveLoop(ActiveLoop activeLoop) {
        this.activeLoop = activeLoop;
    }

    @JsonProperty("latest_action_name")
    public String getLatestActionName() {
        return latestActionName;
    }

    @JsonProperty("latest_action_name")
    public void setLatestActionName(String latestActionName) {
        this.latestActionName = latestActionName;
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
