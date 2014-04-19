package com.example.christmasinthepark;

public class Event {
	public String title = "";
	public String location;
	public String time;
	public Event(String title, String location, String time){
		this.title=title;
		this.location=location;
		this.time = time;
	}
	
	
	
	public static String events = 
			
			"Event 1 Title;   Location 2;     12/20/2014, 10:30"+
			"#Event 2 Title;   Location 2;    12/20/2014, 12:30"   + 
			"#Event 3 Title;   Location 3;    12/20/2014, 10:30"   +
			"#Event 4 Title;   Location 4;    12/20/2014, 10:30"   +
			"#Event 5 Title;   Location 5;    12/20/2014, 10:30"   +
			"#Event 6 Title;   Location 6;    12/20/2014, 10:30"   +
			
			//Add new events here like the previous line
			
			"";

}
