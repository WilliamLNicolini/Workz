package com.example.workz;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class GoogleActivity extends AppCompatActivity {
    WebView wbgoogle;
    String url = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        getSupportActionBar().hide();

        wbgoogle = findViewById(R.id.wbgoogle);
        wbgoogle.setWebViewClient(new WebViewClient());
        wbgoogle.loadUrl(url);
        WebSettings websetting = wbgoogle.getSettings();
        websetting.setJavaScriptEnabled(true);


    }

    @Override
    public void onBackPressed() {
       if (wbgoogle.canGoBack()){
           wbgoogle.goBack();
       }
       else {
           super.onBackPressed();
       }
    }


}