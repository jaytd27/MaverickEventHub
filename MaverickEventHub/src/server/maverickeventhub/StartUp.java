package server.maverickeventhub;

import server.maverickeventhub.R;

import android.os.AsyncTask;
import android.os.Bundle;
//import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;


public class StartUp extends Activity {


	  
    

	int backButtonCount;
	
	//Back event
	public void onBackPressed()
	{
	    
		if(backButtonCount >= 1)
	    {
	        Intent intent = new Intent(Intent.ACTION_MAIN);
	        intent.addCategory(Intent.CATEGORY_HOME);
	        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        startActivity(intent);
	    }
	    else
	    {
	        Toast.makeText(this, "Home Screen. Press back button again to close the application.", Toast.LENGTH_SHORT).show();
	        backButtonCount++;
	    }
	}
    
	/**
     * The thread to process splash screen events
     */
    

    /** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startup);
		
		
		final Button button_start= (Button) findViewById(R.id.btn_start);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		
		button_start.setTypeface(font);	  
		

	
	//Click event for 'enter'
	button_start.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        button_start.setEnabled(false);
   		 new AsyncTask<Void, Integer, Void>(){
			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
	         @Override
	         protected Void doInBackground(Void... params) {
	        	 int progressStatus = 0;
	             while (progressStatus < 100) {
	                 progressStatus++;
	                 if(progressStatus == 99)
	                 {
	                	 Intent i = new Intent(StartUp.this, Authentication.class);
	                     startActivity(i);
	                     finish();
	                 }
	                 publishProgress(progressStatus);
	                 try {
	                     Thread.sleep(3);
	                 } catch (InterruptedException e) {
	                     e.printStackTrace();
	                 }
	             }
	             return null;  
	         }

	         @Override
	         protected void onProgressUpdate(Integer... values) {
	             progressBar.setProgress(values[0]);

	         }
	     }.execute();
	     button_start.setEnabled(true);
	     
        }
    });

	
	}
	
	//On reloading the activity
	@Override
	public void onRestart() {
	    super.onRestart();
	    startActivity(new Intent(this, StartUp.class));
	}
}


