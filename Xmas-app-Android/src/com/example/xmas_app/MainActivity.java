package com.example.xmas_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {
	Button parkMap, getInvolved, vote, sponsor, eventschedule, vistor,donation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        initialOnclick();
        
        //setup about us tab
        WebView aboutusView = (WebView) findViewById(R.id.AboutUswebView);
        aboutusView.getSettings().setJavaScriptEnabled(true);
        aboutusView.getSettings().setBuiltInZoomControls(true);
        aboutusView.loadUrl("file:///android_asset/html/about.html");
        
    }
    public void initial(){
    	//initial for buttons
    	parkMap = (Button) findViewById(R.id.map);
        getInvolved = (Button) findViewById(R.id.involved);
        vote = (Button) findViewById(R.id.vote);
        sponsor = (Button) findViewById(R.id.sponsors);
        eventschedule = (Button) findViewById(R.id.schedule);
        vistor = (Button) findViewById(R.id.info);
        donation = (Button)findViewById(R.id.donationButton);
        
        //initial for font
        String fontPath = "font.ttf";
        Typeface tf = Typeface.createFromAsset(MainActivity.this.getResources().getAssets(), fontPath);
        parkMap.setTypeface(tf);
        getInvolved.setTypeface(tf);
        vote.setTypeface(tf);
        sponsor.setTypeface(tf);
        eventschedule.setTypeface(tf);
        vistor.setTypeface(tf);
        
        //initial for tabs
        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();
        TabSpec specs1 = tabs.newTabSpec("tag1");
        specs1.setContent(R.id.tab1);
        specs1.setIndicator("Home");
        tabs.addTab(specs1);
        //second tab
        TabSpec specs2 = tabs.newTabSpec("tag2");
        specs2.setContent(R.id.tab2);
        specs2.setIndicator("About us");
        tabs.addTab(specs2);
    }
    
    
    public void initialOnclick(){
    	parkMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.MAP");
				startActivity(intent);
			}
		});
    	getInvolved.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.GETINVOLVED");
				startActivity(intent);
			}
		});
    	vote.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.VOTE");
				startActivity(intent);
			}
		});
    	sponsor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.SPONSORS");
				startActivity(intent);
			}
		});
    	eventschedule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.EVENT");
				startActivity(intent);
			}
		});
    	vistor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.VISTORINFO");
				startActivity(intent);
			}
		});
    	donation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PNSZ7WHRJ333W");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    }

    
    
    
    
}
