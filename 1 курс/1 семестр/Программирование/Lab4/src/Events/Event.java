package Events;

public abstract class Event {
    private final EventType eventType;

    protected Event(EventType eventType){
        this.eventType = eventType;
    }

    public EventType getEventType(){return eventType;}
}
