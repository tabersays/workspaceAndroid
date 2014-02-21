package com.eventreceiver_tfitzgerald3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;

public class MainActivity extends Activity {
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        reciever intentReceiver = new reciever();//creates a reciever class
    	IntentFilter filter = new IntentFilter();// make an intent
        
        
        filter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);//tell the intent to watch the wifi change
        registerReceiver(intentReceiver, filter);//sets the receiver to look for the intent
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
