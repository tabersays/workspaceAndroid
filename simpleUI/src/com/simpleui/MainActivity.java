/*
 * Created by Taber Storm Fitzgerald
 */
package com.simpleui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId() == R.id.button1)
		{
			Button b1 = (Button) findViewById(R.id.button1);
			Button b2 = (Button) findViewById(R.id.button2);
			b1.setVisibility(View.INVISIBLE);
			b2.setVisibility(View.VISIBLE);
			TextView text = (TextView) findViewById(R.id.textView1);
			text.setText("Ah, too slow try to get this button!");
		}
		if(view.getId() == R.id.button2)
		{
			Button b1 = (Button) findViewById(R.id.button2);
			Button b2 = (Button) findViewById(R.id.button3);
			b1.setVisibility(View.INVISIBLE);
			b2.setVisibility(View.VISIBLE);
			TextView text = (TextView) findViewById(R.id.textView1);
			text.setText("Ah, too slow try to get this other button!");
		}
		if(view.getId() == R.id.button3)
		{
			Button b1 = (Button) findViewById(R.id.button1);
			Button b2 = (Button) findViewById(R.id.button3);
			b2.setVisibility(View.INVISIBLE);
			b1.setVisibility(View.VISIBLE);
			TextView text = (TextView) findViewById(R.id.textView1);
			text.setText("Ah, no back to the first!");
		}
		
	}
    
}
