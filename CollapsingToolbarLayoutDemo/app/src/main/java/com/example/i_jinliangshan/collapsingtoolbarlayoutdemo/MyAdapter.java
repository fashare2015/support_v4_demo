package com.example.i_jinliangshan.collapsingtoolbarlayoutdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jinliangshan on 2016/6/20.
 */
class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> datas;

    public MyAdapter(Context context, List<String> datas) {
        mContext = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflateItemView(parent));
    }

    private View inflateItemView(ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(R.layout.item_common, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_content)
        TextView mTvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            ButterKnife.bind(this, itemView);
        }

        public void bind(int position) {
            System.out.println("bind: " + position);
            mTvContent.setText(datas.get(position));
        }
    }
}
