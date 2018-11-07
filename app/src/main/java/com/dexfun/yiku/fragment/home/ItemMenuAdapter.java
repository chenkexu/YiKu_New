package com.dexfun.yiku.fragment.home;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.HomeMenuEntity;

import java.util.List;

/**
 * @author Smile
 */
public class ItemMenuAdapter extends BaseAdapter {

    private List<HomeMenuEntity> objects;

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemMenuAdapter(Context context, List<HomeMenuEntity> homeMenuEntityList) {
        this.objects = homeMenuEntityList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public HomeMenuEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_me_menu, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(HomeMenuEntity object, ViewHolder holder) {
        holder.menuName.setText(object.getTitle());
        holder.menuIcon.setImageResource(object.getResId());
        if (object.getTitle().equals("邀请有奖")){
            holder.menuText.setVisibility(View.VISIBLE);
            holder.menuText.setText("HOT");
        }
    }

    protected class ViewHolder {
        private ImageView menuIcon;
        private TextView menuName;
        private TextView menuText;

        public ViewHolder(View view) {
            menuIcon = view.findViewById(R.id.menu_icon);
            menuName = view.findViewById(R.id.menu_name);
            menuText = view.findViewById(R.id.menu_text);
        }
    }
}
