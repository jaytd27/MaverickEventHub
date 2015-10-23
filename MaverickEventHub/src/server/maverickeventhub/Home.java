package server.maverickeventhub;

import server.maverickeventhub.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

public class Home extends Activity {
	
	PopupWindow popUp;
    LinearLayout layout;
    TextView tv;
    LayoutParams params;
    LinearLayout mainLayout;
    Button button_settings;
    boolean click = true;
    String username = "";
    Point p;
    
    public static final String PREFS_NAME = "LoginPrefs";
    
    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    username = extras.getString("username");
		}
		
		//Define all controls used in the UI
		Button button_concert = (Button) findViewById(R.id.btn_concert);
		Button button_contest = (Button) findViewById(R.id.btn_contest);
		Button button_exhibition = (Button) findViewById(R.id.btn_exhibition);
		Button button_feast = (Button) findViewById(R.id.btn_feast);
		Button button_gaming = (Button) findViewById(R.id.btn_gaming);
		Button button_party = (Button) findViewById(R.id.btn_party);
		Button button_sports = (Button) findViewById(R.id.btn_sports);
		Button button_workshop = (Button) findViewById(R.id.btn_workshop);
		Button button_others = (Button) findViewById(R.id.btn_others);
		Button button_create = (Button) findViewById(R.id.btn_create);
		Button button_edit = (Button) findViewById(R.id.btn_edit);
		button_settings = (Button) findViewById(R.id.btn_settings);
		TextView textview_events = (TextView) findViewById(R.id.tv_events);
		Typeface font = Typeface.createFromAsset(getAssets(), "segoeui_r.ttf");  
		
		//Set the font for all the controls used in the UI to Metro UI
		button_concert.setTypeface(font);
		button_contest.setTypeface(font);
		button_exhibition.setTypeface(font);
		button_feast.setTypeface(font);
		button_gaming.setTypeface(font);
		button_party.setTypeface(font);
		button_sports.setTypeface(font);
		button_workshop.setTypeface(font);
		button_others.setTypeface(font);
		button_create.setTypeface(font);
		button_edit.setTypeface(font);
		button_settings.setTypeface(font);
		textview_events.setTypeface(font);
		
		//Popup menu controls
		popUp = new PopupWindow(this);
        layout = new LinearLayout(this);
        mainLayout = (LinearLayout) findViewById(R.layout.home);
        tv = new TextView(this);
        
      //Click event on concert option
        button_concert.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewConcert.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on sports option
        button_sports.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewSports.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on contest option
        button_contest.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewContest.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on exhibition option
        button_exhibition.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewExhibition.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on feast option
        button_feast.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewFeast.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on party option
        button_party.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewParty.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on gaming option
        button_gaming.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewGaming.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on others option
        button_others.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewOther.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
      //Click event on workshop option
        button_workshop.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, ViewWorkshop.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
        //Click event on create option
        button_create.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, Create.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
        //Click event on edit option
        button_edit.setOnClickListener(new OnClickListener() {
			 
		     @Override
		     public void onClick(View v) {
		    	 Toast.makeText(Home.this,"Loading...", Toast.LENGTH_SHORT).show();                         
		      	 Intent i = new Intent(Home.this, Edit.class);       	                	 
		          	 i.putExtra("username",username);
		               startActivity(i);
		       
		     }
	   });
        
        //Click event on settings option (Load popup menu)
        button_settings.setOnClickListener(new OnClickListener() {
        	
            @Override
            public void onClick(View arg0) {
              
              //Open popup window
              
              if (p != null)
              showPopup(Home.this, p);
            }
          });
        
	}
	
	//Loading the popup and on focus
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		 
		   int[] location = new int[2];
		   Button button_settings = (Button) findViewById(R.id.btn_settings);
		 
		   // Get the x, y location and store it in the location[] array
		   // location[0] = x, location[1] = y.
		   button_settings.getLocationOnScreen(location);
		 
		   //Initialize the Point with x, and y positions
		   p = new Point();
		   p.x = location[0];
		   p.y = location[1];
		}
	
	//Displaying the popup
	private void showPopup(final Activity context, Point p) {
		float density = context.getResources().getDisplayMetrics().density;
		int popupWidth = Math.round(200 * density);
		int popupHeight = Math.round(240 * density);
		 
		   // Inflate the popup_layout.xml
		   LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
		   LayoutInflater layoutInflater = (LayoutInflater) context
		     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		   View layout = layoutInflater.inflate(R.layout.settings_popup, viewGroup);
		 
		   // Creating the PopupWindow
		   final PopupWindow popup = new PopupWindow(context);
		   popup.setContentView(layout);
		   popup.setWidth(popupWidth);
		   popup.setHeight(popupHeight);
		   popup.setFocusable(true);
		 
		   // Some offset to align the popup top of settings button's position.
		   	
		 
		   // Clear the default translucent background
		   popup.setBackgroundDrawable(new BitmapDrawable());
		 
		   // Displaying the popup at the specified location, + offsets.
		   popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x, p.y - ((int) (240 * density)) - 4);
		 
		   // Getting a reference to Close button, and close the popup when clicked.
		   Button button_close = (Button) layout.findViewById(R.id.btn_close);
		   Button button_logout = (Button) layout.findViewById(R.id.btn_logout);
		   Button button_profile = (Button) layout.findViewById(R.id.btn_profile);
		   button_close.setOnClickListener(new OnClickListener() {
		 
		     @Override
		     public void onClick(View v) {
		       popup.dismiss();
		       
		     }
		   });
		   
		   //Click event of logout option
		   button_logout.setOnClickListener(new OnClickListener() {
				 
			     @Override
			     public void onClick(View v) {
			    	 SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
						SharedPreferences.Editor editor = settings.edit();
						editor.remove("logged");
						editor.commit();
			       finish();
			       
			     }
		   });
		   
		   //Click event of profile option on popup
		   button_profile.setOnClickListener(new OnClickListener() {
				 
			     @Override
			     public void onClick(View v) {
			    	 Toast.makeText(Home.this,"Loading Profile...", Toast.LENGTH_SHORT).show();                         
			    	 Intent i = new Intent(Home.this, Profile.class);       	                	 
	                	 i.putExtra("username",username);
	                     startActivity(i);
			       
			     }
		   });
		   
		   
		   
		   
		   
	}
	
	//Back press event
	int backButtonCount;
	public void onBackPressed()
	{
	    
		if(backButtonCount >= 1)
	    {
	        finish();
	    }
	    else
	    {
	        Toast.makeText(this, "Home Screen. Press back button again to logout.", Toast.LENGTH_SHORT).show();
	        backButtonCount++;
	    }
	}

}
