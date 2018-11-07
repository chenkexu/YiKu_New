package com.dexfun.yiku.fragment.home;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.BrandDetailActivity;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.PicViewActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.entity.ArticlesHomePageEntity;
import com.dexfun.yiku.entity.ArticlesListEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.fragment.CommunityFragment;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.NineGridlayout;
import com.squareup.picasso.Picasso;

import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class ItemCommunityAdapter extends BaseAdapter {

    private List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    private int type = 0;

    public ItemCommunityAdapter(Context context, List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> objects, int type) {
        this.type = type;
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public ArticlesHomePageEntity.DataEntity.ArticleVOSEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_community, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(ArticlesHomePageEntity.DataEntity.ArticleVOSEntity object, ViewHolder holder) {
        //TODO implement
        Picasso.get().load(object.getHeadPhoto()).into(holder.icon);
        holder.tvName.setText(object.getUserNickName());
        holder.tvContent.setText(object.getArticleContent());
//        List<PhotoInfo> photoInfos = new ArrayList<>();
//        for (String s : object.getArticleImages()) {
//            photoInfos.add(new PhotoInfo(s));
//        }

        if (object.getClothingId() == 0) {
            holder.btnLink.setVisibility(View.GONE);
        } else {
            holder.btnLink.setVisibility(View.VISIBLE);
        }
        Integer userId = Integer.parseInt(UserClass.getInstance().getUserid());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);

        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.image2x.setLayoutManager(mLayoutManager);
        holder.image2x.setHasFixedSize(true);
        holder.image2x.setAdapter(new ItemCommunityXIAdapter(context, object.getArticleImages()));

//        holder.image.setAdapter(new ItemNineAdapter(context, object.getArticleImages()));

        holder.btn_addsub.setImageResource(CommunityFragment.dataData.contains(object.getUserId()) ? R.mipmap.yiguanzhu : R.mipmap.guanzhu);
//        System.out.println(CommunityFragment.dataData);
//        System.out.println(object.getUserId());
        if (type == 0) {
            holder.btn_addsub.setVisibility(View.GONE);
            holder.btnLike.setVisibility(View.GONE);
            holder.btnLink.setVisibility(View.GONE);
        } else {
            holder.tvLike.setText(String.valueOf(object.getFabulous().size()));
            holder.icLike.setImageResource(object.getFabulous().contains(userId) ? R.mipmap.yidianzan : R.mipmap.weidianzan);
            holder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new HttpServiceImpl().getArticlesFabulous(object.getArticleId(), new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                        @Override
                        public void onData(DefaultEntity data) {
                            if (data.getStatus() == 200) {
                                List<Integer> fabulous = object.getFabulous();
                                if (fabulous.contains(userId)) {
                                    fabulous.remove(userId);
                                } else {
                                    fabulous.add(userId);
                                }
                                holder.icLike.setImageResource(object.getFabulous().contains(userId) ? R.mipmap.yidianzan : R.mipmap.weidianzan);
                                holder.tvLike.setText(String.valueOf(object.getFabulous().size()));
                            }
                        }
                    });
                }
            });
            holder.btn_addsub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new HttpServiceImpl().setAttention(object.getUserId(), new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                        @Override
                        public void onData(DefaultEntity data) {
                            if (data.getStatus() == 200) {
                                if (CommunityFragment.dataData.contains(object.getUserId())){
                                    CommunityFragment.dataData.remove(Integer.valueOf(object.getUserId()));
                                    holder.btn_addsub.setImageResource(R.mipmap.guanzhu);
                                }else {
                                    CommunityFragment.dataData.add(object.getUserId());
                                    holder.btn_addsub.setImageResource(R.mipmap.yiguanzhu);
                                }
                                System.out.println(CommunityFragment.dataData);
                            }else {
                                Toast.makeText(context, "请先登录", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            });
        }

        holder.btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class).putExtra("id", object.getClothingId()));
            }
        });

//        holder.image.setOnItemClickListerner(new NineGridlayout.OnItemClickListerner() {
//            @Override
//            public void onItemClick(View view, int position) {
//                context.startActivity(new Intent(context, PicViewActivity.class).putExtra("urls", object.getArticleImages()).putExtra("index", position));
//            }
//        });
        holder.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "敬请期待", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void addData(List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> data) {
        objects.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> data, int page) {
        if (page == 1) {
            objects.clear();
        }
        objects.addAll(data);
        notifyDataSetChanged();
    }

    public void setData(List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> data) {
        objects.clear();
        objects.addAll(data);
        notifyDataSetChanged();
    }

    protected class ViewHolder {
        private CircleImageView icon;
        private TextView tvName;
        private TextView tvContent;
//        private NineGridlayout image;
        private RecyclerView image2x;
        private LinearLayout btnLike;
        private ImageView icLike;
        private TextView tvLike;
        private LinearLayout btnLink;
        private View btn_share;
        private ImageView btn_addsub;

        public ViewHolder(View view) {
            icon = (CircleImageView) view.findViewById(R.id.icon);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvContent = (TextView) view.findViewById(R.id.tv_content);
//            image = (NineGridlayout) view.findViewById(R.id.image);
            image2x = view.findViewById(R.id.image_2x);
            btnLike = (LinearLayout) view.findViewById(R.id.btn_like);
            icLike = (ImageView) view.findViewById(R.id.ic_like);
            tvLike = (TextView) view.findViewById(R.id.tv_like);
            btnLink = (LinearLayout) view.findViewById(R.id.btn_link);
            btn_share = (View) view.findViewById(R.id.btn_share);
            btn_addsub = view.findViewById(R.id.btn_addsub);
        }
    }
}
