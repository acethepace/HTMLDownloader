package com.mallock.assignment5;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        textView = (TextView) findViewById(R.id.tv);
        new GETData("https://www.iiitd.ac.in/about").execute();
    }

    public class GETData extends GETMethod {
        public GETData(String url) {
            super(url);
        }

        @Override
        public void onPreExecute() {
            progressDialog.show();
            textView.setText("Loading...");
        }

        @Override
        public void onPostExecute(String s) {
            textView.setText(s);
            if(progressDialog.isShowing())
                progressDialog.hide();
        }
    }

}
