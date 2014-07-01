package be.ac.vub.nrt;

import java.io.IOException;
import java.util.Calendar;

import com.google.gson.Gson;
import com.squareup.okhttp.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class Day extends FragmentActivity{
	int year, month, day, checkControl;
	Button date;
	
	float totalMaxValue = 0;
	int maxXValue = 0;
	
	@SuppressLint("SimpleDateFormat")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);
		
	}
	/*
		checkControl = 0;
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		
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
		
		try {
			getSoundData();
			getVideoData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private void createGraph(String body, int type) {
		if(events.length != 0)
			addLinePointsFromArray(events, type);
	}
	
	private void addLinePointsFromArray(Event[] events, int type) {
		LineGraph graph = (LineGraph)findViewById(R.id.graph);
		int smallestStamp = (int) events[0].timestamp;
		int largestStamp = (int) events[events.length-1].timestamp;
		float maxVal = 0;
		
		Line line = new Line();
		for(Event event : events){
			LinePoint p = new LinePoint();
			p.setX(event.timestamp - smallestStamp);
			p.setY(event.value);
			line.addPoint(p);
			if(event.value > maxVal){
				maxVal = (float) event.value;
			}
		}
		if(totalMaxValue < maxVal){
			totalMaxValue = (float) (maxVal*1.3);
		}
		
		line.setShowingPoints(false);
		if(type == 1){
			line.setColor(Color.parseColor("#FFBB33"));
		}else{
			line.setColor(Color.parseColor("#FF33B5"));
		}
		
		if(maxXValue < largestStamp-smallestStamp){
			maxXValue = largestStamp-smallestStamp;
		}
		
		graph.addLine(line);
		graph.setRangeY(0, totalMaxValue);
		graph.setRangeX(0, maxXValue);
		graph.setLineToFill(0);
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
			
			try {
				if(checkControl == 0){
					LineGraph graph = (LineGraph)findViewById(R.id.graph);
					graph.removeAllLines();
					totalMaxValue = 0;
					maxXValue = 0;
					getSoundData();
					getVideoData();
					checkControl++;
				}else{
					checkControl = 0;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	};*/
}