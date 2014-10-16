package com.xmas.app;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AboutUsTab extends Fragment {
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.about, container, false);
		final Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=Q5QS4M4QPR5HE"));
                startActivity(browserIntent);
            }
        });
        
        final TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(Html.fromHtml("<u>Info: (408) 200-3800</u>"));
        phone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent callIntent = new Intent(Intent.ACTION_CALL);
            	callIntent.setData(Uri.parse("tel:4082003800"));
            	callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
            	startActivity(callIntent);
            }
        });
        
        TextView feedback = (TextView) view.findViewById(R.id.email);
        feedback.setText(Html.fromHtml("<a href=\"mailto:info@christmasinthepark.com\">Email: info@christmasinthepark.com</a>"));
        feedback.setMovementMethod(LinkMovementMethod.getInstance());
        
//		TextView textview = (TextView) view.findViewById(R.id.tabtextview);
//		textview.setText(R.string.AboutUs);
		return view;
	  }
	}