package com.example.myspannable;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView spanText, htmlText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spanText = findViewById(R.id.text1);
        htmlText = findViewById(R.id.text2);

        //제목글자크기, 글자색, 이미지 추가
        String spanString = getResources().getString(R.string.span_string);
        SpannableStringBuilder builder = new SpannableStringBuilder(spanString);
        int start =  spanString.indexOf("소금사막");
        int end = start + "소금사막".length();
        builder.setSpan(new ForegroundColorSpan(0xFFFF0000),0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new RelativeSizeSpan(2.0f), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "제목 클릭", Toast.LENGTH_SHORT).show();
            }
        };
        builder.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        start = spanString.indexOf("img");
        end = start+"img".length();
        Drawable dr= ResourcesCompat.getDrawable(getResources(), R.drawable.img01, null);
        dr.setBounds(0,0,dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
        builder.setSpan(new ImageSpan(dr), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanText.setText(builder);
        spanText.setMovementMethod(new LinkMovementMethod());



        String html = getResources().getString(R.string.html_string);
        htmlText.setText(Html.fromHtml(html, new MyImageGetter(), null));
        htmlText.setMovementMethod(new LinkMovementMethod());

    }

    class MyImageGetter implements Html.ImageGetter
    {
        @Override
        public Drawable getDrawable(String source)
        {
            if(source.equals("img02"))
            {
                Drawable drawable=  ResourcesCompat.getDrawable(getResources(), R.drawable.img02, null);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }
            return null;
        }
    }


}
