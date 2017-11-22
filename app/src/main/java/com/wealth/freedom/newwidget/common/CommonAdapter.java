package com.wealth.freedom.newwidget.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/11/22 0022
 * Describe:
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
    }

    /**
     * 业务实现的回调方法
     *
     * @param holder
     * @param t
     */
    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
