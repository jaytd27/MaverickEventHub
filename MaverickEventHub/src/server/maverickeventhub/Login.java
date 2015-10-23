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
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
//import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	
	//HttpPost httppost;
    //StringBuffer buffer;
    HttpResponse response;
    //HttpClient httpclient;
    //List<NameValuePair> nameValuePairs;
	//ProgressDialog dialog = null;
    
    
    public static final String PREFS_NAME = "LoginPrefs";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		//Define all controls used in the UI
		EditText edittext_username = (EditText) findViewById(R.id.et_login_username);
		EditText edittext_password = (EditText) findViewById(R.id.et_login_password);
		TextView textview_password= (TextView) findViewById(R.id.tv_login_password);
		TextView textview_login_welcome= (TextView) findViewById(R.id.tv_login_welcome);
		TextView textview_username= (TextView) findViewById(R.id.tv_login_username);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		Button button_login = (Button) findViewById(R.id.btn_login_login);
		Button button_refresh = (Button) findViewById(R.id.btn_login_refresh);
		Button button_close = (Button) findViewById(R.id.btn_login_close);
		Button button_forgotpassword = (Button) findViewById(R.id.btn_forgotpassword);
		Button button_forgotusername = (Button) findViewById(R.id.btn_forgotusername);
		
		//Set font for all the controls used to Metro UI font		
		textview_username.setTypeface(font);
		textview_login_welcome.setTypeface(font);
		textview_password.setTypeface(font);
		edittext_username.setTypeface(font);
		edittext_password.setTypeface(font);
		
		
		// Shared preferences
		
		 SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	        
			if (settings.getString("logged", "").toString().equals("logged")) {
				Intent intent = new Intent(Login.this, Home.class);
				startActivity(intent);
			}
		
		//Close event 
		button_close.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  new AsyncTask<Void, Integer, Void>(){
		       			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		       	         @Override
		       	         protected Void doInBackground(Void... params) {
		       	        	 int progressStatus = 0;
		       	             while (progressStatus < 100) {
		       	                 progressStatus++;
		       	                 if(progressStatus == 99)
		       	                 {		       	                	 
		       	                     finish();
			       	                 Intent intent = new Intent(Login.this, Authentication.class);
			       	                 startActivity(intent);
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
		
		//Load the forgotpassword screen
		button_forgotpassword.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  new AsyncTask<Void, Integer, Void>(){
		       			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		       	         @Override
		       	         protected Void doInBackground(Void... params) {
		       	        	 int progressStatus = 0;
		       	             while (progressStatus < 100) {
		       	                 progressStatus++;
		       	                 if(progressStatus == 99)
		       	                 {		       	                	 
		       	                	Intent i = new Intent(Login.this, ForgotPassword.class);
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
			    //finish();
			  }
			});
		
		//Load forgotusername screen
		button_forgotusername.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  new AsyncTask<Void, Integer, Void>(){
		       			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		       	         @Override
		       	         protected Void doInBackground(Void... params) {
		       	        	 int progressStatus = 0;
		       	             while (progressStatus < 100) {
		       	                 progressStatus++;
		       	                 if(progressStatus == 99)
		       	                 {		       	                	 
		       	                	Intent i = new Intent(Login.this, ForgotUsername.class);
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
			    //finish();
			  }
			});
		
		//Refresh all fields
		button_refresh.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  
            	EditText edittext_username = (EditText) findViewById(R.id.et_login_username);
				EditText edittext_password = (EditText) findViewById(R.id.et_login_password);
			  	edittext_username.setText("");
				edittext_password.setText("");
		       	                 
				  	
			  }
			});
		
		//Perform login, run the login function
		button_login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	EditText edittext_username = (EditText) findViewById(R.id.et_login_username);
        		EditText edittext_password = (EditText) findViewById(R.id.et_login_password);
        		String username = edittext_username.getText().toString();
        		String password = edittext_password.getText().toString();
            	int count=0;
        		//ProgressDialog dialog = null;
        		
        		if(username.equals(""))
        		{
        			Login.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Username Missing");
        	                builder.setMessage("Please enter your username")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                        	   
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	            
        	        });
        			edittext_username.requestFocus();
        		}
        		else     		
        			count++;

        		if(password.equals("")&&count==1)
        		{
        			Login.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Password Missing");
        	                builder.setMessage("Please enter your password")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_password.requestFocus();
        		}
        		else
        				count++;
        		
        		if(count==2)
        		{
                //dialog = ProgressDialog.show(Login.this, "", 
                 //       "Validating user...", true);
                 new Thread(new Runnable() {
                        public void run() {
                            login();                          
                        }
                      }).start();               
        		}    
        	}       
            
        });
		
		
    }

	//Login function
	void login(){
        try{            
        	
        	EditText edittext_username = (EditText) findViewById(R.id.et_login_username);
    		EditText edittext_password = (EditText) findViewById(R.id.et_login_password);
    		CheckBox c = (CheckBox) findViewById(R.id.chk_rememberme);
    		
        	HttpPost httppost;
    	    //StringBuffer buffer;
    	    //HttpResponse response;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
    		//ProgressDialog dialog = null;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/login.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(2);
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
            nameValuePairs.add(new BasicNameValuePair("username",edittext_username.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
            nameValuePairs.add(new BasicNameValuePair("password",edittext_password.getText().toString().trim())); 
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
             
            if(response.equalsIgnoreCase("User Found")){
            	
if (c.isChecked()) {
					
					SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putString("logged", "logged");
					editor.commit();
					}
					Intent intent = new Intent(Login.this, Home.class);
					startActivity(intent);
				
			
                runOnUiThread(new Runnable() {
                    public void run() {
                    	
                    	  
                    	//
                        Toast.makeText(Login.this,"Login Success", Toast.LENGTH_SHORT).show();
                    }
                });
                 
                new AsyncTask<Void, Integer, Void>(){
       			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
       	         @Override
       	         protected Void doInBackground(Void... params) {
       	        	 int progressStatus = 0;
       	             while (progressStatus < 100) {
       	                 progressStatus++;
       	                 if(progressStatus == 99)
       	                 {
       	                	 EditText edittext_username = (EditText) findViewById(R.id.et_login_username);
       	                	 
       	                	 Intent i = new Intent(Login.this, Home.class);       	                	 
       	                	 i.putExtra("username",edittext_username.getText().toString());
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
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                showAlert();                
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
        
        
    }
	
	//Alert of login failure
	public void showAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
        Login.this.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this,R.style.AlertDialogTheme);
                builder.setTitle("Invalid Credentials");
                builder.setMessage("Please enter valid credentials")  
                       .setCancelable(false)
                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                           }
                       });                     
                AlertDialog alert = builder.create();
                alert.show();               
            }
        });
        
    }
		
	public boolean validUsername(String phone) {
		String USERNAME = "^[a-z0-9_-]{3,15}$";
	    Pattern pattern = Pattern.compile(USERNAME, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(phone).matches();
	}
	
	public boolean validPassword(String phone) {
		String PASSWORD = "^[a-z0-9_-]{3,15}$";
	    Pattern pattern = Pattern.compile(PASSWORD, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(phone).matches();
	}
	
	@Override
	public void onRestart() {
	    super.onRestart();
	    startActivity(new Intent(this, Login.class));
	}
	public void onBackPressed()
	{
	    finish();
	}
}
