package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemSchoolAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.BrandAllListEntity;
import com.dexfun.yiku.entity.SchoolListEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * @author Smile
 */
public class SchoolListActivity extends BaseActivity {

    @BindView(R.id.list)
    ListView listView;

    ItemSchoolAdapter itemSchoolAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_school_list;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("选择院校");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getSchoolList(new HttpServiceImpl.OnObjectDataListener<SchoolListEntity>() {
            @Override
            public void onData(SchoolListEntity data) {
                if (data.getStatus() == 200) {
                    List<SchoolListEntity.DataEntity> data1 = data.getData();
                    Collections.sort(data1, new LetterComparator());
                    for (int i = 0; i < data1.size(); i++) {
                        if (data1.get(i).getSchoolName().contains("#")) {
                            SchoolListEntity.DataEntity dataEntity = data1.get(i);
                            data1.remove(dataEntity);
                            dataEntity.setSchoolName(dataEntity.getSchoolName().substring(1,dataEntity.getSchoolName().length()));
                            data1.add(0,dataEntity);
                        }
                    }
                    itemSchoolAdapter = new ItemSchoolAdapter(SchoolListActivity.this, data1);
                    listView.setAdapter(itemSchoolAdapter);

                } else {
                    Toast.makeText(SchoolListActivity.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SchoolListEntity.DataEntity item = itemSchoolAdapter.getItem(position);
                int schoolId = item.getSchoolId();
                String schoolName = item.getSchoolName();
                setResult(100, new Intent().putExtra("schoolId", schoolId).putExtra("name", schoolName));
                finish();
            }
        });
    }

    public class LetterComparator implements Comparator<SchoolListEntity.DataEntity> {

        @Override
        public int compare(SchoolListEntity.DataEntity l, SchoolListEntity.DataEntity r) {
            if (l == null || r == null) {
                return 0;
            }

            String lhsSortLetters = l.getSchoolName().substring(0, 1).toUpperCase();
            String rhsSortLetters = r.getSchoolName().substring(0, 1).toUpperCase();
            return rhsSortLetters.compareTo(lhsSortLetters);
        }
    }
}
