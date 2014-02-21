package com.eventreceiver_tfitzgerald3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class reciever extends BroadcastReceiver {
	
	public void onReceive(Context context, Intent intent){
		final String action = intent.getAction();
		
	    if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {//if the connection changes on to off or off to on
	        if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)){//if it is changed to on
	        	Toast.makeText(context, "Connected", Toast.LENGTH_LONG).show();//do stuff
	        } else {//wifi connection was lost
	        	Toast.makeText(context, "Connection lost", Toast.LENGTH_LONG).show();//do different stuff
	        }
	    }
		
	}

	
}
