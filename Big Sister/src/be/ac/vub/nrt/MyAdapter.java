package be.ac.vub.nrt;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter  {
	Context context = null;
	
	public MyAdapter(FragmentManager fm) {
		super(fm);
		// unused i think
	}

	public MyAdapter(Context context, FragmentManager mgr) {
		super(mgr);
		this.context = context;
	}

	
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Fragment getItem(int position) {
		switch(position){
			case 0:
				return (DataFragment.newInstance(position));
			case 1:
				return (AudioFragment.newInstance(position));
			case 2:
				return (VideoFragment.newInstance(position));
		}
		return null;
	}
	
	@Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }
}