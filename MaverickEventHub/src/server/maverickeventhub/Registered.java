package server.maverickeventhub;

import server.maverickeventhub.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Registered extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registered);
		
		Button button_close = (Button) findViewById(R.id.btn_registered_close);
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
