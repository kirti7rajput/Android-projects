package com.json;




import java.util.ArrayList;

import com.database.DataBase;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;


import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class SecondActivity extends Activity 
{


	ArrayList<String> StringArray=new ArrayList<String>();
	String myjsonstring;
		
	DataBase db;

	String contact_id,fname,lname,age,sAddr,city,state,postal,type,num;

	//String str[];


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{



		super.onCreate(savedInstanceState);


		

		setContentView(R.layout.activity_second);
		
	}




@Override
protected void onResume() 
{
	// TODO Auto-generated method stub
	super.onResume();   
	db=new DataBase(SecondActivity.this);

	// Preparing TextView to display JSON results
	//TextView tvResult = (TextView) findViewById(R.id.textview);
	
	Cursor cursor=db.getContacts();
	//cursor.moveToFirst();
	/*for(int i=1;i<=cursor.getCount();i++)
	{
		tvResult.append(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5)+" "+cursor.getString(6)+" "+cursor.getString(7)+" "+cursor.getString(8)+" "+cursor.getString(9));
	}*/

	
	
	
	
	//ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_second,str);
	
	ListView listView = (ListView) findViewById(R.id.listview);
	listView.setAdapter(new SimpleCursorAdapter(SecondActivity.this, R.layout.list_item, cursor,new String[] {"FIRST_NAME","LAST_NAME","AGE","ADDRESS","CITY","STATE","POSTALCODE","NUMBER"}, new int[] {R.id.textViewName,R.id.textViewName1,R.id.textViewAge,R.id.textViewAddress,R.id.textViewAddress1,R.id.textViewAddress2,R.id.textViewAddress3,R.id.textViewNumber},0));
	

}

}



