package com.example.xmas_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class EventSchedule extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_schedule);
		
		WebView scheduleView = (WebView) findViewById(R.id.scheduleView);
		scheduleView.getSettings().setJavaScriptEnabled(true);
		scheduleView.getSettings().setBuiltInZoomControls(true);
		scheduleView.loadUrl("file:///android_asset/html/event-schedule.html");
	}
}
