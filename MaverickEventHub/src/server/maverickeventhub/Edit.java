package server.maverickeventhub;

import server.maverickeventhub.R;
import android.app.Activity;
import android.app.AlertDialog;
//import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
//import android.content.Intent;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

public class Edit extends Activity {
	
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
		setContentView(R.layout.edit);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		//Define all controls used in the UI
		Button button_concert = (Button) findViewById(R.id.btn_edit_concert);
		Button button_contest = (Button) findViewById(R.id.btn_edit_contest);
		Button button_exhibition = (Button) findViewById(R.id.btn_edit_exhibition);
		Button button_feast = (Button) findViewById(R.id.btn_edit_feast);
		Button button_gaming = (Button) findViewById(R.id.btn_edit_gaming);
		Button button_party = (Button) findViewById(R.id.btn_edit_party);
		Button button_sports = (Button) findViewById(R.id.btn_edit_sports);
		Button button_workshop = (Button) findViewById(R.id.btn_edit_workshop);
		Button button_others = (Button) findViewById(R.id.btn_edit_others);
		Button button_help = (Button) findViewById(R.id.btn_edit_help);
		Button button_close = (Button) findViewById(R.id.btn_edit_close);
		TextView textview_edit = (TextView) findViewById(R.id.tv_edit);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		
		//Set font for all the controls used in the UI to Metro UI font
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
		textview_edit.setTypeface(font);
		
        //Close event
        button_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	finish();
            }
		});
        
      //Click event on concert option
        button_concert.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditConcert.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on contest option
        button_contest.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditContest.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on exhibition option
        button_exhibition.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditExhibition.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on feast option
        button_feast.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditFeast.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on gaming option
        button_gaming.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditGaming.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on others option
        button_others.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditOther.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on party option
        button_party.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditParty.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on sports option
        button_sports.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditSports.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on workshop option
        button_workshop.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Edit.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Edit.this, EditWorkshop.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
        
        //Load help on pressing help
		button_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Edit.this.runOnUiThread(new Runnable() {
    	            public void run() {
    	                AlertDialog.Builder builder = new AlertDialog.Builder(Edit.this,R.style.AlertDialogTheme);
    	                builder.setTitle("Select Event Type");
    	                builder.setMessage("Select the event type from your created events you want to edit.")  
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
        
	}
	
	//Back press event
	public void onBackPressed()
	{
	    finish();
	}
}
