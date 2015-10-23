package server.maverickeventhub;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import server.maverickeventhub.R;

import android.app.Activity;
import android.app.AlertDialog;
//import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends Activity {
    HttpResponse response;
    
    


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgotpassword);
		
		//Define all controls used in the UI		
		EditText edittext_uta_email = (EditText) findViewById(R.id.et_fp_uta_email);
		TextView textview_uta_email= (TextView) findViewById(R.id.tv_fp_uta_email);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		Button button_ok = (Button) findViewById(R.id.btn_fp_ok);
		Button button_refresh = (Button) findViewById(R.id.btn_fp_refresh);
		Button button_close = (Button) findViewById(R.id.btn_fp_close);
		
		
		textview_uta_email.setTypeface(font);
		
		
		edittext_uta_email.setTypeface(font);
		
		
		
		/*
		Button button_login_forgotusername = (Button) findViewById(R.id.btn_forgotusername);
		button_login_forgotusername.setTypeface(font);
		
		Button button_login_forgotpassword = (Button) findViewById(R.id.btn_forgotpassword);
		button_login_forgotpassword.setTypeface(font);
		
		CheckBox checkbox_rememberme = (CheckBox) findViewById(R.id.chk_rememberme);
		checkbox_rememberme.setTypeface(font);
		*/
		
		//Set the font for controls used in the UI to Metro UI font
		button_close.setTypeface(font);
		
		
		button_refresh.setTypeface(font);
		
		
		button_ok.setTypeface(font);
		
		//Close event
		button_close.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  new AsyncTask<Void, Integer, Void>(){
		       			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.fp_progressBar1);
		       	         @Override
		       	         protected Void doInBackground(Void... params) {
		       	        	 int progressStatus = 0;
		       	             while (progressStatus < 100) {
		       	                 progressStatus++;
		       	                 if(progressStatus == 99)
		       	                 {		       	                	 
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
			    //finish();
			  }
			});
		
		//Refresh all input controls to default
		button_refresh.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  
            	EditText edittext_uta_email = (EditText) findViewById(R.id.et_fp_uta_email);				
			  	edittext_uta_email.setText("");
		       	                 
				  	
			  }
			});
		
		//Process forgotpassword procedure
		button_ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	EditText edittext_uta_email = (EditText) findViewById(R.id.et_fp_uta_email);
        		String uta_email = edittext_uta_email.getText().toString();
            	int count=0;
        		//ProgressDialog dialog = null;
        		
            	//Validate all input controls
        		if(uta_email.equals(""))
        		{
        			ForgotPassword.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this,R.style.AlertDialogTheme);
        	                builder.setTitle("UTA E-mail Address Missing");
        	                builder.setMessage("Please enter your UTA E-mail Address")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                        	   
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	            
        	        });
        			edittext_uta_email.requestFocus();
        		}
        		else     		
        		{
        			if(!validUTAEmail(uta_email))
        			{
        				ForgotPassword.this.runOnUiThread(new Runnable() {
            	            public void run() {
            	                AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this,R.style.AlertDialogTheme);
            	                builder.setTitle("Invalid UTA E-mail Address");
            	                builder.setMessage("Please enter a valid UTA e-mail address")  
            	                       .setCancelable(false)
            	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	                           public void onClick(DialogInterface dialog, int id) {
            	                           }
            	                       });                     
            	                AlertDialog alert = builder.create();
            	                alert.show();               
            	            }
            	        });
        				edittext_uta_email.setText("");
            			edittext_uta_email.requestFocus();
        			}
        			else
        				count++;
        		}

        		
        		if(count==1)
        		{
                //dialog = ProgressDialog.show(Login.this, "", 
                 //       "Validating user...", true);
                 new Thread(new Runnable() {
                        public void run() {
                            checkUTAEmail();                          
                        }
                      }).start();               
        		}    
        	}       
            
        });
		
		
    }
	
	//Function to check if UTA email is valid i.e. it exists
	void checkUTAEmail(){
		try{            
        	
        	EditText edittext_uta_email = (EditText) findViewById(R.id.et_fp_uta_email);
    		
        	HttpPost httppost;
    	    //StringBuffer buffer;
    	    //HttpResponse response;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
    		//ProgressDialog dialog = null;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/checkutaemail.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(1);
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
            nameValuePairs.add(new BasicNameValuePair("uta_email",edittext_uta_email.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            //Execute HTTP Post Request
            response=httpclient.execute(httppost);
            // edited by James from coderzheaven.. from here....
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);
            System.out.println("Response : " + response); 
            runOnUiThread(new Runnable() {
                public void run() {                    
                    //dialog.dismiss();
                }
            });
             
            if(response.equalsIgnoreCase("User Not Found")){
            	new Thread(new Runnable() {
                    public void run() {    
                    	//Toast.makeText(Register.this,"000000", Toast.LENGTH_SHORT).show();
                    	showUTAEmailNotFoundAlert();                                                  
                    }
                  }).start();   
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                forgotPassword();
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        } 
    	    
    }

	//Function to generate a new password and send to UTA email
	void forgotPassword(){
        try{            
        	
        	EditText edittext_uta_email = (EditText) findViewById(R.id.et_fp_uta_email);
    		
        	HttpPost httppost;
    	    //StringBuffer buffer;
    	    //HttpResponse response;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
    		//ProgressDialog dialog = null;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/forgotpassword.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(1);
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
            nameValuePairs.add(new BasicNameValuePair("uta_email",edittext_uta_email.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value']; 
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            //Execute HTTP Post Request
            //response=httpclient.execute(httppost);
            // edited by James from coderzheaven.. from here....
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);
            System.out.println("Response : " + response); 
            runOnUiThread(new Runnable() {
                public void run() {                    
                    //dialog.dismiss();
                }
            });
             
            if(response.equalsIgnoreCase("Error in Query")){
	            runOnUiThread(new Runnable() {
	                public void run() {
	                    Toast.makeText(ForgotPassword.this,"Error", Toast.LENGTH_SHORT).show();
	                }
	            });
	             
	        }else{
	        	runOnUiThread(new Runnable() {
	                public void run() {
	                    Toast.makeText(ForgotPassword.this,"Password Reset and sent to UTA E-mail Address", Toast.LENGTH_SHORT).show();
	                	//startActivity(new Intent(Register.this, Registered.class));
	                	
	                	new AsyncTask<Void, Integer, Void>(){
	           			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.fp_progressBar1);
	           	         @Override
	           	         protected Void doInBackground(Void... params) {
	           	        	 int progressStatus = 0;
	           	             while (progressStatus < 100) {
	           	                 progressStatus++;
	           	                 if(progressStatus == 99)
	           	                 {
	           	                	 Intent i = new Intent(ForgotPassword.this, ForgotPasswordDone.class);
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
	                }
	            });            
	        }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
        
        
    }
	

	public void showUTAEmailNotFoundAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    ForgotPassword.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this,R.style.AlertDialogTheme);
	            builder.setTitle("UTA E-mail Address Not Found");
	            builder.setMessage("Please enter correct UTA e-mail address")  
	                   .setCancelable(false)
	                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                       public void onClick(DialogInterface dialog, int id) {
	                    	   EditText edittext_uta_email= (EditText) findViewById(R.id.et_fp_uta_email);
	                    	   edittext_uta_email.requestFocus();
	                       }
	                   });                     
	            AlertDialog alert = builder.create();
	            alert.show();               
	        }
	    });
        
    }
	
	public boolean validUTAEmail(String email) {
		String UTA_EMAIL_ADDRESS = "^[A-Z0-9._%+-]+@mavs.uta.edu$";
		
	    //Pattern pattern = Patterns.EMAIL_ADDRESS;	    
	    Pattern pattern = Pattern.compile(UTA_EMAIL_ADDRESS, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(email).matches();
	}
	
	public void onBackPressed()
	{
	    finish();
	}
}


