package be.ac.vub.nrt;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;

public class Day extends FragmentActivity{
	int year, month, day;
    MyAdapter mAdapter;
    ViewPager mPager;
	
	@SuppressLint("SimpleDateFormat")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);
		
		Container cont = Container.getInstance();
		Calendar cal = cont.getCalendar();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		getActionBar().setSubtitle(day+"/"+month+"/"+year);
		
		mAdapter = new MyAdapter(this, getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(3);
        mPager.setAdapter(mAdapter);
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
	        case R.id.action_change_date:
	        	DatePickerDialog pickDialog = new DatePickerDialog(this, dateListener, year, month-1, day);
	        	pickDialog.show();
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
			}else{
				year = cal2.get(Calendar.YEAR);
		    	month = cal2.get(Calendar.MONTH)+1;
		    	day = cal2.get(Calendar.DAY_OF_MONTH);
			}
			Container container = Container.getInstance();
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.set(year, month, day);
			container.setCalendar(newCalendar);
			getActionBar().setSubtitle(day+"/"+month+"/"+year);
			mAdapter.notifyDataSetChanged();
	    }
	};
}