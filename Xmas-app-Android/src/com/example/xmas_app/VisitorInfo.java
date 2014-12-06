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
import android.widget.Button;

public class VisitorInfo extends Activity {
Button FAQs, parking, stores, partners, eatsTreat;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visitor_info);
		initialButton();
		initialOnClick();
	}
	public void initialButton(){
		FAQs = (Button)findViewById(R.id.FAQsButton);
		parking = (Button)findViewById(R.id.ParkingButton);
		stores = (Button)findViewById(R.id.StoresButton);
		partners = (Button)findViewById(R.id.PartnerButton);
		eatsTreat = (Button)findViewById(R.id.EatsTreatButton);
		
		
		//font
		String fontPath = "font.ttf";
        Typeface tf = Typeface.createFromAsset(VisitorInfo.this.getResources().getAssets(), fontPath);
        FAQs.setTypeface(tf);
        parking.setTypeface(tf);
        stores.setTypeface(tf);
        partners.setTypeface(tf);
        eatsTreat.setTypeface(tf);
	}
	public void initialOnClick(){
		FAQs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.FAQS");
				startActivity(intent);
			}
		});
		
		parking.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.PARKINGDIRECTION");
				startActivity(intent);
			}
		});
		stores.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://christmasinthepark.com/vendors.html");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
		partners.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://christmasinthepark.com/partners.html");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
		eatsTreat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://christmasinthepark.com/lodging.html");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
		
	}
	
	
}
