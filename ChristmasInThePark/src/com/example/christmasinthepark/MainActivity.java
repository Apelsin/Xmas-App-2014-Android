package com.example.christmasinthepark;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;

public class MainActivity extends Activity {
	ActionBar.Tab eventsTab, mapTab, voteTab, aboutUsTab;
	Fragment eventsFragment = new EventsTab();
	Fragment mapFragment = new MapTab();
	Fragment voteFragment = new VoteTab();
	Fragment aboutUsFragment = new AboutUsTab();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        eventsTab = actionBar.newTab().setText("Events");
        mapTab = actionBar.newTab().setText("Map");
        voteTab = actionBar.newTab().setText("Vote");
        aboutUsTab = actionBar.newTab().setText("About Us");
        
        eventsTab.setTabListener(new MyTabListener(eventsFragment));
        mapTab.setTabListener(new MyTabListener(mapFragment));
        voteTab.setTabListener(new MyTabListener(voteFragment));
        aboutUsTab.setTabListener(new MyTabListener(aboutUsFragment));
        
        actionBar.addTab(eventsTab);
        actionBar.addTab(mapTab);
        actionBar.addTab(voteTab);
        actionBar.addTab(aboutUsTab);
    }
}