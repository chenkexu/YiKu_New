package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.LogisticsEntity;
import com.dexfun.yiku.utils.VectorDrawableUtils;
import com.dexfun.yiku.widget.timelineview.LineType;
import com.dexfun.yiku.widget.timelineview.TimelineView;

import android.widget.TextView;

public class ItemTimelineAdapter extends BaseAdapter {

    private List<LogisticsEntity.DataEntity.BodyEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemTimelineAdapter(Context context, List<LogisticsEntity.DataEntity.BodyEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public LogisticsEntity.DataEntity.BodyEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = layoutInflater.inflate(R.layout.item_timeline, null);
//            convertView.setTag(new ViewHolder(convertView));
//        }
        convertView = layoutInflater.inflate(R.layout.item_timeline, null);
        initializeViews(getItem(position), new ViewHolder(convertView), position);
        return convertView;
    }

    private void initializeViews(LogisticsEntity.DataEntity.BodyEntity object, ViewHolder holder, int position) {
        if (position == 0) {
            holder.timeMarker.initLine(LineType.BEGIN);
            holder.timeMarker.setMarkerColor(context.getResources().getColor(R.color.colorAccent));
        }
        if (position == objects.size() - 1) {
            holder.timeMarker.setEndLine(Color.parseColor("#FFAFAFAF"), LineType.END);
        }

        holder.tvTitle.setText(object.getRemark());
        holder.tvTime.setText(object.getAcceptTime());

    }

    protected class ViewHolder {
        private TimelineView timeMarker;
        private TextView tvTitle;
        private TextView tvTime;

        public ViewHolder(View view) {
            timeMarker = (TimelineView) view.findViewById(R.id.time_marker);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvTime = (TextView) view.findViewById(R.id.tv_time);
        }
    }
}
