package be.ac.vub.nrt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Container {
	public List<Event> audioEvents;
	public List<Event> videoEvents;
	public Sleepcomfort comfort;
	private static Container instance;
	OkHttpClient client;
	
    private Container() {
    	client = new OkHttpClient();
    	audioEvents = new ArrayList<Event>();
    	videoEvents = new ArrayList<Event>();
    }
    
    private synchronized static void createInstance () {
        if (instance == null) instance = new Container ();
    }
    
    public static Container getInstance () {
        if (instance == null) 
        	createInstance ();
        return instance;
    }
    
    public void refreshData(int year, int month, int day){
    	getAudioData(year, month, day);
    	getVideoData(year, month, day);
    	getValues(year, month, day);
    }
    
    private void getValues(int year, int month, int day){
    	Calendar cal1 = Calendar.getInstance();
		cal1.set(year, month-1, day, 0, 0, 1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(year, month-1, day, 23, 59, 59);
		
		Request request = new Request.Builder()
			.url("http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/sleepcomfort/1/"+cal1.getTimeInMillis()/1000L+"/"+cal2.getTimeInMillis()/1000L)
			.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override public void onFailure(Request request, IOException e) {
				Log.e("Whoops", e.toString());			  
			}

			@Override public void onResponse(Response response) throws IOException {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}
				parseValues(response.body().string());
			}
		});
    }
    
    private void parseValues(String body){
    	Gson gson = new Gson();
    	comfort = gson.fromJson(body, Sleepcomfort.class);
    }
	
	private void getAudioData(int year, int month, int day){
		Calendar cal1 = Calendar.getInstance();
		cal1.set(year, month-1, day, 0, 0, 1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(year, month-1, day, 23, 59, 59);
		
		Request request = new Request.Builder()
			.url("http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/1/1/"+cal1.getTimeInMillis()/1000L+"/"+cal2.getTimeInMillis()/1000L)
			.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override public void onFailure(Request request, IOException e) {
				Log.e("Whoops", e.toString());			  
			}

			@Override public void onResponse(Response response) throws IOException {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}
				Gson gson = new Gson();
				Event[] events = gson.fromJson(response.body().string(), Event[].class);
				audioEvents = Arrays.asList(events);
				//Add create graph event
			}
		});
	}
	
	private void getVideoData(int year, int month, int day){
		Calendar cal1 = Calendar.getInstance();
		cal1.set(year, month-1, day, 0, 0, 1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(year, month-1, day, 23, 59, 59);
		
		Request request = new Request.Builder()
			.url("http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/1/2/"+cal1.getTimeInMillis()/1000L+"/"+cal2.getTimeInMillis()/1000L)
			.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override public void onFailure(Request request, IOException e) {
				Log.e("Whoops", e.toString());			  
			}

			@Override public void onResponse(Response response) throws IOException {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}
				Gson gson = new Gson();
				Event[] events = gson.fromJson(response.body().string(), Event[].class);
				videoEvents = Arrays.asList(events);
				//Add create graph event
			}
		});
	}
}
