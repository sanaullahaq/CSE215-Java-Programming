
public class EventClass extends Members {
	private String eventDate;
	private String eventName;
	private String eventDescription;
	
    /*
     * 
     * 
     * 
     * event class r obj gula array list diye event part e print hbe driver class e 
     * jeta member and admin both dekhte prbe
     */
	public EventClass() {
		this.eventDate=null;
		this.eventName=null;
		this.eventDescription=null;
	}
	public EventClass(String eventDate, String eventName, String eventDescription) {
		this.eventDate = eventDate;
		this.eventName = eventName;
		this.eventDescription=eventDescription;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	@Override
	public String toString() {
		return "eventDate=" + eventDate + "\neventName=" + eventName + "\neventDescription="
				+ eventDescription;
	}
}
