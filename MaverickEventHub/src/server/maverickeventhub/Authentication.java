package server.maverickeventhub;

import server.maverickeventhub.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
//import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;

public class Authentication extends Activity {

	
	//When back button is pressed, go back to previous screen
	int backButtonCount;
	public void onBackPressed()
	{	    		
	        Intent intent = new Intent(Authentication.this,StartUp.class);	        
	        startActivity(intent);
	        finish();	    
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen);
		
		//Change font type of controls to a custom font (metro UI font)
		Button button_login = (Button) findViewById(R.id.btn_login);
		Button button_register = (Button) findViewById(R.id.btn_register);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		
		button_login.setTypeface(font);	  		
		button_register.setTypeface(font);	
		
		//Load register page when we click register
		button_register.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            // Perform action on click
	   		 new AsyncTask<Void, Integer, Void>(){
	   			 //Show animation of progress bar
				 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		         @Override
		         protected Void doInBackground(Void... params) {
		        	 int progressStatus = 0;
		             while (progressStatus < 100) {
		                 progressStatus++;
		                 if(progressStatus == 99)
		                 {
		                	 Intent i = new Intent(Authentication.this,Register.class);
		                     startActivity(i);
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
		     
		     
	        }
	    });
		
		//Load login page on clicking login
		button_login.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            // Perform action on click
	   		 new AsyncTask<Void, Integer, Void>(){
	   			 //Show animation on progress bar
				 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		         @Override
		         protected Void doInBackground(Void... params) {
		        	 int progressStatus = 0;
		             while (progressStatus < 100) {
		                 progressStatus++;
		                 if(progressStatus == 99)
		                 {
		                	 Intent i = new Intent(Authentication.this,Login.class);
		                     startActivity(i);
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
		     
	        }
		});
		
		
	}
	
	//When activate restarts, reload all
	@Override
	public void onRestart() {
	    super.onRestart();
	    startActivity(new Intent(this, Authentication.class));
	}
}
