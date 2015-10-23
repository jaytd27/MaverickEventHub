package server.maverickeventhub;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
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
//import android.widget.EditText;
import android.widget.TextView;
//import android.widget.TimePicker;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ViewGaming extends Activity {
	int i=0;
    String username = "";
    int size=0;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewgaming);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		Button button_help = (Button) findViewById(R.id.btn_view_gaming_help);
		Button button_close = (Button) findViewById(R.id.btn_view_gaming_close);
		Button button_next = (Button) findViewById(R.id.btn_view_gaming_next);
		Button button_previous = (Button) findViewById(R.id.btn_view_gaming_previous);
		Button button_update = (Button) findViewById(R.id.btn_gaming_update);
		TextView textview_gaming = (TextView) findViewById(R.id.tv_view_gaming);
		TextView textview_organizer = (TextView) findViewById(R.id.tv_gaming_organiser);
		TextView textview_organizer1 = (TextView) findViewById(R.id.tv_gaming_organiser1);
		TextView textview_name = (TextView) findViewById(R.id.tv_gaming_name);
		TextView textview_name1 = (TextView) findViewById(R.id.tv_gaming_name1);
		TextView textview_type = (TextView) findViewById(R.id.tv_gaming_type);
		TextView textview_type1 = (TextView) findViewById(R.id.tv_gaming_type1);
		TextView textview_date = (TextView) findViewById(R.id.tv_gaming_date);
		TextView textview_date1 = (TextView) findViewById(R.id.tv_gaming_date1);
		TextView textview_prize = (TextView) findViewById(R.id.tv_gaming_prize);
		TextView textview_prize1 = (TextView) findViewById(R.id.tv_gaming_prize1);
		TextView textview_location = (TextView) findViewById(R.id.tv_gaming_location);
		TextView textview_location1 = (TextView) findViewById(R.id.tv_gaming_location1);
		TextView textview_fee = (TextView) findViewById(R.id.tv_gaming_fee);
		TextView textview_fee1 = (TextView) findViewById(R.id.tv_gaming_fee1);
		TextView textview_description = (TextView) findViewById(R.id.tv_gaming_description);
		TextView textview_description1 = (TextView) findViewById(R.id.tv_gaming_description1);
		TextView textview_extra = (TextView) findViewById(R.id.tv_gaming_extra);
		TextView textview_extra1 = (TextView) findViewById(R.id.tv_gaming_extra1);
	
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		   
		//Set font for all controls to metro ui font		
		button_help.setTypeface(font);
		button_close.setTypeface(font);
		button_update.setTypeface(font);
		textview_gaming.setTypeface(font);
		textview_organizer.setTypeface(font);
		textview_organizer1.setTypeface(font);
		textview_name.setTypeface(font);
		textview_name1.setTypeface(font);
		textview_type.setTypeface(font);
		textview_type1.setTypeface(font);
		textview_date.setTypeface(font);
		textview_date1.setTypeface(font);
		textview_location.setTypeface(font);
		textview_location1.setTypeface(font);
		textview_fee.setTypeface(font);
		textview_fee1.setTypeface(font);
		textview_description.setTypeface(font);
		textview_description1.setTypeface(font);
		textview_extra.setTypeface(font);
		textview_extra1.setTypeface(font);
		textview_prize.setTypeface(font);
		textview_prize1.setTypeface(font);
		
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
        
        button_update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	finish();
            }
		});
        
        //Load help                        
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	ViewGaming.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(ViewGaming.this,R.style.AlertDialogTheme);
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
                            Toast.makeText(ViewGaming.this,"Sorry, No more events.", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(ViewGaming.this,"Already at first record.", Toast.LENGTH_SHORT).show();
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
	
	public void getData(int i){
	String result = "";
	InputStream isr = null;
	try{
	HttpClient httpclient = new DefaultHttpClient();
	HttpPost httppost = new HttpPost("http://omega.uta.edu/~jxm6478/viewgaming.php"); //YOUR PHP SCRIPT ADDRESS
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
	String organizer ="";
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
	organizer = json.getString("user_name");
	name = json.getString("gaming_name");
	type = json.getString("gaming_game");
	date = json.getString("gaming_date");
	prize = json.getString("gaming_prize");
	location = json.getString("gaming_location");
	fee = json.getString("gaming_fee");
	description = json.getString("gaming_description");
	extra = json.getString("gaming_extra");
	
	TextView textview_organizer = (TextView) findViewById(R.id.tv_gaming_organiser);
	TextView textview_name = (TextView) findViewById(R.id.tv_gaming_name);
	TextView textview_type = (TextView) findViewById(R.id.tv_gaming_type);
	TextView textview_date = (TextView) findViewById(R.id.tv_gaming_date);
	TextView textview_prize = (TextView) findViewById(R.id.tv_gaming_prize);
	TextView textview_location = (TextView) findViewById(R.id.tv_gaming_location);
	TextView textview_fee = (TextView) findViewById(R.id.tv_gaming_fee);
	TextView textview_description = (TextView) findViewById(R.id.tv_gaming_description);
	TextView textview_extra = (TextView) findViewById(R.id.tv_gaming_extra);
	
	textview_organizer.setText(organizer);
	textview_name.setText(name);
	textview_type.setText(type);
	textview_date.setText(date);
	textview_prize.setText(prize);
	textview_location.setText(location);
	textview_fee.setText(fee);
	textview_description.setText(description);
	textview_extra.setText(extra);
	
	//nameView.setText(n);
	//ageView.setText(a);
	//jobView.setText(j);
	 
	} catch (Exception e) {
	 
		Log.e("log_tag", "Error Parsing Data "+e.toString());
	}
	
		
		
	}	
	
	
	public void showAlert(){
		
	    ViewGaming.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(ViewGaming.this,R.style.AlertDialogTheme);
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
