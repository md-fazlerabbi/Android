package com.ice_messenger.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		
		
		
		
		
		 Thread timer = new Thread()
		{
			
				public void run() {
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();// TODO: handle exception
					}
					finally
					{
					 	Intent intent=new Intent("com.ice_messenger.app.Link");
						startActivity(intent);
					}
				}
			
		};
		timer.start();
	}
	

	//phone state
			class TeleListener extends PhoneStateListener 
			{
		      @Override
			public void onCallStateChanged(int state,String incomingNumber)
		      {
		        if(state==TelephonyManager.CALL_STATE_RINGING)
	               {
		        	
		        	System.exit(0);  
	               }
		       } 
		      
		    }
			

	
	
}
