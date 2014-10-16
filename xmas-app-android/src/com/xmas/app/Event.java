package com.xmas.app;

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
			
			"Fun in the Summer;   Christmas in the Park;     6/25/2014, 17:30"+
			"#Christmas in July;   Circle of Palms, Santa's Ho-Ho-Ho-Down!;    7/19/2014, 17:30"   + 
			"#A Nightmare Before Christmas in the Park;   Christmas in the Park warehouse;    10/25/2014, 19:00"   +
			"#Event 4 Title;   Location 4;    12/20/2014, 10:30"   +
			"#Event 5 Title;   Location 5;    12/20/2014, 10:30"   +
			"#Event 6 Title;   Location 6;    12/20/2014, 10:30"   +
			
			//Add new events here like the previous line:   #title; location; time
			
			"";
}
