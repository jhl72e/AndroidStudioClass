package com.example.webtest;

import android.content.DialogInterface;
import android.os.Debug;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.loadButton);
        editText = findViewById(R.id.urlInput);
        webView = findViewById(R.id.webView);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("file:///android_asset/www/sample.html");

        webView.addJavascriptInterface(new MyJavaScript(), "sample");
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                webView.loadUrl(editText.getText().toString());
            }
        });
        //브라우저 이벤트 처리(alert, confirm)
        webView.setWebChromeClient(new MyChromeClient());
    }

    class MyJavaScript{
        @JavascriptInterface
        public void clickOnFace(){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    button.setText("클릭후열기");
                    webView.loadUrl("javascript:changeFace()");
                }
            });

        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }

    class MyChromeClient extends WebChromeClient
    {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("알림");
            builder.setMessage(message);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.confirm();
                }
            });
            builder.create();
            builder.show();

            return true;
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            result.confirm();
            return true;
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
