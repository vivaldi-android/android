package com.wealth.freedom.newwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wealth.freedom.adapter.RecyclerAdapter;
import com.wealth.freedom.casualname.R;
import com.wealth.freedom.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/11/22 0022
 * Describe:
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private List<String>mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        init();
        initEvent();
    }

    private void init() {
        LinearLayoutManager linear = new LinearLayoutManager(this);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(linear);
        getData();
        mAdapter = new RecyclerAdapter(this,mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mAdapter.setItemClickListenenr(new RecyclerAdapter.OnItemClickListenenr() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.showShort(RecyclerViewActivity.this,mList.get(position)+position);
            }
        });
    }

    private void getData() {
        mList = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            mList.add("终究不过一场繁华");
        }
    }


}
