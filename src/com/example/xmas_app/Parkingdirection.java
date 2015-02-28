package com.example.xmas_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Parkingdirection extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parkingdirection);
		WebView parkingView = (WebView)findViewById(R.id.parkingView);
		parkingView.getSettings().setJavaScriptEnabled(true);
		parkingView.getSettings().setBuiltInZoomControls(true);
		parkingView.loadUrl("file:///android_asset/html/parking-directions.html");
	}
}
