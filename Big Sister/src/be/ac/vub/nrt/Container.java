package be.ac.vub.nrt;

import java.io.IOException;
import java.util.Calendar;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Container {
	public Sleepcomfort comfort = null;
	private static Container instance;
	public Calendar calendar;
	OkHttpClient client;
	
    private Container() {
    	client = new OkHttpClient();
    	calendar = Calendar.getInstance();
    	calendar.add(Calendar.MONTH, 1);
    }
    
    private synchronized static void createInstance () {
        if (instance == null) instance = new Container ();
    }
    
    public static Container getInstance () {
        if (instance == null) 
        	createInstance ();
        return instance;
    }
    
    public void loadData() throws IOException{
    	Calendar cal1 = Calendar.getInstance();
		cal1.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)-1, calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 1);
		cal1.add(Calendar.HOUR_OF_DAY, 2);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)-1, calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		cal2.add(Calendar.HOUR_OF_DAY, 2);
		
		Request request = new Request.Builder()
			.url("http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/sleepcomfort/1/"+cal1.getTimeInMillis()/1000L+"/"+cal2.getTimeInMillis()/1000L)
			.build();

		Call call = client.newCall(request);
		Response response = call.execute();

		if (!response.isSuccessful()) {
			throw new IOException("Unexpected code " + response);
		}
		parseValues(response.body().string());
    }
    
    public boolean hasData(){
    	if(comfort == null){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    private void parseValues(String body){
    	Gson gson = new Gson();
    	comfort = gson.fromJson(body, Sleepcomfort.class);
    }
    
	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
		reinitialize();
	}

	private void reinitialize(){
		comfort = null;
	}
}
