package server.maverickeventhub;

import server.maverickeventhub.R;

import android.app.Activity;
//import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.ProgressBar;

public class ForgotPasswordDone extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgotpassworddone);
		
		Button button_close = (Button) findViewById(R.id.btn_fpd_close);
		button_close.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  	       	                	 
		       	                     finish();
		       	                 
			  }
			});
	}
	
	public void onBackPressed()
	{
	    finish();
	}
}
