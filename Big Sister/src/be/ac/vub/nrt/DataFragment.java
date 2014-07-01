package be.ac.vub.nrt;

import java.util.Random;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.AsyncTask;

public class DataFragment extends Fragment {
	private static final String KEY_POSITION = "position";
	private float scale;
	private Container dataContainer;
	private ImageView img;
	private TextView txtUnImp1, txtUnImp2, txtUnImp3, txtUnImp4;
	private Sleepcomfort comfort;
	private ProgressBar progressbar;
	private View myFragmentView, recRest, recMov, recNoise;

	public static DataFragment newInstance(int position) {
		DataFragment frag = new DataFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);
		frag.setArguments(args);

		return (frag);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		dataContainer = Container.getInstance();
		comfort = dataContainer.comfort;
		scale = getResources().getDisplayMetrics().density;

		myFragmentView = inflater.inflate(R.layout.datafragment, container, false);
		
		img = (ImageView) myFragmentView.findViewById(R.id.imgBear);
		recRest = (View) myFragmentView.findViewById(R.id.recRest);
		recMov = (View) myFragmentView.findViewById(R.id.recMov);
		recNoise = (View) myFragmentView.findViewById(R.id.recNoise);
		txtUnImp1 = (TextView) myFragmentView.findViewById(R.id.txtUnImp1);
		txtUnImp2 = (TextView) myFragmentView.findViewById(R.id.txtUnImp2);
		txtUnImp3 = (TextView) myFragmentView.findViewById(R.id.txtUnImp3);
		txtUnImp4 = (TextView) myFragmentView.findViewById(R.id.txtUnImp4);
		progressbar = (ProgressBar) myFragmentView.findViewById(R.id.dataProgressBar);
		
		showContent();

		return myFragmentView;
	}

	private void showContent(){
		if(dataContainer.hasData()){
			comfort = dataContainer.comfort;
			
			Random r = new Random();
			int score = r.nextInt(25-2) + 2;
			int comfortScore = (int) (score * 3.5 /10);
			
			//comfort score
			img.setVisibility(View.VISIBLE);
			switch(comfortScore){
				case 1:
					img.setImageResource(R.drawable.bbsc1);
					break;
				case 2:
					img.setImageResource(R.drawable.bbsc2);
					break;
				case 3:
					img.setImageResource(R.drawable.bbsc3);
					break;
				case 4:
					img.setImageResource(R.drawable.bbsc4);
					break;
				case 5:
					img.setImageResource(R.drawable.bbsc5);
					break;
				case 6:
					img.setImageResource(R.drawable.bbsc6);
					break;
				case 7:
					img.setImageResource(R.drawable.bbsc7);
					break;
				case 8:
					img.setImageResource(R.drawable.bbsc8);
					break;
				case 9:
					img.setImageResource(R.drawable.bbsc9);
					break;
				case 10:
					img.setImageResource(R.drawable.bbsc10);
					break;
			}
			
			//sleepqualityvalue
			recRest.setVisibility(View.VISIBLE);
			LayoutParams params = recRest.getLayoutParams();
			params.width = (int) ((score * 12) * scale + 0.5f);
			recRest.setLayoutParams(params);
			
			recMov.setVisibility(View.VISIBLE);
			LayoutParams params2 = recMov.getLayoutParams();
			params2.width = (int) ((comfort.videoValue * 7) * scale + 0.5f);
			recMov.setLayoutParams(params2);
			
			recNoise.setVisibility(View.VISIBLE);
			LayoutParams params3 = recNoise.getLayoutParams();
			params3.width = (int) ((comfort.audioValue * 7) * scale + 0.5f);
			recNoise.setLayoutParams(params3);
			
			txtUnImp1.setVisibility(View.VISIBLE);
			txtUnImp2.setVisibility(View.VISIBLE);
			txtUnImp3.setVisibility(View.VISIBLE);
			txtUnImp4.setVisibility(View.VISIBLE);
			progressbar.setVisibility(View.GONE);
		} else {
			img.setVisibility(View.GONE); 
			recRest.setVisibility(View.GONE);
			recMov.setVisibility(View.GONE);
			recNoise.setVisibility(View.GONE);
			txtUnImp1.setVisibility(View.GONE);
			txtUnImp2.setVisibility(View.GONE);
			txtUnImp3.setVisibility(View.GONE);
			txtUnImp4.setVisibility(View.GONE);
			progressbar.setVisibility(View.VISIBLE);
			
			new LoadContentTask().execute();
		}
	}

	private void showErrorContent() {
		// doen we niet
	}

	private class LoadContentTask extends AsyncTask<Object, Object, AsyncTaskResult<Boolean>> {

		@Override
		protected AsyncTaskResult<Boolean> doInBackground(Object... arg) {
			try {
				dataContainer.loadData();
			} catch (Exception anyException) {
				return new AsyncTaskResult<Boolean>(anyException);
			}
			return new AsyncTaskResult<Boolean>(Boolean.valueOf(true));
		}

		protected void onPostExecute(AsyncTaskResult<Boolean> result) {
			if (result.getError() != null) {
				// error handling here
				showErrorContent();
			} else if (isCancelled()) {
				// cancel handling here
			} else {
				// result handling here
				// Boolean r = result.getResult();
				showContent();
			}
		}

	}
}
