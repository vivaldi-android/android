package com.wealth.freedom.newwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wealth.freedom.casualname.R;

/**
 * Author:  captain
 * Time:  2017/11/9 0009
 * Describe:
 */
public class TextInputLayoutActivity extends AppCompatActivity {
    private TextInputLayout usernameWrapper,passwordWrapper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
    }
    public void login(View view){
        String username = usernameWrapper.getEditText().getText().toString();
        String password = passwordWrapper.getEditText().getText().toString();
        if(!username.equals("captain")){
            usernameWrapper.setError("请输入正确的账号");
            return;
        }
        if(password.length()<=3||password.length()>=10){
            passwordWrapper.setError("密码格式不对");
            return;
        }
        usernameWrapper.setErrorEnabled(false);
        passwordWrapper.setErrorEnabled(false);
        Toast.makeText(TextInputLayoutActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();

    }
}
