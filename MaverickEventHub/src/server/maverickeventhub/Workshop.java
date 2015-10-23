package server.maverickeventhub;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;

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
//import android.content.Context;
import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.Point;
//import android.graphics.Rect;
import android.graphics.Typeface;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
//import android.view.Gravity;
//import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.*;

public class Workshop extends Activity {
	
    String username = "";
    
    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.workshop);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		//Define all controls used in the UI
		Button button_help = (Button) findViewById(R.id.btn_workshop_help);
		Button button_close = (Button) findViewById(R.id.btn_workshop_close);
		Button button_create = (Button) findViewById(R.id.btn_workshop_create);
		TextView textview_workshop = (TextView) findViewById(R.id.tv_workshop);
		TextView textview_name = (TextView) findViewById(R.id.tv_workshop_name);
		TextView textview_type = (TextView) findViewById(R.id.tv_workshop_type);
		TextView textview_date = (TextView) findViewById(R.id.tv_workshop_date);
		TextView textview_time = (TextView) findViewById(R.id.tv_workshop_time);
		TextView textview_fee = (TextView) findViewById(R.id.tv_workshop_fee);
		TextView textview_location = (TextView) findViewById(R.id.tv_workshop_location);
		TextView textview_details = (TextView) findViewById(R.id.tv_workshop_details);
		TextView textview_extras = (TextView) findViewById(R.id.tv_workshop_extras);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		EditText edittext_name = (EditText) findViewById(R.id.et_workshop_name);
		EditText edittext_type = (EditText) findViewById(R.id.et_workshop_type);
		EditText edittext_location = (EditText) findViewById(R.id.et_workshop_location);
		EditText edittext_fee = (EditText) findViewById(R.id.et_workshop_fee);
		EditText edittext_details = (EditText) findViewById(R.id.et_workshop_details);
		EditText edittext_extras = (EditText) findViewById(R.id.et_workshop_extras);
		DatePicker dp_date = (DatePicker) findViewById(R.id.dp_workshop_date);
		//TimePicker tp_time = (TimePicker) findViewById(R.id.tp_workshop_time);
		
		//Setthe datepicker value to be atleast more than today
		Calendar cal = Calendar.getInstance();
		   cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH), 
		            cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), 0);
		   long time = cal.getTimeInMillis();
		   dp_date.setMinDate(time);
		
		   //Set the font for all controls used in the UI to Metro UI font
		textview_name.setTypeface(font);
		textview_type.setTypeface(font);
		textview_date.setTypeface(font);
		textview_time.setTypeface(font);
		textview_fee.setTypeface(font);
		textview_location.setTypeface(font);
		textview_details.setTypeface(font);
		textview_extras.setTypeface(font);
		button_create.setTypeface(font);
		button_help.setTypeface(font);
		button_close.setTypeface(font);
		textview_workshop.setTypeface(font);
		edittext_name.setTypeface(font);
		edittext_type.setTypeface(font);
		edittext_location.setTypeface(font);
		edittext_fee.setTypeface(font);
		edittext_details.setTypeface(font);
		edittext_extras.setTypeface(font);		
        
		//Close event
        button_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	finish();
            }
		});
        
        //Load help on click on help
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Workshop.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(Workshop.this,R.style.AlertDialogTheme);
    	                builder.setTitle("Complete the form");
    	                builder.setMessage("Fill out the form as per your information.")  
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
		
		//Create event 
		button_create.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 
		    	EditText edittext_name = (EditText) findViewById(R.id.et_workshop_name);
		 		EditText edittext_type = (EditText) findViewById(R.id.et_workshop_type);
		 		EditText edittext_location = (EditText) findViewById(R.id.et_workshop_location);
		 		EditText edittext_fee = (EditText) findViewById(R.id.et_workshop_fee);
		 		/*EditText edittext_details = (EditText) findViewById(R.id.et_workshop_details);
		 		EditText edittext_extras = (EditText) findViewById(R.id.et_workshop_extras);
		 		DatePicker dp_date = (DatePicker) findViewById(R.id.dp_workshop_date);
				TimePicker tp_time = (TimePicker) findViewById(R.id.tp_workshop_time);*/
				int count=0;
				String name = edittext_name.getText().toString();
				String type = edittext_type.getText().toString();
				String location = edittext_name.getText().toString();
				String fee = edittext_name.getText().toString();
				
				//Perform validation on all form controls
		    	if(name.equals(""))
	        		{
	        			Workshop.this.runOnUiThread(new Runnable() {
	        	            public void run() {
	        	                AlertDialog.Builder builder = new AlertDialog.Builder(Workshop.this,R.style.AlertDialogTheme);
	        	                builder.setTitle("Event Name Missing");
	        	                builder.setMessage("Please enter name for your Event")  
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
	        		{
	        			count++;
	           		}
	        		if(type.equals("")&&count==1)
	        		{
	        			Workshop.this.runOnUiThread(new Runnable() {
	        	            public void run() {
	        	                AlertDialog.Builder builder = new AlertDialog.Builder(Workshop.this,R.style.AlertDialogTheme);
	        	                builder.setTitle("Topic Missing");
	        	                builder.setMessage("Please enter the topic of your workshop")  
	        	                       .setCancelable(false)
	        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        	                           public void onClick(DialogInterface dialog, int id) {
	        	                           }
	        	                       });                     
	        	                AlertDialog alert = builder.create();
	        	                alert.show();               
	        	            }
	        	        });
	        			edittext_type.requestFocus();
	        		}
	        		else
	        			count++;
	        		if((location.equals(""))&&count==2)
	        		{
	        			Workshop.this.runOnUiThread(new Runnable() {
	        	            public void run() {
	        	                AlertDialog.Builder builder = new AlertDialog.Builder(Workshop.this,R.style.AlertDialogTheme);
	        	                builder.setTitle("Event Location Missing");
	        	                builder.setMessage("Please enter the location where your Event is taking place")  
	        	                       .setCancelable(false)
	        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        	                           public void onClick(DialogInterface dialog, int id) {
	        	                           }
	        	                       });                     
	        	                AlertDialog alert = builder.create();
	        	                alert.show();               
	        	            }
	        	        });
	        			edittext_location.requestFocus();
	        		}
	        		else
	        		{
	        			count++;
	        			
	           		}
	        		if(fee.equals("")&&count==3)
	        		{
	        			Workshop.this.runOnUiThread(new Runnable() {
	        	            public void run() {
	        	                AlertDialog.Builder builder = new AlertDialog.Builder(Workshop.this,R.style.AlertDialogTheme);
	        	                builder.setTitle("Event Fees Missing");
	        	                builder.setMessage("Please enter the fee needed to enter your event, or enter 0 if free")  
	        	                       .setCancelable(false)
	        	                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        	                           public void onClick(DialogInterface dialog, int id) {
	        	                           }
	        	                       });                     
	        	                AlertDialog alert = builder.create();
	        	                alert.show();               
	        	            }
	        	        });
	        			edittext_fee.requestFocus();
	        		}
	        		else
	        		{	        			
	        			count++;
	        			
	           		}
	        		
	        		if(count==4)
	        		{
	                //dialog = ProgressDialog.show(Login.this, "", 
	                 //       "Validating user...", true);
	                 new Thread(new Runnable() {
	                        public void run() {    
	                        	runOnUiThread(new Runnable() {
	                                public void run() {
	                                	Toast.makeText(Workshop.this,"Creating Event...", Toast.LENGTH_SHORT).show();
	                                }
	                            });

	                            createWorkshopEvent();                          
	                        }
	                      }).start();               
	        		}   
		     }
	   });
        
	}
	
	//Function to create event
	void createWorkshopEvent(){
        try{            
        	runOnUiThread(new Runnable() {
                public void run() {
                	//Toast.makeText(Workshop.this,"Inside...", Toast.LENGTH_SHORT).show();
                }
            });
        	EditText edittext_name = (EditText) findViewById(R.id.et_workshop_name);
	 		EditText edittext_type = (EditText) findViewById(R.id.et_workshop_type);
	 		EditText edittext_location = (EditText) findViewById(R.id.et_workshop_location);
	 		EditText edittext_fee = (EditText) findViewById(R.id.et_workshop_fee);
	 		EditText edittext_details = (EditText) findViewById(R.id.et_workshop_details);
	 		EditText edittext_extras = (EditText) findViewById(R.id.et_workshop_extras);
	 		DatePicker dp_date = (DatePicker) findViewById(R.id.dp_workshop_date);
			TimePicker tp_time = (TimePicker) findViewById(R.id.tp_workshop_time);
    		
			Integer dp_Year = dp_date.getYear();
	        Integer dp_Month = dp_date.getMonth() + 1;
	        Integer dp_Date = dp_date.getDayOfMonth();
	        Integer tp_Hour = tp_time.getCurrentHour();
	        Integer tp_Minute = tp_time.getCurrentMinute();	        
	        StringBuilder sb=new StringBuilder();
	        sb.append(dp_Year.toString()).append("-").append(dp_Month.toString()).append("-").append(dp_Date.toString()).append(" ").append(tp_Hour.toString()).append(":").append(tp_Minute.toString()).append(":00");
	        final String workshop_timestamp=sb.toString();
	        
	        runOnUiThread(new Runnable() {
                public void run() {
                	//Toast.makeText(Workshop.this,workshop_timestamp, Toast.LENGTH_SHORT).show();
                }
            });
	        
			
        	HttpPost httppost;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/createworkshop.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(8); 
            nameValuePairs.add(new BasicNameValuePair("username",username));  // $Edittext_value = $_POST['Edittext_value'];
            nameValuePairs.add(new BasicNameValuePair("name",edittext_name.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("type",edittext_type.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("date",workshop_timestamp));
            nameValuePairs.add(new BasicNameValuePair("location",edittext_location.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("fee",edittext_fee.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("details",edittext_details.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("extras",edittext_extras.getText().toString().trim()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            //Execute HTTP Post Request
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);
            System.out.println("Response : " + response); 
            runOnUiThread(new Runnable() {
                public void run() {
                }
            });
             
            if(response.toString().equalsIgnoreCase("Error in Query")){
            	showAlert();    
            }else{
            	runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(Workshop.this,"Event Created", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                            
            }
             
        }catch(Exception e){
        }
        
        
    }
	
	//Show alert on error
	public void showAlert(){
		//Toast.makeText(Login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
	    Workshop.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(Workshop.this,R.style.AlertDialogTheme);
	            builder.setTitle("Error");
	            builder.setMessage("Error")  
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
	
	//Back Event
	public void onBackPressed()
	{
	    finish();
	}
	
}
