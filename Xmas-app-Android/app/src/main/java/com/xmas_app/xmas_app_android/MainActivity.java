package com.xmas_app.xmas_app_android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button parkMap = (Button) this.findViewById(R.id.map);
    Button getInvolved = (Button) this.findViewById(R.id.involved);
    Button vote = (Button) this.findViewById(R.id.vote);
    Button sponsor = (Button) this.findViewById(R.id.sponsors);
    Button eventschedule = (Button) this.findViewById(R.id.schedule);
    Button vistor = (Button) this.findViewById(R.id.info);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();

    }


    public void initial(){
        String fontPath = "font.ttf";
        Typeface tf = Typeface.createFromAsset(MainActivity.this.getResources().getAssets(), fontPath);
        parkMap.setTypeface(tf);
        getInvolved.setTypeface(tf);
        vote.setTypeface(tf);
        sponsor.setTypeface(tf);
        eventschedule.setTypeface(tf);
        vistor.setTypeface(tf);



        //setOnClickListener
        parkMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,map.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
