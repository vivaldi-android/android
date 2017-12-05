package com.wealth.freedom.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wealth.freedom.casualname.R;

/**
 * @author: vavaldi
 * Time:  2017/12/5
 * Describe:
 */

public class HistoryReportListActivity extends Fragment {
    private String reportType;
    public static String DAY_TYPE = "DAY";
    public static String WEEK_TYPE = "WEEK";
    public static String MONTH_TYPE = "MONTH";
    public static String YEAR_TYPE = "YEAR";
    private View view;

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_history_report_listview,
                container, false);
        Log.e("Fragment", getReportType());
        return view;
    }
}
