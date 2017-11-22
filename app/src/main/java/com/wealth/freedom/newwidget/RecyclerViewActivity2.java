package com.wealth.freedom.newwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wealth.freedom.casualname.R;
import com.wealth.freedom.newwidget.common.CommonAdapter;
import com.wealth.freedom.newwidget.common.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/11/22 0022
 * Describe:
 */
public class RecyclerViewActivity2 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        init();
    }

    private void init() {
        LinearLayoutManager linear = new LinearLayoutManager(this);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(linear);
        getData();
        mRecyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_1, mList) {
            @Override
            public void convert(ViewHolder holder, String s) {
                TextView txt = holder.getView(R.id.txt);
                txt.setText(s);
            }
        });
    }

    private void getData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add("终究不过一场繁华");
        }
    }
}
