package be.ac.vub.nrt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DataFragment extends Fragment{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Container dataContainer = Container.getInstance();
		Sleepcomfort comfort = dataContainer.comfort;
		
		ImageView img = (ImageView) getView().findViewById(R.id.imgBear);
		TextView restVal = (TextView) getView().findViewById(R.id.restVal);
		TextView movementVal = (TextView) getView().findViewById(R.id.movementVal);
		TextView noiseVal = (TextView) getView().findViewById(R.id.noiseVal);
		//Change values through functions Tom is going to write
		img.setImageResource(R.drawable.bbsc10);
		restVal.setText("");
		movementVal.setText("");
		noiseVal.setText("");
		
		return inflater.inflate(R.layout.datafragment, container, false);
    }
}
