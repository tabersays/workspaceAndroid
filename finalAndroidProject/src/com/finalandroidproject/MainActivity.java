package com.finalandroidproject;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity implements OnClickListener {
	int buttonindex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button next = (Button) findViewById(R.id.next);
		next.setOnClickListener(this);
		
		Button prev = (Button) findViewById(R.id.prev);
		prev.setOnClickListener(this);
		
		Button add = (Button) findViewById(R.id.add);
		add.setOnClickListener(this);
		
		Button reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
		Intent nextScreen;
		switch(item.getItemId())
		{
		case R.id.chars:
			nextScreen = new Intent(getApplicationContext(), charMenu.class);
			nextScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(nextScreen);
			break;
		case R.id.die:
			nextScreen = new Intent(getApplicationContext(), dieMenu.class);
			nextScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivityForResult(nextScreen, 1234);
		}
	    return true;
	}
	@Override
	public void onClick(View view) {
		LinearLayout lay = (LinearLayout) findViewById(R.id.orderField);
		switch(view.getId())
		{
		case R.id.add:
			Button aPlayer = new Button(this);
			aPlayer.setOnClickListener(this);
			aPlayer.setText("Name");
			aPlayer.setId(buttonindex);
			buttonindex++;
			lay.addView(aPlayer);
			
		}
		
	}
	

}
