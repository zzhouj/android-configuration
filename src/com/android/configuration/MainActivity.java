package com.android.configuration;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.text);
		tv.setText(getConfigurations());
	}

	private String getConfigurations() {
		Configuration config = getResources().getConfiguration();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		String configText = "";
		String screenSize = "unknown";
		if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
			screenSize = "small";
		} else if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
			screenSize = "normal";
		} else if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
			screenSize = "large";
		} else if ((config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
			screenSize = "xlarge";
		}
		String screenAspect = "unknown";
		if ((config.screenLayout & Configuration.SCREENLAYOUT_LONG_MASK) == Configuration.SCREENLAYOUT_LONG_YES) {
			screenAspect = "long";
		} else if ((config.screenLayout & Configuration.SCREENLAYOUT_LONG_MASK) == Configuration.SCREENLAYOUT_LONG_NO) {
			screenAspect = "notlong";
		}
		String screenOrientation = "unknown";
		if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
			screenOrientation = "port";
		} else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			screenOrientation = "land";
		}
		configText += "Smallest width: " + config.smallestScreenWidthDp + "dp\n";
		configText += "Available width: " + config.screenWidthDp + "dp\n";
		configText += "Available height: " + config.screenHeightDp + "dp\n";
		configText += "Screen size: " + screenSize + "\n";
		configText += "Screen aspect: " + screenAspect + "\n";
		configText += "Screen orientation: " + screenOrientation + "\n";
		configText += "Screen density: " + metrics.density + "\n";
		configText += "Screen densityDpi: " + metrics.densityDpi + "dpi\n";
		configText += "Screen scaledDensity: " + metrics.scaledDensity + "\n";
		configText += "Screen widthPixels: " + metrics.widthPixels + "\n";
		configText += "Screen heightPixels: " + metrics.heightPixels + "\n";
		return configText;
	}

}
