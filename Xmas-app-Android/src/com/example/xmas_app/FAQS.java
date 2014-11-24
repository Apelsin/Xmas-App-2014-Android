package com.example.xmas_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class FAQS extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faqs);
		WebView FAQView = (WebView)findViewById(R.id.FAQSView);
		FAQView.getSettings().setJavaScriptEnabled(true);
		FAQView.getSettings().setBuiltInZoomControls(true);
		FAQView.loadUrl("file:///android_asset/html/faq.html");
	}
}
