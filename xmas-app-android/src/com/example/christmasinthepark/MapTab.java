package com.example.christmasinthepark;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MapTab extends Fragment {
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.map, container, false);
//		TextView textview = (TextView) view.findViewById(R.id.tabtextview);
//		textview.setText(R.string.Map);
		WebView webView = (WebView) view;
		webView.getSettings().setBuiltInZoomControls(true);
		webView.loadUrl("file:///android_asset/htmltest.html");
//		final Button button = (Button) view.findViewById(R.id.pdf);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.christmasinthepark.com/pdfs/Park-Map-2013.pdf"));
//                startActivity(browserIntent);
//            }
//        });
		return view;
	  }
	}