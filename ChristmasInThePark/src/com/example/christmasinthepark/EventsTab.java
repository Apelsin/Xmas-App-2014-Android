package com.example.christmasinthepark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.HashMap;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class EventsTab extends Fragment {
	final  public HashMap<Integer, Event> eventsMap = new HashMap<Integer, Event>();
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.events, container, false);

		final ListView listView = (ListView) view.findViewById(R.id.listView);
		/*eventsMap.put(0, new Event("Event 1 Title", "Location 1","time"));
		eventsMap.put(1, new Event("Event 2 Title", "Location 2","time"));
		eventsMap.put(2, new Event("Event 3 Title", "Location 3","time"));
		eventsMap.put(3, new Event("Event 4 Title", "Location 4","time"));
		eventsMap.put(4, new Event("Event 5 Title", "Location 5","time"));
		eventsMap.put(5, new Event("Event 6 Title", "Location 6","time"));*/
		addEvents(eventsMap);
		
		 listView.setOnItemClickListener(new OnItemClickListener() {
			 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
	              int itemPosition = arg2;
	              Intent intent = new Intent(Intent.ACTION_INSERT);
	        		intent.setType("vnd.android.cursor.item/event");
	        		intent.putExtra(Events.TITLE, eventsMap.get(itemPosition).title);
	        		intent.putExtra(Events.EVENT_LOCATION, eventsMap.get(itemPosition).location);
	        		
	        		GregorianCalendar calDate = new GregorianCalendar(2012, 10, 02);
	        		intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
	        		  calDate.getTimeInMillis());
	        		// make it a recurring Event
	        		//intent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT=11;WKST=SU;BYDAY=TU,TH");
	        		// Making it private and shown as busy
	        		intent.putExtra(Events.ACCESS_LEVEL, Events.ACCESS_PRIVATE);
	        		intent.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY); 
	        		startActivity(intent);
			}
     }); 

        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), eventsMap);
        listView.setAdapter(adapter); 
		return view;
		
	  }
	  

	public void addEvents(HashMap<Integer, Event> eventsMap){
		String [] event=EventList.events.split("#");
		for(int i=0;i<event.length&&event[i]!=null;i++){
			String[] input = event[i].split(";");
			Event e=new Event(input[0].trim(),input[1].trim(), input[2].trim());
			eventsMap.put(i, e);
		}
		
	}
}