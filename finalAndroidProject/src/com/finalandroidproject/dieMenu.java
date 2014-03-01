package com.finalandroidproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


public class dieMenu extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.die_menu);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
		case R.id.ini:
			nextScreen = new Intent(getApplicationContext(), MainActivity.class);
			nextScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(nextScreen);
		}
	    return true;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
