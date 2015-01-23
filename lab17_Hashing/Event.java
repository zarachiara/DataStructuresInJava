public class Event {
    private String eventName;
    
    public Event(String eventName) {
        this.eventName = eventName;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    public boolean equals(Object otherEvent)
    {
    	return otherEvent instanceof Event && this.eventName.equals(((Event)otherEvent).eventName);
    }
    
    // may need to implement additional methods
}