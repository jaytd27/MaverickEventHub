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
//import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {

	HttpResponse response;
	HttpResponse username_response;
	HttpResponse uta_email_response;
	HttpResponse email_response;
	HttpResponse phone_response;
	

public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.register);
	
	//Define all controls used in the UI
	TextView textview_username= (TextView) findViewById(R.id.tv_username);
	//TextView textview_password= (TextView) findViewById(R.id.tv_password);
	TextView textview_name= (TextView) findViewById(R.id.tv_name);
	TextView textview_uta_email= (TextView) findViewById(R.id.tv_uta_email);
	TextView textview_email= (TextView) findViewById(R.id.tv_email);
	TextView textview_phone= (TextView) findViewById(R.id.tv_phone);
	EditText edittext_username= (EditText) findViewById(R.id.et_username);
	//EditText edittext_password= (EditText) findViewById(R.id.et_password);
	EditText edittext_name= (EditText) findViewById(R.id.et_name);
	EditText edittext_uta_email= (EditText) findViewById(R.id.et_uta_email);
	EditText edittext_email= (EditText) findViewById(R.id.et_email);
	EditText edittext_phone= (EditText) findViewById(R.id.et_phone);
	
	Button button_close = (Button) findViewById(R.id.btn_close);
	Button button_refresh = (Button) findViewById(R.id.btn_refresh);
	Button button_signup = (Button) findViewById(R.id.btn_signup);
	Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
	
	//Set the font for all controls to Metro UI font
		textview_username.setTypeface(font);
		//textview_password.setTypeface(font);
		textview_name.setTypeface(font);
		textview_uta_email.setTypeface(font);
		textview_email.setTypeface(font);		
		textview_phone.setTypeface(font);
		
		edittext_username.setTypeface(font);
		//edittext_password.setTypeface(font);
		edittext_name.setTypeface(font);
		edittext_uta_email.setTypeface(font);
		edittext_email.setTypeface(font);		
		edittext_phone.setTypeface(font);
		
		//button_close.setTypeface(font);
		//button_refresh.setTypeface(font);
		//button_signup.setTypeface(font);
		
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
		
		
		//Refresh all fields
		button_refresh.setOnClickListener(new OnClickListener() {
			  @Override
			  public void onClick(View v) {
				  EditText edittext_username= (EditText) findViewById(R.id.et_username);
					//EditText edittext_password= (EditText) findViewById(R.id.et_password);
					EditText edittext_name= (EditText) findViewById(R.id.et_name);
					EditText edittext_uta_email= (EditText) findViewById(R.id.et_uta_email);
					EditText edittext_email= (EditText) findViewById(R.id.et_email);
					EditText edittext_phone= (EditText) findViewById(R.id.et_phone);
					
				  	edittext_username.setText("");
					//edittext_password.setTypeface(font);
					edittext_name.setText("");
					edittext_uta_email.setText("");
					edittext_email.setText("");	
					edittext_phone.setText("");
			  }
			});
		
		//Sign up event, register
		button_signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	EditText edittext_username= (EditText) findViewById(R.id.et_username);
            	//EditText edittext_password= (EditText) findViewById(R.id.et_password);
            	EditText edittext_name= (EditText) findViewById(R.id.et_name);
            	EditText edittext_uta_email= (EditText) findViewById(R.id.et_uta_email);
            	EditText edittext_email= (EditText) findViewById(R.id.et_email);
            	EditText edittext_phone= (EditText) findViewById(R.id.et_phone);
        		String username = edittext_username.getText().toString();
        		//String password = edittext_password.getText().toString();
        		String name = edittext_name.getText().toString();
        		String uta_email = edittext_uta_email.getText().toString();
        		String email = edittext_email.getText().toString();
        		String phone = edittext_phone.getText().toString();
            	int count=0;
        		//ProgressDialog dialog = null;
        		
            	//All validation on controls
        		if(username.equals(""))
        		{
        			Register.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
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
        		{
        			if(!validUsername(username)&&count==0)
        			{
        				Register.this.runOnUiThread(new Runnable() {
            	            public void run() {
            	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
            	                builder.setTitle("Invalid Username Format");
            	                builder.setMessage("Please enter a valid username, 3-20 alpha numberic characters including ('-' and '_')")  
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
           		}
        		if(name.equals("")&&count==1)
        		{
        			Register.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Name Missing");
        	                builder.setMessage("Please enter your name")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_name.requestFocus();
        		}
        		else
        			count++;
        		if((uta_email.equals("")||uta_email.equals(""))&&count==2)
        		{
        			Register.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
        	                builder.setTitle("UTA E-mail Address Missing");
        	                builder.setMessage("Please enter your UTA e-mail address")  
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
        			if(!validUTAEmail(uta_email)&&count==2)
        			{
        				Register.this.runOnUiThread(new Runnable() {
            	            public void run() {
            	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
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
        		if(email.equals("")&&count==3)
        		{
        			Register.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
        	                builder.setTitle("E-mail Address Missing");
        	                builder.setMessage("Please enter your e-mail address")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_email.requestFocus();
        		}
        		else
        		{
        			if(!validEmail(email)&&count==3)
        			{
        				Register.this.runOnUiThread(new Runnable() {
            	            public void run() {
            	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
            	                builder.setTitle("Invalid E-mail Address");
            	                builder.setMessage("Please enter a valid e-mail address")  
            	                       .setCancelable(false)
            	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	                           public void onClick(DialogInterface dialog, int id) {
            	                           }
            	                       });                     
            	                AlertDialog alert = builder.create();
            	                alert.show();               
            	            }
            	        });
            			edittext_email.requestFocus();
        			}
        			else
        				count++;
        			
           		}
        		if(phone.equals("")&&count==4)
        		{
        			Register.this.runOnUiThread(new Runnable() {
        	            public void run() {
        	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
        	                builder.setTitle("Phone Number Missing");
        	                builder.setMessage("Please enter your phone number")  
        	                       .setCancelable(false)
        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        	                           public void onClick(DialogInterface dialog, int id) {
        	                           }
        	                       });                     
        	                AlertDialog alert = builder.create();
        	                alert.show();               
        	            }
        	        });
        			edittext_phone.requestFocus();
        		}        
        		else
        		{
        			if(!validPhone(phone)&&count==4)
        			{
        				Register.this.runOnUiThread(new Runnable() {
            	            public void run() {
            	                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
            	                builder.setTitle("Invalid Phone Number");
            	                builder.setMessage("Please enter a valid Phone number")  
            	                       .setCancelable(false)
            	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	                           public void onClick(DialogInterface dialog, int id) {
            	                           }
            	                       });                     
            	                AlertDialog alert = builder.create();
            	                alert.show();               
            	            }
            	        });
            			edittext_phone.requestFocus();
        			}
        			else
        				count++;
        			
           		}
        		if(count==5)
        		{
                //dialog = ProgressDialog.show(Login.this, "", 
                 //       "Validating user...", true);
                 new Thread(new Runnable() {
                        public void run() {    
                        	//Toast.makeText(Register.this,"000000", Toast.LENGTH_SHORT).show();
                            checkUsername();                          
                        }
                      }).start();               
        		}    
        	}       
            
        });
		
	}

	//Register function
	void register(){
	    try{            
	    	EditText edittext_username= (EditText) findViewById(R.id.et_username);
	    	//EditText edittext_password= (EditText) findViewById(R.id.et_password);
	    	EditText edittext_name= (EditText) findViewById(R.id.et_name);
	    	EditText edittext_uta_email= (EditText) findViewById(R.id.et_uta_email);
	    	EditText edittext_email= (EditText) findViewById(R.id.et_email);
	    	EditText edittext_phone= (EditText) findViewById(R.id.et_phone);
			
	    	HttpPost httppost;
		    //StringBuffer buffer;
		    //HttpResponse response;
		    HttpClient httpclient;
		    List<NameValuePair> nameValuePairs;
			//ProgressDialog dialog = null;
	          
	        httpclient=new DefaultHttpClient();
	        httppost= new HttpPost("http://omega.uta.edu/~jxm6478/register.php"); // make sure the url is correct.
	        //add your data
	        nameValuePairs = new ArrayList<NameValuePair>(5);
	        // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
	        nameValuePairs.add(new BasicNameValuePair("username",edittext_username.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
	        //nameValuePairs.add(new BasicNameValuePair("password",edittext_password.getText().toString().trim()));
	        nameValuePairs.add(new BasicNameValuePair("name",edittext_name.getText().toString().trim()));
	        nameValuePairs.add(new BasicNameValuePair("uta_email",edittext_uta_email.getText().toString().trim())); 
	        nameValuePairs.add(new BasicNameValuePair("email",edittext_email.getText().toString().trim())); 
	        nameValuePairs.add(new BasicNameValuePair("phone",edittext_phone.getText().toString().trim())); 
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
	                    Toast.makeText(Register.this,"Error", Toast.LENGTH_SHORT).show();
	                }
	            });
	             
	        }else{
	        	runOnUiThread(new Runnable() {
	                public void run() {
	                    Toast.makeText(Register.this,"Successfully Registered", Toast.LENGTH_SHORT).show();
	                	//startActivity(new Intent(Register.this, Registered.class));
	                	
	                	new AsyncTask<Void, Integer, Void>(){
	           			 ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
	           	         @Override
	           	         protected Void doInBackground(Void... params) {
	           	        	 int progressStatus = 0;
	           	             while (progressStatus < 100) {
	           	                 progressStatus++;
	           	                 if(progressStatus == 99)
	           	                 {
	           	                	 Intent i = new Intent(Register.this, Registered.class);
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
	
	public void showAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Register.this.runOnUiThread(new Runnable() {
	        public void run() {
	            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
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
	
	

	
	public boolean validUTAEmail(String email) {
		String UTA_EMAIL_ADDRESS = "^[A-Z0-9._%+-]+@mavs.uta.edu$";
		
	    //Pattern pattern = Patterns.EMAIL_ADDRESS;	    
	    Pattern pattern = Pattern.compile(UTA_EMAIL_ADDRESS, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(email).matches();
	}
	
	public boolean validEmail(String email) {
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	public boolean validPhone(String phone) {
		String PHONE_NUMBER = "^[+]?[0-9]{10,13}$";
	    Pattern pattern = Pattern.compile(PHONE_NUMBER, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(phone).matches();
	}
	
	public boolean validUsername(String phone) {
		String USERNAME = "^[a-z0-9_-]{3,25}$";
	    Pattern pattern = Pattern.compile(USERNAME, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(phone).matches();
	}
	
	public boolean validPassword(String phone) {
		String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	    Pattern pattern = Pattern.compile(PASSWORD, Pattern.CASE_INSENSITIVE);
	    return pattern.matcher(phone).matches();
	}
	
	void checkUsername(){
        try{            
        	
        	EditText edittext_username = (EditText) findViewById(R.id.et_username);
    		
        	HttpPost httppost;
    	    //StringBuffer buffer;
    	    //HttpResponse response;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
    		//ProgressDialog dialog = null;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/checkusername.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(1);
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
            nameValuePairs.add(new BasicNameValuePair("username",edittext_username.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
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
                        checkUTAEmail();                          
                    }
                  }).start();   
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                showUsernameAlert();
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
        
        
    }
	
	void checkUTAEmail(){
		try{            
        	
        	EditText edittext_uta_email = (EditText) findViewById(R.id.et_uta_email);
    		
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
                        checkEmail();                          
                    }
                  }).start();   
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                showUTAEmailAlert();
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        } 
    	    
    }
	
	void checkEmail(){
		try{            
        	
        	EditText edittext_email = (EditText) findViewById(R.id.et_email);
    		
        	HttpPost httppost;
    	    //StringBuffer buffer;
    	    //HttpResponse response;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
    		//ProgressDialog dialog = null;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/checkemail.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(1);
            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
            nameValuePairs.add(new BasicNameValuePair("email",edittext_email.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
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
                        checkPhone();                          
                    }
                  }).start();   
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                showEmailAlert();
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
    	    
    	}
	
	
	void checkPhone(){
		try{            
        	
        	EditText edittext_phone = (EditText) findViewById(R.id.et_phone);
    		
        	HttpPost httppost;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/checkphone.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(1); 
            nameValuePairs.add(new BasicNameValuePair("phone",edittext_phone.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
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
                        register();                          
                    }
                  }).start();                  
            }else{
            	//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                showPhoneAlert();
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
    	    
    	}
	
    //Show Username already exists on error    
	public void showUsernameAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Register.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
	            builder.setTitle("Username Already Exists");
	            builder.setMessage("Please enter a different username")  
	                   .setCancelable(false)
	                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                       public void onClick(DialogInterface dialog, int id) {
	                    	   EditText edittext_username= (EditText) findViewById(R.id.et_username);
	                    	   edittext_username.requestFocus();
	                       }
	                   });                     
	            AlertDialog alert = builder.create();
	            alert.show();               
	        }
	    });
        
    }
	
	//Show UTA email already exists on error
	public void showUTAEmailAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Register.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
	            builder.setTitle("UTA E-mail Address Already Exists");
	            builder.setMessage("Please enter a different UTA e-mail address")  
	                   .setCancelable(false)
	                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                       public void onClick(DialogInterface dialog, int id) {
	                    	   EditText edittext_uta_email= (EditText) findViewById(R.id.et_uta_email);
	                    	   edittext_uta_email.requestFocus();
	                       }
	                   });                     
	            AlertDialog alert = builder.create();
	            alert.show();               
	        }
	    });
        
    }
	
	//Show email already exists alert on error
	public void showEmailAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Register.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
	            builder.setTitle("E-mail Address Already Exists");
	            builder.setMessage("Please enter a different e-mail address")  
	                   .setCancelable(false)
	                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                       public void onClick(DialogInterface dialog, int id) {
	                    	   EditText edittext_email= (EditText) findViewById(R.id.et_email);
	                    	   edittext_email.requestFocus();
	                       }
	                   });                     
	            AlertDialog alert = builder.create();
	            alert.show();               
	        }
	    });
        
    }
	
	//Show alert on error
	public void showPhoneAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Register.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this,R.style.AlertDialogTheme);
	            builder.setTitle("Phone Number Already Exists");
	            builder.setMessage("Please enter a different phone number")  
	                   .setCancelable(false)
	                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                       public void onClick(DialogInterface dialog, int id) {
	                    	   EditText edittext_phone= (EditText) findViewById(R.id.et_phone);
	                    	   edittext_phone.requestFocus();
	                       }
	                   });                     
	            AlertDialog alert = builder.create();
	            alert.show();               
	        }
	    });
        
    }
	
	//Back event 
	public void onBackPressed()
	{
	    finish();
	}
}