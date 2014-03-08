package com.dbassignment_tfitzgerald;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class dataBase extends SQLiteOpenHelper {
	final static String DB_NAME = "Taber.db";
	final static int DB_VERSION = 1;
	private final String TABLE = "configTable";
	Context context;
	
	public dataBase(Context context)
	{
		super(context, DB_NAME, null, DB_VERSION);
		this.context=context;
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + "(text VARCHAR PRIMARY KEY);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	public void insertText(String text){
		try{
			
			SQLiteDatabase base = this.getWritableDatabase();
			base.execSQL("INSERT OR REPLACE INTO " +
					TABLE + " (text) Values (\""+ text + "\");");
			base.close();
		}
		catch(SQLiteException se){
			//toast
			Toast.makeText(context, "Error Insert", Toast.LENGTH_LONG).show();
		}
	}
	public String getText(){
		String toReturn = "";
		try{
			
			SQLiteDatabase base = this.getReadableDatabase();
			base.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " (text VARCHAR);");
			Cursor c = base.rawQuery("SELECT * FROM " +
	    			TABLE, null);
			if (c != null ) {
	    		if  (c.moveToFirst()) {
	    			do {
	    				String text = c.getString(c.getColumnIndex("text"));
	    				toReturn += text + "\n";
	    			}
	    			while (c.moveToNext());
	    		}
			}
			base.close(); 
		}
		catch(SQLiteException se){
			//toast
			Toast.makeText(context, "Error Get", Toast.LENGTH_LONG).show();
			return "";
		}
		return toReturn;
	}
	
}
