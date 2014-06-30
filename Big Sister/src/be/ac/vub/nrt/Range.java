package be.ac.vub.nrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

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

public class Range extends Activity{
	int fromYear, fromMonth, fromDay, toYear, toMonth, toDay;
	Button startDate, endDate;
	
	@SuppressLint("SimpleDateFormat")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);
		
		Calendar c = Calendar.getInstance();
		toYear = fromYear = c.get(Calendar.YEAR);
		toMonth = fromMonth = c.get(Calendar.MONTH)+1;
		toDay = fromDay = c.get(Calendar.DAY_OF_MONTH);
		
		startDate = (Button)findViewById(R.id.startDate);
		startDate.setText("From: "+fromDay+"-"+fromMonth+"-"+fromYear);
		startDate.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				DatePickerDialog pickDialog = new DatePickerDialog(v.getContext(), fromDateListener, fromYear, fromMonth-1, fromDay);
				pickDialog.show();
			}
		});
		
		endDate = (Button)findViewById(R.id.endDate);
		endDate.setText("To: "+toDay+"-"+toMonth+"-"+toYear);
		endDate.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				DatePickerDialog pickDialog = new DatePickerDialog(v.getContext(), toDateListener, toYear, toMonth-1, toDay);
				pickDialog.show();
			}
		});
		
		String JsonResponse = connect("http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event");
		System.out.println("blabla");
		//JSONObject json=new JSONObject(JsonResponse);
		/*
		try {
			HttpURLConnection con = (HttpURLConnection) (new URL("http://192.168.1.116:8080/BigSister/webresources/entities.eventvideo")).openConnection();
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
	        case R.id.action_day:
	        	Intent intent = new Intent(this.getBaseContext(), Day.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	DatePickerDialog.OnDateSetListener fromDateListener = new DatePickerDialog.OnDateSetListener() {
	    @Override
	    public void onDateSet(DatePicker view, int year, int month, int day) {
	    	Calendar cal1 = Calendar.getInstance();
	    	cal1.set(year, month, day);
	    	
			Calendar cal2 = Calendar.getInstance();
			cal2.set(toYear, toMonth, toDay);
			
			if(cal1.after(cal2)){
				fromYear = toYear;
		    	fromMonth = toMonth;
		    	fromDay = toDay;
			}else{
				fromYear = year;
		    	fromMonth = month+1;
		    	fromDay = day;
			}
			
	    	startDate.setText("From: "+fromDay+"-"+fromMonth+"-"+fromYear);
	    }
	};
	
	DatePickerDialog.OnDateSetListener toDateListener = new DatePickerDialog.OnDateSetListener() {
	    @Override
	    public void onDateSet(DatePicker view, int year, int month, int day) {
			Calendar cal1 = Calendar.getInstance();
	    	cal1.set(year, month, day);
	    	
			Calendar cal2 = Calendar.getInstance();
			cal2.set(fromYear, fromMonth, fromDay);
	    	
			if(cal1.before(cal2)){
				toYear = fromYear;
		    	toMonth = fromMonth;
		    	toDay = fromDay;
			}else{
				toYear = year;
		    	toMonth = month+1;
		    	toDay = day;
			}
			
	    	endDate.setText("To: "+toDay+"-"+toMonth+"-"+toYear);
	    }
	};
}