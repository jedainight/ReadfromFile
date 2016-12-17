package com.example.readfromfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
    String newtext="newtext.txt";
    TextView responseText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		responseText = (TextView) findViewById(R.id.textView1);
		writeFile(newtext);
		readFile(newtext);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void writeFile(String fileName) {		
		  String ln = System.getProperty("line.separator");
		  BufferedWriter writer = null;
		  try {
		    writer = 
		      new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, 
		        Context.MODE_PRIVATE)));
		    writer.write("Test 1" + ln);
		    writer.write("Test 2" + ln);
		  } catch (Exception e) {
		      e.printStackTrace();
		  } finally {
		    if (writer != null) {
		    try {
		      writer.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    }
		  }
		} 
	
	public void readFile(String fileName) {
		  String ln = System.getProperty("line.separator");
		  BufferedReader input = null;
		  try {
		    input = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
		    String line;
		    StringBuffer buffer = new StringBuffer();
		    while ((line = input.readLine()) != null) {
		    buffer.append(line + ln);
		    }
		    responseText.setText(buffer);
		  } catch (Exception e) {
		     e.printStackTrace();
		  } finally {
		  if (input != null) {
		    try {
		    input.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    }
		  }
		} 
	
}
