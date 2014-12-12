package com.example.xmas_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.androidannotations.annotations.*;
import org.androidannotations.annotations.res.*;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity
{
	// Social
	@ViewById Button btnFacebook;
	@ViewById Button btnTwitter;
	@ViewById Button btnSiteSocial;
	@ViewById Button btnPinterest;
	@ViewById Button btnYouTube;
	
	// Main Menu
	@ViewById Button btnGetInvolved;
	@ViewById Button btnVote;
	@ViewById Button btnSponsors;
	@ViewById Button btnEventSchedule;
	@ViewById Button btnVisitorInfo;
	@ViewById Button btnParkMap;
	@ViewById Button btnDonate;
	
	// Visitor Info
//	@ViewById Button btnFAQ;
//	@ViewById Button btnNovelty;
//	@ViewById Button btnEatsTreats;
//	@ViewById Button btnSite;
//	@ViewById Button btnPartners;
//	@ViewById Button btnParkingDirections;
	
	protected Button[] allOrnamentButtons()
	{
		return new Button[] {
			btnGetInvolved,
			btnVote,
			btnSponsors,
			btnEventSchedule,
			btnVisitorInfo,
			btnParkMap,
//			btnFAQ,
//			btnNovelty,
//			btnEatsTreats,
//			btnSite,
//			btnPartners,
//			btnParkingDirections,
		};
	}
	
	@ViewById WebView wvAboutUs;
	
	@StringRes String fontOrnamentButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        //initialOnclick();
        
        // Setup about us tab
        wvAboutUs.loadUrl("file:///android_asset/html/about.html");
        
    }
    public void initial()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontOrnamentButton);
        
        Button[] buttons = allOrnamentButtons();
        for (Button button : buttons) {
			button.setTypeface(typeface);
		}
        
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
    	btnParkMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.MAP");
				startActivity(intent);
			}
		});
    	btnGetInvolved.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://christmasinthepark.com/volunteer.html");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnVote.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
			}
		});
    	btnSponsors.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://christmasinthepark.com/sponsors.html");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnEventSchedule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.EVENT");
				startActivity(intent);
			}
		});
    	btnVisitorInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("android.intent.action.VISTORINFO");
				startActivity(intent);
			}
		});
    	btnDonate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PNSZ7WHRJ333W");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnSiteSocial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://christmasinthepark.com/");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnTwitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("https://twitter.com/xmasintheparksj");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnFacebook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("https://www.facebook.com/ChristmasintheParkSJ");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnPinterest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://www.pinterest.com/CITPSJ/");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    	btnYouTube.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("https://www.youtube.com/user/xmasinthepark");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(intent);
			}
		});
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
    	IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                
                Uri uri = Uri.parse(contents);
				 Intent newintent = new Intent(Intent.ACTION_VIEW, uri);
				 startActivity(newintent);
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast toast = Toast.makeText(this, "Scan was Cancelled!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
            }
        }
         
    }

    
}
