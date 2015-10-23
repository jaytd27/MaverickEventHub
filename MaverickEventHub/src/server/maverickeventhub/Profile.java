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

public class Profile extends Activity {
	
	//HttpPost httppost;
    //StringBuffer buffer;
    HttpResponse response;
    //HttpClient httpclient;
    //List<NameValuePair> nameValuePairs;
	//ProgressDialog dialog = null;
    String username = "";
    
    //Back event
    public void onBackPressed()
	{	    
		finish();
	}

    //Load activity class
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		//Define all controls used in the UI
		EditText edittext_current_username = (EditText) findViewById(R.id.et_profile_old_password);
		EditText edittext_new_username = (EditText) findViewById(R.id.et_profile_new_password);
		EditText edittext_confirm_new_username = (EditText) findViewById(R.id.et_profile_confirm_new_password);
		
		TextView textview_current_username= (TextView) findViewById(R.id.tv_profile_old_password);
		TextView textview_new_username= (TextView) findViewById(R.id.tv_profile_new_password);
		TextView textview_confirm_new_username= (TextView) findViewById(R.id.tv_profile_confirm_new_password);
		TextView textview_user= (TextView) findViewById(R.id.tv_user_profile);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		Button button_update = (Button) findViewById(R.id.btn_profile_update);
		Button button_back = (Button) findViewById(R.id.btn_profile_back);
		Button button_help = (Button) findViewById(R.id.btn_profile_help);
		
		
		
		//Set the font for all controls used in the UI to metro UI font
		edittext_current_username.setTypeface(font);
		edittext_new_username.setTypeface(font);
		edittext_confirm_new_username.setTypeface(font);

		
		textview_current_username.setTypeface(font);
		textview_new_username.setTypeface(font);
		textview_confirm_new_username.setTypeface(font);
		textview_user.setTypeface(font);
		textview_user.setText(username);
		button_update.setTypeface(font);
		button_back.setTypeface(font);
		button_help.setTypeface(font);
		
		/*
		Button button_login_forgotusername = (Button) findViewById(R.id.btn_forgotusername);
		button_login_forgotusername.setTypeface(font);
		
		Button button_login_forgotpassword = (Button) findViewById(R.id.btn_forgotpassword);
		button_login_forgotpassword.setTypeface(font);
		
		CheckBox checkbox_rememberme = (CheckBox) findViewById(R.id.chk_rememberme);
		checkbox_rememberme.setTypeface(font);
		*/
		
		
		//button_close.setTypeface(font);
		
		
		//button_refresh.setTypeface(font);
		
		
		//button_login.setTypeface(font);
		
		//Back event
		button_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	finish();
            }
		});
		
		//Load help on click on help
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	//Toast.makeText(Profile.this,"Password Format: Whole combination is means, 6 to 20 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (“@#$%”).", Toast.LENGTH_SHORT).show();
            	Profile.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
    	                builder.setTitle("Password Format");
    	                builder.setMessage("Password properties: 6 to 20 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (“@#$%”)")  
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
		});
		
		//Update click event
		button_update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	EditText edittext_current_password = (EditText) findViewById(R.id.et_profile_old_password);
        		EditText edittext_new_password = (EditText) findViewById(R.id.et_profile_new_password);
        		EditText edittext_confirm_new_password = (EditText) findViewById(R.id.et_profile_confirm_new_password);
        		String current_password = edittext_current_password.getText().toString();
        		String new_password = edittext_new_password.getText().toString();
        		String confirm_new_password = edittext_confirm_new_password.getText().toString();
        		
            	int count=0;
        		//ProgressDialog dialog = null;
        		
            	//Perform validation on all form controls
        		if(current_password.equals(""))
        		{
        			Profile.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Current Password Missing");
        	                builder.setMessage("Please enter your current password")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                        	   
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	            
        	        });
        			edittext_current_password.requestFocus();
        		}
        		else     		
        			count++;

        		if(new_password.equals("")&&count==1)
        		{
        			Profile.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
        	                builder.setTitle("New Password Missing");
        	                builder.setMessage("Please enter your new password")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_new_password.requestFocus();
        		}
        		else
        				count++;
        		
        		if(confirm_new_password.equals("")&&count==2)
        		{
        			Profile.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Confirm Password Missing");
        	                builder.setMessage("Please enter your new password")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_confirm_new_password.requestFocus();
        		}
        		else if(!new_password.equals(confirm_new_password))
        		{
        			Profile.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Password Mismatch");
        	                builder.setMessage("Please enter similar password for both fields")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_new_password.setText("");
        			edittext_confirm_new_password.setText("");
        			edittext_new_password.requestFocus();
        		}
        		else
        		{
        			if(!validPassword(new_password)&&count==2)
        			{
        				Profile.this.runOnUiThread(new Runnable() {
            	            public void run() {
            	                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
            	                builder.setTitle("Invalid Password Format");
            	                builder.setMessage("Please enter a valid Password. Click help for more details.")  
            	                       .setCancelable(false)
            	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	                           public void onClick(DialogInterface dialog, int id) {
            	                           }
            	                       });                     
            	                AlertDialog alert = builder.create();
            	                alert.show();               
            	            }
            	        });
        				edittext_new_password.setText("");
        				edittext_confirm_new_password.setText("");
            			edittext_new_password.requestFocus();
        			}
        			else
        				count++;
        		}
        		
        		
        		if(count==3)
        		{
                //dialog = ProgressDialog.show(Login.this, "", 
                 //       "Validating user...", true);
                 new Thread(new Runnable() {
                        public void run() {
                            checkPassword();                          
                        }
                      }).start();               
        		}    
        	}       
            
        });
		
		
    }
	
	//Function to check is password is corrent
	void checkPassword(){
        try{            
        	
        	EditText edittext_password = (EditText) findViewById(R.id.et_profile_old_password);
    		
        	HttpPost httppost;
    	    //StringBuffer buffer;
    	    //HttpResponse response;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
    		//ProgressDialog dialog = null;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/checkpassword.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(1);
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
            nameValuePairs.add(new BasicNameValuePair("userpassword",edittext_password.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
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
             
            if(response.equalsIgnoreCase("User Not Found")){
            	new Thread(new Runnable() {
                    public void run() {    
                    	//Toast.makeText(Register.this,"000000", Toast.LENGTH_SHORT).show();
                    	showIncorrectPasswordAlert();                          
                    }
                  }).start();   
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                update_password();
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
        
        
    }

	//Function to update password
	void update_password(){
        try{            
        	
    		EditText edittext_password = (EditText) findViewById(R.id.et_profile_new_password);
    		
        	HttpPost httppost;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/updatepassword.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(2); 
            nameValuePairs.add(new BasicNameValuePair("username",username));  // $Edittext_value = $_POST['Edittext_value'];
            nameValuePairs.add(new BasicNameValuePair("password",edittext_password.getText().toString().trim())); 
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
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
                        Toast.makeText(Profile.this,"Error", Toast.LENGTH_SHORT).show();
                    }
                });
                 
                
            }else{
            	runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(Profile.this,"Password Changed", Toast.LENGTH_SHORT).show();
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
             
        }catch(Exception e){
        }
        
        
    }
	
	
	public void showIncorrectPasswordAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Profile.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this,R.style.AlertDialogTheme);
	            builder.setTitle("Incorrect Password");
	            builder.setMessage("Please enter your correct current password")  
	                   .setCancelable(false)
	                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                       public void onClick(DialogInterface dialog, int id) {
	                    	   EditText edittext_password= (EditText) findViewById(R.id.et_profile_old_password);
	                    	   edittext_password.setText("");
	                    	   edittext_password.requestFocus();
	                       }
	                   });                     
	            AlertDialog alert = builder.create();
	            alert.show();               
	        }
	    });
        
    }
		

	//Regular expression function, validating password for increasing strength of password 
	public boolean validPassword(String phone) {
		String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	    Pattern pattern = Pattern.compile(PASSWORD, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(phone).matches();
	}
}
