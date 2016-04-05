package com.ice_messenger.app;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSactivity extends Activity {
	
	
	Button b1;
	EditText phoneNo;
	EditText textMsg;
	
	
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.sms);

      Button b1 = (Button) findViewById(R.id.sendsms);
      phoneNo=(EditText)findViewById(R.id.num);
      textMsg=(EditText)findViewById(R.id.msg);
     b1.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
           String phone =phoneNo.getText().toString();
           String msg = textMsg.getText().toString();
           
           
           if (phone.length()>0&&msg.length()>0) {
        	   sendSMS(phone,msg);
        	   Toast.makeText(getBaseContext(), "Message Sent", Toast.LENGTH_SHORT).show();
			
		} else {
			Toast.makeText(getBaseContext(), "Enter both phone number and message", Toast.LENGTH_SHORT).show();

		}
         }
      });
   }

   protected void sendSMS(String phone,String msg) {
	   PendingIntent pi = PendingIntent.getActivity(this, 0,new Intent(this,SMSactivity.class), 0);
	   SmsManager sm =SmsManager.getDefault();
	   sm.sendTextMessage(phone, null, msg, pi, null);
   }
}