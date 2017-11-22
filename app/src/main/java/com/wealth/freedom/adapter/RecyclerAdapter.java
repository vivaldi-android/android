package com.wealth.freedom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.casualname.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mDataList;
    private OnItemClickListenenr mItemClickListenenr;

    public RecyclerAdapter(Context context, List<String> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    public OnItemClickListenenr getItemClickListenenr() {
        return mItemClickListenenr;
    }

    public void setItemClickListenenr(OnItemClickListenenr itemClickListenenr) {
        mItemClickListenenr = itemClickListenenr;
    }

    // 自定义的 ViewHolder，持有每个 Item 的所有 View 控件
    // 必须继承自 RecyclerView.ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txt);
        }
    }

    // 获取Item的数量
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    // 将数据与 View 控件进行绑定
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataList.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListenenr.onItemClick(holder.itemView,position);
            }
        });
    }

    // 创建新 View，被 LayoutManager 所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public interface OnItemClickListenenr{
        void onItemClick(View view,int position);
    }
}