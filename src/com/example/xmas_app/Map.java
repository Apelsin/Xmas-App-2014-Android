package com.example.xmas_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Map extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		WebView mapView = (WebView) findViewById(R.id.mapView);
		mapView.getSettings().setJavaScriptEnabled(true);
		mapView.getSettings().setBuiltInZoomControls(true);
		mapView.loadUrl("file:///android_asset/html/park-map.html");
		}
}
