package server.maverickeventhub;

import server.maverickeventhub.R;

import android.app.Activity;
import android.app.AlertDialog;
//import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
//import android.graphics.Rect;
import android.graphics.Typeface;
//import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
//import android.view.Gravity;
//import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
//import android.widget.*;

public class Create extends Activity {
	
	PopupWindow popUp;
    LinearLayout layout;
    TextView tv;
    LayoutParams params;
    LinearLayout mainLayout;
    Button button_settings;
    boolean click = true;
    String username = "";
    Point p;
    
    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		//Define all controls used in the UI
		Button button_concert = (Button) findViewById(R.id.btn_create_concert);
		Button button_contest = (Button) findViewById(R.id.btn_create_contest);
		Button button_exhibition = (Button) findViewById(R.id.btn_create_exhibition);
		Button button_feast = (Button) findViewById(R.id.btn_create_feast);
		Button button_gaming = (Button) findViewById(R.id.btn_create_gaming);
		Button button_party = (Button) findViewById(R.id.btn_create_party);
		Button button_sports = (Button) findViewById(R.id.btn_create_sports);
		Button button_workshop = (Button) findViewById(R.id.btn_create_workshop);
		Button button_others = (Button) findViewById(R.id.btn_create_others);
		Button button_help = (Button) findViewById(R.id.btn_create_help);
		Button button_close = (Button) findViewById(R.id.btn_create_close);
		TextView textview_create = (TextView) findViewById(R.id.tv_create);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		
		//Set the font for all the controls in the UI to Metro UI font
		button_concert.setTypeface(font);
		button_contest.setTypeface(font);
		button_exhibition.setTypeface(font);
		button_feast.setTypeface(font);
		button_gaming.setTypeface(font);
		button_party.setTypeface(font);
		button_sports.setTypeface(font);
		button_workshop.setTypeface(font);
		button_others.setTypeface(font);
		button_help.setTypeface(font);
		button_close.setTypeface(font);
		textview_create.setTypeface(font);
		
		
        //Close event 
        button_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	finish();
            }
		});
        
        //Load help on pressing help
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Create.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(Create.this,R.style.AlertDialogTheme);
    	                builder.setTitle("Select Event Type");
    	                builder.setMessage("Select the event type you want to create.")  
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
		
		//Load concert screen on click
		button_concert.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Concert.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load contest screen on click
		button_contest.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Contest.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load exhibition screen on click
		button_exhibition.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Exhibition.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load feast screen on click
		button_feast.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Feast.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load gaming screen on click
		button_gaming.setOnClickListener(new OnClickListener() {			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Gaming.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load party screen on click
		button_party.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Party.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load sports screen on click
		button_sports.setOnClickListener(new OnClickListener() {			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Sports.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load workshop screen on click
		button_workshop.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Workshop.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
		
		//Load other events screen on click
		button_others.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Create.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Create.this, Others.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
	}
	
}
