package com.dbassignment_tfitzgerald;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	dataBase theBase;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button get = (Button) findViewById(R.id.button1);
		get.setOnClickListener(this);
		Button insert = (Button) findViewById(R.id.button2);
		insert.setOnClickListener(this);
		theBase = new dataBase(this);
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
		EditText edit = (EditText) findViewById(R.id.editText1);
		TextView text = (TextView) findViewById(R.id.textView1);
		switch(view.getId()){
		case R.id.button1:
			text.setText(theBase.getText());
			break;
		case R.id.button2:
			theBase.insertText(edit.getText().toString());
		}
	}

}
