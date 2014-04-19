package com.example.christmasinthepark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.apache.http.cookie.Cookie;

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
	final static public HashMap<Integer, Event> eventsMap = new HashMap<Integer, Event>();
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.events, container, false);

		final ListView listView = (ListView) view.findViewById(R.id.listView);
		eventsMap.put(0, new Event("Event 1 Title", "Location 1"));
		eventsMap.put(1, new Event("Event 2 Title", "Location 2"));
		eventsMap.put(2, new Event("Event 3 Title", "Location 3"));
		eventsMap.put(3, new Event("Event 4 Title", "Location 4"));
		
		 listView.setOnItemClickListener(new OnItemClickListener() {
			 
            // public void onItemClick(SimpleAdapter<?> parent, View view,int position, long id) {
               

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// ListView Clicked item index
	              int itemPosition     = arg2;
	              // ListView Clicked item value
	             // String  itemValue    = (String) listView.getItemAtPosition(arg2);
	     //Toast.makeText(getApplicationContext(),"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();
	              Intent intent = new Intent(Intent.ACTION_INSERT);
	        		intent.setType("vnd.android.cursor.item/event");
	        		intent.putExtra(Events.TITLE, eventsMap.get(itemPosition).title);
	        		intent.putExtra(Events.EVENT_LOCATION, eventsMap.get(itemPosition).location);
	        		intent.putExtra(Events.DESCRIPTION, "Event Description");
	        		// Setting dates
	        		GregorianCalendar calDate = new GregorianCalendar(2012, 10, 02);
	        		intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
	        		  calDate.getTimeInMillis());
	        		intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
	        		  calDate.getTimeInMillis());
	        		// make it a full day event
	        		intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
	        		// make it a recurring Event
	        		intent.putExtra(Events.RRULE, "FREQ=WEEKLY;COUNT=11;WKST=SU;BYDAY=TU,TH");
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
	  
	  public static void read() {
			try {
				String pathname = "eventList";
				File filename = new File(pathname);
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(filename));
				BufferedReader br = new BufferedReader(reader);

				String line = "";
				line = br.readLine();
				if (line != null) {
					int caseCount = Integer.parseInt(line);
					for (int i = 1; i <= caseCount; i++) {
						line = br.readLine();
						if (line != null) {
							String[] input = line.split(";");
							Event e=new Event(input[0],input[1]);
							eventsMap.put(i-1, e);
							//out.write(output + "\r\n"); // \r\n
						}
					}
					br.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
