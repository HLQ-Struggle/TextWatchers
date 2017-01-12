package com.hlq.textwatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.hlq.textwatcher.listener.TextWatcherListener;

/**
 * created by HLQ at 2017/1/12
 */
public class MainActivity extends AppCompatActivity {

    private EditText edtPhone, edtIdcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtIdcard = (EditText) findViewById(R.id.edt_idcard);

        new TextWatcherListener(TextWatcherListener.TEXT_WATCHER_PHONE, edtPhone);

        new TextWatcherListener(TextWatcherListener.TEXT_WATCHER_PHONE, edtIdcard);

    }
}
