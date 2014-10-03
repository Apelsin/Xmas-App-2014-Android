package com.example.christmasinthepark;

import java.util.HashMap;

import android.app.Activity;
import android.provider.CalendarContract.Events;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class SimpleAdapter extends BaseAdapter {
	   HashMap<Integer, Event> eventsMap = new HashMap<Integer, Event>();
	   Activity context;
	   public SimpleAdapter(Activity context, HashMap<Integer, Event> eventsMap)  {
	       this.context = context;
	       this.eventsMap = eventsMap;
	   }
	 
	@Override
	public int getCount() {
		return eventsMap.size();
	}
	@Override
	public Object getItem(int arg0) {
		return eventsMap.get(arg0);
	}
	@Override
	public long getItemId(int arg0) {
		return arg0;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		View view = convertView; // re-use an existing view, if one is supplied
		   if (view == null) {// otherwise create a new one
			   holder = new ViewHolder();
			   view =LayoutInflater.from(context).inflate(R.layout.list, null);//LayoutInflater.inflate(context, R.layout.list, parent);
			   holder.title = (TextView)view.findViewById(R.id.text1);
		  view.setTag(holder);
		   }else{
			   
                   holder = (ViewHolder)convertView.getTag();//取出ViewHolder对象
		   }
		   String text ="<b>Event</b>: "+this.eventsMap.get(position).title+"<br><b>Location</b>: "
				   +this.eventsMap.get(position).location+"<br><b>Time</b>: "+this.eventsMap.get(position).time;
				   
		   holder.title.setText(Html.fromHtml(text));
		   return view;
		
	}
	
	}
