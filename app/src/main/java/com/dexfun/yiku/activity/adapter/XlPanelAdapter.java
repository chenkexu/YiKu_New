package com.dexfun.yiku.activity.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.kelin.scrollablepanel.library.PanelAdapter;

import java.util.List;

/**
 * @author Smile
 * @date 18/3/29
 */

public class XlPanelAdapter extends PanelAdapter {
    private List<List<String>> data;

    public XlPanelAdapter(List<List<String>> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return data.get(0).size();
    }

    @Override
    public int getItemViewType(int row, int column) {
        return super.getItemViewType(row, column);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int row, int column) {
        try {
            String title = data.get(row).get(column);
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            if (row == 0) {
                titleViewHolder.titleTextView.setBackgroundResource(R.color.colorAccent);
                titleViewHolder.titleTextView.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                titleViewHolder.titleTextView.setBackgroundResource(R.color.white);
                titleViewHolder.titleTextView.setTextColor(Color.parseColor("#FF1A1A1A"));
            }

            titleViewHolder.titleTextView.setText(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new XlPanelAdapter.TitleViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_title, parent, false));
    }

    private static class TitleViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;

        public TitleViewHolder(View view) {
            super(view);
            this.titleTextView = (TextView) view.findViewById(R.id.title);
        }
    }
}
