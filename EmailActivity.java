package com.ice_messenger.app;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EmailActivity extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.email);

      Button startBtn = (Button) findViewById(R.id.sEmail);
      startBtn.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
            sendEmail();
         }
      });
   }
   protected void sendEmail() {
      Log.i("Send email", "");
      String[] TO = {""};
      String[] CC = {""};
      Intent emailIntent = new Intent(Intent.ACTION_SEND);
      
      emailIntent.setData(Uri.parse("mailto:"));
      emailIntent.setType("text/plain");
      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
      emailIntent.putExtra(Intent.EXTRA_CC, CC);
      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
      emailIntent.putExtra(Intent.EXTRA_TEXT, "Type message here");
      
      try {
         startActivity(Intent.createChooser(emailIntent, "Send"));
         finish();
         Log.i("Finished sending.", "");
      }
      catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(EmailActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
      }
   }
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}