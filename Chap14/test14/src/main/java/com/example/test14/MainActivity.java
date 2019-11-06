package com.example.test14;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView gwa;
    Button jung, soft, gyeong, multi;
    WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gwa = findViewById(R.id.text1);
        jung = findViewById(R.id.btn1);
        soft = findViewById(R.id.btn2);
        gyeong = findViewById(R.id.btn3);
        multi = findViewById(R.id.btn4);

        webView = findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyChromeClient());
        webView.loadUrl("file:///android_asset/sunrin.html");
        webView.addJavascriptInterface(new MyJavaScript(),"android");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        

       // webView.addJavascriptInterface(new MyJavaScript(), "sample");
        jung.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gwa.setText(jung.getText().toString());
                webView.loadUrl("javascript:change('"+jung.getText().toString()+"')");
            }
        });

        soft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gwa.setText(soft.getText().toString());
                webView.loadUrl("javascript:change('"+soft.getText().toString()+"')");
            }
        });

        gyeong.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gwa.setText(gyeong.getText().toString());
                webView.loadUrl("javascript:change('"+gyeong.getText().toString()+"')");
            }
        });

        multi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gwa.setText(multi.getText().toString());
                webView.loadUrl("javascript:change('"+multi.getText().toString()+"')");
            }
        });
    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }

    class MyJavaScript{
        @JavascriptInterface
        public String getUrl()
        {
            return "http://sunrin.graphics";
        }
    }

    class MyChromeClient extends WebChromeClient
    {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            result.confirm();
            return super.onJsAlert(view, url, message, result);
        }


    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
