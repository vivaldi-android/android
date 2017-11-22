package com.wealth.freedom.casualname;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wealth.freedom.newwidget.RecyclerViewActivity;
import com.wealth.freedom.newwidget.TextInputLayoutActivity;

/**
 * @author:  captain
 * Time:  2017/11/9 0009
 * Describe:
 */
public class NewWidgetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_widget);
    }

    public void inputLayout(View view){
        startActivity(new Intent(this, TextInputLayoutActivity.class));
    }

    public void recycler(View view){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
