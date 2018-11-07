package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.SchoolListEntity;

public class ItemSchoolAdapter extends BaseAdapter {

    private List<SchoolListEntity.DataEntity> objects = new ArrayList<SchoolListEntity.DataEntity>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemSchoolAdapter(Context context, List<SchoolListEntity.DataEntity> data) {
        this.context = context;
        this.objects = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public SchoolListEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_school, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(SchoolListEntity.DataEntity object, ViewHolder holder) {
        String schoolName = object.getSchoolName();
        holder.title.setText(schoolName);
    }

    protected class ViewHolder {
        private TextView title;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
        }
    }
}
