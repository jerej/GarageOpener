package com.stagerigger.garageopener;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.EditText;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    /**
     * Operate Garage Door
     */
    public void operateDoor(View view) {
        // Toggle BG Color Red/Blue
        if(view.isSelected()) {
            view.setSelected(false);
            view.setBackgroundColor(Color.RED);
        } else {
            view.setSelected(true);
            view.setBackgroundColor(Color.BLUE);
        }

    }


    /**
     * Refresh webView
     */
    public void refreshWeb(View view) {
        // Find the inputUrl EditText field
        EditText urlField = (EditText)findViewById(R.id.inputUrl);
        // Log the contents of the inputUrl field
        Log.v("EditText", urlField.getText().toString());


        // Reference the webView box
        WebView myWebView = (WebView) findViewById(R.id.webView);

        // Enable JavaScript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Make webView the "default browser" for this session
        myWebView.setWebViewClient(new WebViewClient());

        // Open the URL from the EditText field in the webView
        myWebView.loadUrl(urlField.getText().toString());
    }
}
