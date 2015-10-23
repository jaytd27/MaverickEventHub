package server.maverickeventhub;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
//import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
//import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import server.maverickeventhub.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
//import android.widget.DatePicker;
import android.widget.EditText;
//import android.widget.DatePicker;
//import android.widget.EditText;
import android.widget.TextView;
//import android.widget.TimePicker;
//import android.widget.TimePicker;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class EditGaming extends Activity {
	int i=0;
    String username = "";
    int size=0;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editgaming);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		Button button_help = (Button) findViewById(R.id.btn_edit_gaming_help);
		Button button_close = (Button) findViewById(R.id.btn_edit_gaming_close);
		Button button_next = (Button) findViewById(R.id.btn_edit_gaming_next);
		Button button_previous = (Button) findViewById(R.id.btn_edit_gaming_previous);
		Button button_update = (Button) findViewById(R.id.btn_gaming_update);
		TextView textview_gaming = (TextView) findViewById(R.id.tv_edit_gaming);
		EditText edittext_id = (EditText) findViewById(R.id.eT_gaming_id);
		TextView textview_id1 = (TextView) findViewById(R.id.tv_edit_gaming_id1);
		EditText edittext_name = (EditText) findViewById(R.id.eT_gaming_name);
		TextView textview_name1 = (TextView) findViewById(R.id.tv_edit_gaming_name1);
		EditText edittext_type = (EditText) findViewById(R.id.eT_gaming_type);
		TextView textview_type1 = (TextView) findViewById(R.id.tv_edit_gaming_type1);
		EditText edittext_date = (EditText) findViewById(R.id.eT_gaming_date);
		TextView textview_date1 = (TextView) findViewById(R.id.tv_edit_gaming_date1);
		EditText edittext_prize = (EditText) findViewById(R.id.eT_gaming_prize);
		TextView textview_prize1 = (TextView) findViewById(R.id.tv_edit_gaming_prize1);
		EditText edittext_location = (EditText) findViewById(R.id.eT_gaming_location);
		TextView textview_location1 = (TextView) findViewById(R.id.tv_edit_gaming_location1);
		EditText edittext_fee = (EditText) findViewById(R.id.eT_gaming_fee);
		TextView textview_fee1 = (TextView) findViewById(R.id.tv_edit_gaming_fee1);
		EditText edittext_description = (EditText) findViewById(R.id.eT_gaming_description);
		TextView textview_description1 = (TextView) findViewById(R.id.tv_edit_gaming_description1);
		EditText edittext_extra = (EditText) findViewById(R.id.eT_gaming_extra);
		TextView textview_extra1 = (TextView) findViewById(R.id.tv_edit_gaming_extra1);
	
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		   
		//Set font for all controls to metro ui font		
		button_help.setTypeface(font);
		button_close.setTypeface(font);
		textview_gaming.setTypeface(font);
		edittext_id.setTypeface(font);
		textview_id1.setTypeface(font);
		edittext_name.setTypeface(font);
		textview_name1.setTypeface(font);
		edittext_type.setTypeface(font);
		textview_type1.setTypeface(font);
		edittext_date.setTypeface(font);
		textview_date1.setTypeface(font);
		edittext_location.setTypeface(font);
		textview_location1.setTypeface(font);
		edittext_fee.setTypeface(font);
		textview_fee1.setTypeface(font);
		edittext_description.setTypeface(font);
		textview_description1.setTypeface(font);
		edittext_extra.setTypeface(font);
		textview_extra1.setTypeface(font);
		edittext_prize.setTypeface(font);
		textview_prize1.setTypeface(font);
		button_update.setTypeface(font);
		
		//ScrollView sv_gaming = (ScrollView) findViewById(R.id.sv_gaming);
		//ListView lv_gaming = (ListView) findViewById(R.id.lv_gaming);
			
		StrictMode.enableDefaults(); //STRICT MODE ENABLED
				
		//nameView = (TextView) findViewById(R.id.nametxt);
		//ageView = (TextView) findViewById(R.id.agetxt);
		//jobView = (TextView) findViewById(R.id.jobtxt);
		getData(i);
		//Close event
        button_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	finish();
            }
		});
        
        
        
        
        
        	//Updating Event
      		button_update.setOnClickListener(new OnClickListener() {
      			 
      		     @Override
      		     public void onClick(View v) {
      		    	 
      		    	//EditText edittext_id = (EditText) findViewById(R.id.eT_gaming_id);
      				EditText edittext_name = (EditText) findViewById(R.id.eT_gaming_name);
      				EditText edittext_type = (EditText) findViewById(R.id.eT_gaming_type);
      				//EditText edittext_date = (EditText) findViewById(R.id.eT_gaming_date);
      				EditText edittext_prize = (EditText) findViewById(R.id.eT_gaming_prize);
      				EditText edittext_location = (EditText) findViewById(R.id.eT_gaming_location);
      				EditText edittext_fee = (EditText) findViewById(R.id.eT_gaming_fee);
      				//EditText edittext_description = (EditText) findViewById(R.id.eT_gaming_description);
      				//EditText edittext_extra = (EditText) findViewById(R.id.eT_gaming_extra);
      				
      				int count=0;
      				String name = edittext_name.getText().toString();
      				String type = edittext_type.getText().toString();
      				String location = edittext_location.getText().toString();
      				String fee = edittext_fee.getText().toString();
      				String prize = edittext_prize.getText().toString();
      				
      				//Validate all input controls 
      		    	if(name.equals(""))
      	        		{
      	        			EditGaming.this.runOnUiThread(new Runnable() {
      	        	            public void run() {
      	        	                AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
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
      	        			EditGaming.this.runOnUiThread(new Runnable() {
      	        	            public void run() {
      	        	                AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
      	        	                builder.setTitle("Game Name Missing");
      	        	                builder.setMessage("Please enter the name of Game you are organising")  
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
      	        		if(prize.equals("")&&count==2)
      	        		{
      	        			EditGaming.this.runOnUiThread(new Runnable() {
      	        	            public void run() {
      	        	                AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
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
      	        			edittext_prize.requestFocus();
      	        		}
      	        		else
      	        		{	        			
      	        			count++;      	        			
      	           		}
      	        		if((location.equals(""))&&count==3)
      	        		{
      	        			EditGaming.this.runOnUiThread(new Runnable() {
      	        	            public void run() {
      	        	                AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
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
      	        		if(fee.equals("")&&count==4)
      	        		{
      	        			EditGaming.this.runOnUiThread(new Runnable() {
      	        	            public void run() {
      	        	                AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
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
      	        		
      	        		if(count==5)
      	        		{
      	                //dialog = ProgressDialog.show(Login.this, "", 
      	                 //       "Validating user...", true);
      	                 new Thread(new Runnable() {
      	                        public void run() {    
      	                        	runOnUiThread(new Runnable() {
      	                                public void run() {
      	                                	Toast.makeText(EditGaming.this,"Creating Event...", Toast.LENGTH_SHORT).show();
      	                                }
      	                            });

      	                            updateGamingEvent();                          
      	                        }
      	                      }).start();               
      	        		}   
      		     }
      	   });
              

        
        
        
        
        
        
        //Load help                        
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	EditGaming.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
    	                builder.setTitle("View Events");
    	                builder.setMessage("Click the next and previous buttons to browse through events. All events are ordered in ascending order of event date.")  
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
		
		button_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(i>=size-1)
            	{
            		runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(EditGaming.this,"Sorry, No more events.", Toast.LENGTH_SHORT).show();
                        }
                    });
            	}
            	else
            	{
            		i++;
            		getData(i);
            	}
            		            	
            }                        	
		});
		
		button_previous.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {            	
            	if(i<=0)
            	{
            		runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(EditGaming.this,"Already at first event.", Toast.LENGTH_SHORT).show();
                        }
                    });
            	}
            	else
                {
            		i--;
            		getData(i);
                }
            }                        	
		});
		

	}
	
	void updateGamingEvent(){
        try{            
        	runOnUiThread(new Runnable() {
                public void run() {
                	//Toast.makeText(Gaming.this,"Inside...", Toast.LENGTH_SHORT).show();
                }
            });
        	EditText edittext_id = (EditText) findViewById(R.id.eT_gaming_id);
			EditText edittext_name = (EditText) findViewById(R.id.eT_gaming_name);
			EditText edittext_type = (EditText) findViewById(R.id.eT_gaming_type);
			EditText edittext_date = (EditText) findViewById(R.id.eT_gaming_date);
			EditText edittext_prize = (EditText) findViewById(R.id.eT_gaming_prize);
			EditText edittext_location = (EditText) findViewById(R.id.eT_gaming_location);
			EditText edittext_fee = (EditText) findViewById(R.id.eT_gaming_fee);
			EditText edittext_description = (EditText) findViewById(R.id.eT_gaming_description);
			EditText edittext_extra = (EditText) findViewById(R.id.eT_gaming_extra);
    		
			
	        
	        runOnUiThread(new Runnable() {
                public void run() {
                	//Toast.makeText(Gaming.this,gaming_timestamp, Toast.LENGTH_SHORT).show();
                }
            });
	        
			
        	HttpPost httppost;
    	    HttpClient httpclient;
    	    List<NameValuePair> nameValuePairs;
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://omega.uta.edu/~jxm6478/updategaming.php"); // make sure the url is correct.
            //add your data
            nameValuePairs = new ArrayList<NameValuePair>(9);
             
            nameValuePairs.add(new BasicNameValuePair("id",edittext_id.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
            nameValuePairs.add(new BasicNameValuePair("name",edittext_name.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("type",edittext_type.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("date",edittext_date.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("prize",edittext_prize.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("location",edittext_location.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("fee",edittext_fee.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("details",edittext_description.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("extras",edittext_extra.getText().toString().trim()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            //Execute HTTP Post Request
            
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);
            System.out.println("Response : " + response); 
            runOnUiThread(new Runnable() {
                public void run() {                    
                    //dialog.dismiss();
                }
            });
             
            if(response.toString().equalsIgnoreCase("Error in Query")){
            	showAlert();    
            }else{
            	runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(EditGaming.this,"Event Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                            
            }
             
        }catch(Exception e){
            //dialog.dismiss();
            //System.out.println("Exception : " + e.getMessage());
        }
        
        
    }
	
	public void getData(int i){
	String result = "";
	InputStream isr = null;
	try{
	HttpClient httpclient = new DefaultHttpClient();
	List<NameValuePair> nameValuePairs;
	HttpPost httppost = new HttpPost("http://omega.uta.edu/~jxm6478/editgaming.php"); //YOUR PHP SCRIPT ADDRESS
	nameValuePairs = new ArrayList<NameValuePair>(1);
    // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
    nameValuePairs.add(new BasicNameValuePair("username",username));  // $Edittext_value = $_POST['Edittext_value']; 
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	HttpResponse response = httpclient.execute(httppost);
	HttpEntity entity = response.getEntity();
	isr = entity.getContent();
	}
	catch(Exception e){
	Log.e("log_tag", "Error in http connection "+e.toString());
	//nameView.setText("Couldnt connect to database");
	}
	//convert response to string
	try{
	BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
	StringBuilder sb = new StringBuilder();
	String line = null;
	while ((line = reader.readLine()) != null) {
	sb.append(line + "\n");
	}
	isr.close();
	
	result=sb.toString();
	}
	catch(Exception e){
	Log.e("log_tag", "Error converting result "+e.toString());
	}
	
	//parse json data
	try {
	String id ="";
	String name="";
	String type="";
	String date="";
	String location="";
	String fee="";
	String description="";
	String extra="";
	String prize="";
	
	
	JSONArray jArray = new JSONArray(result);
	
	size = jArray.length();
	JSONObject json = jArray.getJSONObject(i);
	id = json.getString("gaming_id");
	name = json.getString("gaming_name");
	type = json.getString("gaming_game");
	date = json.getString("gaming_date");
	location = json.getString("gaming_location");
	fee = json.getString("gaming_fee");
	description = json.getString("gaming_description");
	extra = json.getString("gaming_extra");
	prize = json.getString("gaming_prize");
	
	EditText edittext_id = (EditText) findViewById(R.id.eT_gaming_id);
	EditText edittext_name = (EditText) findViewById(R.id.eT_gaming_name);
	EditText edittext_type = (EditText) findViewById(R.id.eT_gaming_type);
	EditText edittext_date = (EditText) findViewById(R.id.eT_gaming_date);
	EditText edittext_location = (EditText) findViewById(R.id.eT_gaming_location);
	EditText edittext_fee = (EditText) findViewById(R.id.eT_gaming_fee);
	EditText edittext_description = (EditText) findViewById(R.id.eT_gaming_description);
	EditText edittext_extra = (EditText) findViewById(R.id.eT_gaming_extra);
	EditText edittext_prize = (EditText) findViewById(R.id.eT_gaming_prize);
	
	edittext_id.setText(id);
	edittext_name.setText(name);
	edittext_type.setText(type);
	edittext_date.setText(date);
	edittext_location.setText(location);
	edittext_fee.setText(fee);
	edittext_description.setText(description);
	edittext_extra.setText(extra);
	edittext_prize.setText(prize);
	
	//nameView.setText(n);
	//ageView.setText(a);
	//jobView.setText(j);
	 
	} catch (Exception e) {
	 
		Log.e("log_tag", "Error Parsing Data "+e.toString());
	}
	
		
		
	}	
	
	
	public void showAlert(){
		
	    EditGaming.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(EditGaming.this,R.style.AlertDialogTheme);
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
	
	public void onBackPressed()
	{
	    finish();
	}
	
}
