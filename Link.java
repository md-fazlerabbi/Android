package com.ice_messenger.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Link extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_btn);
    }

    public void goToSo (View view) {
        goToUrl ( "http://mdfazlerabbi.byethost10.com/my_messenger/");
    }

    public void goToSu (View view) {
        goToUrl ( "http://mdfazlerabbi.byethost10.com/my_messenger/recent_posts.php");
    }
    public void goToWv (View view) {
        goToUrl ( "http://icenstu.edu.bd/");
    }
    public void display (View view) {
    	Intent intent = new Intent(getApplicationContext(), ContactsActivity.class);
        startActivity(intent);
    }
    public void goToPG (View view) {
        goToUrl ( "https://web.facebook.com/groups/826449667391700/");
    }
   
    public void goToSM (View view) {
    	Intent intent = new Intent(getApplicationContext(), SMSactivity.class);
        startActivity(intent);
    }
    public void GotoEmail (View view) {
    	Intent intent = new Intent(getApplicationContext(), EmailActivity.class);
        startActivity(intent);
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    
}