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
import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
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
import android.widget.EditText;
//import android.widget.DatePicker;
//import android.widget.EditText;
import android.widget.TextView;
//import android.widget.TimePicker;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class EditSports extends Activity {
	int i=0;
    String username = "";
    int size=0;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editsports);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		Button button_help = (Button) findViewById(R.id.btn_edit_sports_help);
		Button button_close = (Button) findViewById(R.id.btn_edit_sports_close);
		Button button_next = (Button) findViewById(R.id.btn_edit_sports_next);
		Button button_previous = (Button) findViewById(R.id.btn_edit_sports_previous);
		Button button_update = (Button) findViewById(R.id.btn_sports_update);
		TextView textview_sports = (TextView) findViewById(R.id.tv_edit_sports);
		EditText edittext_id = (EditText) findViewById(R.id.eT_sports_id);
		TextView textview_id1 = (TextView) findViewById(R.id.tv_edit_sports_id1);
		EditText edittext_name = (EditText) findViewById(R.id.eT_sports_name);
		TextView textview_name1 = (TextView) findViewById(R.id.tv_edit_sports_name1);
		EditText edittext_type = (EditText) findViewById(R.id.eT_sports_type);
		TextView textview_type1 = (TextView) findViewById(R.id.tv_edit_sports_type1);
		EditText edittext_date = (EditText) findViewById(R.id.eT_sports_date);
		TextView textview_date1 = (TextView) findViewById(R.id.tv_edit_sports_date1);
		EditText edittext_location = (EditText) findViewById(R.id.eT_sports_location);
		TextView textview_location1 = (TextView) findViewById(R.id.tv_edit_sports_location1);
		EditText edittext_fee = (EditText) findViewById(R.id.eT_sports_fee);
		TextView textview_fee1 = (TextView) findViewById(R.id.tv_edit_sports_fee1);
		EditText edittext_description = (EditText) findViewById(R.id.eT_sports_description);
		TextView textview_description1 = (TextView) findViewById(R.id.tv_edit_sports_description1);
		EditText edittext_extra = (EditText) findViewById(R.id.eT_sports_extra);
		TextView textview_extra1 = (TextView) findViewById(R.id.tv_edit_sports_extra1);
	
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		   
		//Set font for all controls to metro ui font		
		button_help.setTypeface(font);
		button_close.setTypeface(font);
		textview_sports.setTypeface(font);
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
		button_update.setTypeface(font);
		
		//ScrollView sv_sports = (ScrollView) findViewById(R.id.sv_sports);
		//ListView lv_sports = (ListView) findViewById(R.id.lv_sports);
			
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
        
        //Load help                        
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	EditSports.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(EditSports.this,R.style.AlertDialogTheme);
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
                            Toast.makeText(EditSports.this,"Sorry, No more events.", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(EditSports.this,"Already at first event.", Toast.LENGTH_SHORT).show();
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
	List<NameValuePair> nameValuePairs;
	HttpPost httppost = new HttpPost("http://omega.uta.edu/~jxm6478/editsports.php"); //YOUR PHP SCRIPT ADDRESS
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
	
	
	JSONArray jArray = new JSONArray(result);
	
	size = jArray.length();
	JSONObject json = jArray.getJSONObject(i);
	id = json.getString("sports_id");
	name = json.getString("sports_name");
	type = json.getString("sports_type");
	date = json.getString("sports_date");
	location = json.getString("sports_location");
	fee = json.getString("sports_fee");
	description = json.getString("sports_description");
	extra = json.getString("sports_extra");
	
	EditText edittext_id = (EditText) findViewById(R.id.eT_sports_id);
	EditText edittext_name = (EditText) findViewById(R.id.eT_sports_name);
	EditText edittext_type = (EditText) findViewById(R.id.eT_sports_type);
	EditText edittext_date = (EditText) findViewById(R.id.eT_sports_date);
	EditText edittext_location = (EditText) findViewById(R.id.eT_sports_location);
	EditText edittext_fee = (EditText) findViewById(R.id.eT_sports_fee);
	EditText edittext_description = (EditText) findViewById(R.id.eT_sports_description);
	EditText edittext_extra = (EditText) findViewById(R.id.eT_sports_extra);
	
	edittext_id.setText(id);
	edittext_name.setText(name);
	edittext_type.setText(type);
	edittext_date.setText(date);
	edittext_location.setText(location);
	edittext_fee.setText(fee);
	edittext_description.setText(description);
	edittext_extra.setText(extra);
	
	//nameView.setText(n);
	//ageView.setText(a);
	//jobView.setText(j);
	 
	} catch (Exception e) {
	 
		Log.e("log_tag", "Error Parsing Data "+e.toString());
	}
	
		
		
	}	
	
	
	public void showAlert(){
		
	    EditSports.this.runOnUiThread(new Runnable() {
	        public void run() {	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(EditSports.this,R.style.AlertDialogTheme);
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
