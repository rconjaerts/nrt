package be.ac.vub.nrt;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;

import com.google.gson.Gson;

import be.ac.vub.nrt.holograph.Line;
import be.ac.vub.nrt.holograph.LineGraph;
import be.ac.vub.nrt.holograph.LinePoint;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class Day extends Activity{
	int year, month, day;
	Button date;
	
	@SuppressLint("SimpleDateFormat")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);
		
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH)+1;
		day = c.get(Calendar.DAY_OF_MONTH);
		
		date = (Button)findViewById(R.id.date);
		date.setText(day+"-"+month+"-"+year);
		date.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				DatePickerDialog pickDialog = new DatePickerDialog(v.getContext(), dateListener, year, month-1, day);
				pickDialog.show();
			}
		});
		
		/*
		try {
			HttpURLConnection con = (HttpURLConnection) ( new URL("http://192.168.1.116:8080/BigSister/webresources/entities.eventvideo")).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			Gson gson = new Gson();
			String json = gson.toJson(con.getContent());
			System.out.println("blabla");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Line l = new Line();
		for(int i = 0; i<100; i++){
			LinePoint p = new LinePoint();
			p.setX(i);
			p.setY(5*i);
			l.addPoint(p);
		}
		
		l.setColor(Color.parseColor("#FFBB33"));

		LineGraph li = (LineGraph)findViewById(R.id.graph);
		li.addLine(l);
		li.setRangeY(0, 500);
		li.setRangeX(0, 100);
		li.setLineToFill(0);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.actionbar_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_range:
	        	Intent intent = new Intent(this.getBaseContext(), Range.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
	    @Override
	    public void onDateSet(DatePicker view, int newYear, int newMonth, int newDay) {
	    	Calendar cal1 = Calendar.getInstance();
	    	cal1.set(newYear, newMonth, newDay);
	    	
			Calendar cal2 = Calendar.getInstance();
			
			if(cal1.compareTo(cal2) != 1){
				year = newYear;
		    	month = newMonth+1;
		    	day = newDay;
		    	date.setText(day+"-"+month+"-"+year);
			}else{
				year = cal2.get(Calendar.YEAR);
		    	month = cal2.get(Calendar.MONTH)+1;
		    	day = cal2.get(Calendar.DAY_OF_MONTH);
		    	date.setText(day+"-"+month+"-"+year);
			}
	    }
	};
}