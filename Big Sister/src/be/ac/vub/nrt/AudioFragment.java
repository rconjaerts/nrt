package be.ac.vub.nrt;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AudioFragment extends Fragment{
	private static final String KEY_POSITION = "position";

	public static AudioFragment newInstance(int position) {
		AudioFragment frag = new AudioFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);
		frag.setArguments(args);

		return (frag);
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.audiofragment, container, false);
		Container cont = Container.getInstance();
		Calendar cal = cont.getCalendar();
		
		WebView myWebView = (WebView) myFragmentView.findViewById(R.id.webview); 
		WebSettings webSettings = myWebView.getSettings(); 
		webSettings.setJavaScriptEnabled(true); 
		myWebView.setWebViewClient(new WebViewClient()); 
		myWebView.loadUrl("http://192.168.1.119:8888/hackathon/web/index.php/graph/noise?date="+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
		
		return myFragmentView;
	}
}