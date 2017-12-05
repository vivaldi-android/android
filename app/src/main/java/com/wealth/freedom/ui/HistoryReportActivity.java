package com.wealth.freedom.ui;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.casualname.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: vavaldi
 * Time:  2017/12/5
 * Describe:
 */

public class HistoryReportActivity extends FragmentActivity{
    private ViewPager layoutPager;
    private int currIndex = 0;// 当前页卡编号
    private ImageView imgLine;// 页卡标题动画图片
    private TextView txtDay;
    private TextView txtWeek;
    private TextView txtMonth;
    private TextView txtYear;
    private static final int pageSize = 4;
    private int bmpW;// 动画图片宽度
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mDatas;
    private int offset = 0;// 动画图片偏移量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_history_report);
        layoutPager = (ViewPager) findViewById(R.id.viewPager_history_report);
        txtDay = (TextView) findViewById(R.id.txtDay_history_report);
        txtWeek = (TextView) findViewById(R.id.txtWeek_history_report);
        txtMonth = (TextView) findViewById(R.id.txtMonth_history_report);
        txtYear = (TextView) findViewById(R.id.txtYear_history_report);
        imgLine = (ImageView) findViewById(R.id.imgNavLine_history_report);
        txtDay.setSelected(true);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / pageSize) / 2;// 计算偏移量--(屏幕宽度/页卡总数-图片实际宽度)/2
        // = 偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imgLine.setImageMatrix(matrix);
        MyOnClickListener myClickListener = new MyOnClickListener();
        txtDay.setOnClickListener(myClickListener);
        txtWeek.setOnClickListener(myClickListener);
        txtMonth.setOnClickListener(myClickListener);
        txtYear.setOnClickListener(myClickListener);
        mDatas = new ArrayList<Fragment>();
        HistoryReportListActivity dayFragment = new HistoryReportListActivity();
        HistoryReportListActivity weekFragment = new HistoryReportListActivity();
        HistoryReportListActivity monthFragment = new HistoryReportListActivity();
        HistoryReportListActivity yearFragment = new HistoryReportListActivity();
        dayFragment.setReportType(HistoryReportListActivity.DAY_TYPE);
        weekFragment.setReportType(HistoryReportListActivity.WEEK_TYPE);
        monthFragment.setReportType(HistoryReportListActivity.MONTH_TYPE);
        yearFragment.setReportType(HistoryReportListActivity.YEAR_TYPE);
        mDatas.add(dayFragment);
        mDatas.add(weekFragment);
        mDatas.add(monthFragment);
        mDatas.add(yearFragment);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mDatas.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mDatas.get(arg0);
            }

        };
        layoutPager.setAdapter(mAdapter);
        layoutPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int one = offset * 2 + bmpW;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {
                Animation animation = new TranslateAnimation(one * currIndex,
                        one * position, 0, 0);// 显然这个比较简洁，只有一行代码。
                currIndex = position;
                animation.setFillAfter(true);// True:图片停在动画结束位置
                animation.setDuration(300);
                imgLine.startAnimation(animation);
                txtDay.setSelected(false);
                txtWeek.setSelected(false);
                txtMonth.setSelected(false);
                txtYear.setSelected(false);
                switch (position) {
                    case 0:
                        txtDay.setSelected(true);
                        mDatas.get(position).onResume();
                        break;
                    case 1:
                        txtWeek.setSelected(true);
                        mDatas.get(position).onResume();
                        break;
                    case 2:
                        txtMonth.setSelected(true);
                        mDatas.get(position).onResume();
                        break;
                    case 3:
                        txtYear.setSelected(true);
                        mDatas.get(position).onResume();
                        break;
                }
            }
        });
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txtDay.setSelected(false);
            txtWeek.setSelected(false);
            txtMonth.setSelected(false);
            txtYear.setSelected(false);
            if (v.getId() == R.id.txtDay_history_report) {
                txtDay.setSelected(true);
                layoutPager.setCurrentItem(0);
                mDatas.get(0).onResume();
            } else if (v.getId() == R.id.txtWeek_history_report) {
                txtWeek.setSelected(true);
                layoutPager.setCurrentItem(1);
                mDatas.get(1).onResume();
            } else if (v.getId() == R.id.txtMonth_history_report) {
                txtMonth.setSelected(true);
                layoutPager.setCurrentItem(2);
                mDatas.get(2).onResume();
            } else if (v.getId() == R.id.txtYear_history_report) {
                txtYear.setSelected(true);
                layoutPager.setCurrentItem(3);
                mDatas.get(3).onResume();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

}
