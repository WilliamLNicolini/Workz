package com.example.workz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TranslateActivity extends AppCompatActivity {
    WebView webTranslate;
    String url = "https://context.reverso.net/traducao/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        getSupportActionBar().hide();

        webTranslate = findViewById(R.id.wbTranslate);
        webTranslate.setWebViewClient(new WebViewClient());
        webTranslate.loadUrl(url);
        WebSettings websetting = webTranslate.getSettings();
        websetting.setJavaScriptEnabled(true);




    }
    @Override
    public void onBackPressed() {
        if (webTranslate.canGoBack()){
            webTranslate.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}