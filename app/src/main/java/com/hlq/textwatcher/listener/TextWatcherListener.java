package com.hlq.textwatcher.listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 监听工具类
 *
 * @author HLQ
 * @createtime 2017-1-12
 * @remarks 主要为用户手机号以及身份证号添加空格，增加用户体验友好性
 */
public class TextWatcherListener {

    private EditText editText;

    private TextWatcher watcher;

    // 设置追加内容
    private char addContentType = ' ';
//    private char addContentType='-';

    private static final int TEXT_WATCHER_STATES = 1;
    public static final String TEXT_WATCHER_PHONE = "phoneNum";
    public static final String TEXT_WATCHER_IDCARD = "idCard";

    public TextWatcherListener(String state, EditText editText) {
        this.editText = editText;
        if (TEXT_WATCHER_PHONE.equals(state)) {
            watcher = phoneWatcher;
        }
        if (TEXT_WATCHER_IDCARD.equals(state)) {
            watcher = idCardWatcher;
        }
        editText.addTextChangedListener(watcher);
    }

    TextWatcher phoneWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // 校验EditText内容是否为空
            if (s == null || s.length() == 0) {
                return;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    TextWatcher idCardWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s == null || s.length() == 0)
                return;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i != 6 && i != 15 && s.charAt(i) == ' ') {
                    continue;
                } else {
                    sb.append(s.charAt(i));
                    if ((sb.length() == 7 || sb.length() == 16)
                            && sb.charAt(sb.length() - 1) != ' ') {
                        sb.insert(sb.length() - 1, ' ');
                    }
                }
            }
            if (!sb.toString().equals(s.toString())) {
                int index = start + 1;
                if (sb.charAt(start) == ' ') {
                    if (before == 0) {
                        index++;
                    } else {
                        index--;
                    }
                } else {
                    if (before == 1) {
                        index--;
                    }
                }
                editText.setText(sb.toString());
                editText.setSelection(index);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

}
