package com.filemanipulator;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button read = (Button) findViewById(R.id.button1);
		read.setOnClickListener(this);
		Button append = (Button) findViewById(R.id.button2);
		append.setOnClickListener(this);
		Button replace = (Button) findViewById(R.id.button3);
		replace.setOnClickListener(this);
		//TextView text = (TextView) findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void writeFile(String string){
		try {
			File file = new File(Environment.getExternalStorageDirectory().getPath() +"/ass4.txt");
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(string);
			bw.write('\n');
			bw.close();
			
 
		} catch (IOException e) {
			Toast.makeText(getBaseContext(), "Error Write", Toast.LENGTH_LONG).show();
		}
		
	}
	private void replaceFile(String string){
		File file = new File(Environment.getExternalStorageDirectory().getPath() +"/ass4.txt");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(getBaseContext(), "Error Replace", Toast.LENGTH_LONG).show();
		}
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(string);
			bw.write('\n');
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(getBaseContext(), "Error Replace", Toast.LENGTH_LONG).show();
		}
	}

	private String readFile(){
		
		String toReturn = "";
		try {
			File file = new File(Environment.getExternalStorageDirectory().getPath() +"/ass4.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				
				return "";
			}
 
			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr); 
			String str = "";
			while((str = br.readLine()) != null)
			{
				toReturn = '\n' + toReturn + '\n' + str;
			}
			
			br.close();
 
		} catch (IOException e) {
			Toast.makeText(getBaseContext(), "Error Read", Toast.LENGTH_LONG).show();
		}
		return toReturn;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView text = (TextView) findViewById(R.id.textView1);
		EditText edit = (EditText) findViewById(R.id.editText1);
		String string = readFile();
		
		switch (v.getId())
		{
		case R.id.button1:
			text.setText(string);
			break;
		case R.id.button2:
			
			writeFile(edit.getText().toString());
			break;
		case R.id.button3:
			replaceFile(edit.getText().toString());
			break;
		
		}
		
	}

}
