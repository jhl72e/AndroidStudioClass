package com.example.myspannable;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2,text3;

    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        edit1= findViewById(R.id.edit1);
        text3 = findViewById(R.id.text3);

        Spannable spannable = (Spannable)edit1.getText(); // Hello World
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 6,7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new RelativeSizeSpan(2.0f), 6,7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        edit1.setText(spannable);

        SpannableString spannableString = new SpannableString("Click Here for more...");
        spannableString.setSpan(new URLSpan("http://www.sunrint.hs.kr"), 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setText(spannableString);
        text2.setMovementMethod(new LinkMovementMethod());

        edit1.setText(spannable);

        String html = "<br/></br>Click <a href = 'http://www.sunrint.hs.kr'>here</a> for more...";
        text3.setText(Html.fromHtml(html));
        text3.setMovementMethod(new LinkMovementMethod());


    }
}
