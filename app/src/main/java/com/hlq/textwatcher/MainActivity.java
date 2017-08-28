package com.hlq.textwatcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.hlq.textwatcher.listener.TextWatcherListener;
import com.hlq.textwatcher.wight.XEditText;

/**
 * created by HLQ at 2017/1/12
 */
public class MainActivity extends AppCompatActivity {

    private EditText edtPhone, edtIdcard;

    private XEditText xedtIphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtIdcard = (EditText) findViewById(R.id.edt_idcard);

        xedtIphone = (XEditText) findViewById(R.id.xedt_iphone);
        xedtIphone.setPattern(new int[]{3, 4, 4});

        new TextWatcherListener(TextWatcherListener.TEXT_WATCHER_PHONE, edtPhone);

        new TextWatcherListener(TextWatcherListener.TEXT_WATCHER_IDCARD, edtIdcard);

    }


}
