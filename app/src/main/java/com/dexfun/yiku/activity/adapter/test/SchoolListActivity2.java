package com.dexfun.yiku.activity.adapter.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemSchoolAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.SchoolListEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * @author Smile
 */
public class SchoolListActivity2 extends BaseActivity {

//    @BindView(R.id.list)
//    ListView listView;

    ItemSchoolAdapter itemSchoolAdapter;


    private ListView sortListView;
    private SideBar sideBar;

    private SortAdapter adapter;


    /**
     * ����ת����ƴ�����
     */
    private CharacterParser characterParser;
    private List<SortModel> SourceDateList;

    /**
     * ����ƴ��������ListView�����������
     */
    private PinyinComparator pinyinComparator;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("选择院校");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
//        new HttpServiceImpl().getSchoolList(new HttpServiceImpl.OnObjectDataListener<SchoolListEntity>() {
//            @Override
//            public void onData(SchoolListEntity data) {
//                if (data.getStatus() == 200) {
//                    List<SchoolListEntity.DataEntity> data1 = data.getData();
//                    Collections.sort(data1, new LetterComparator());
//                    for (int i = 0; i < data1.size(); i++) {
//                        if (data1.get(i).getSchoolName().contains("#")) {
//                            SchoolListEntity.DataEntity dataEntity = data1.get(i);
//                            data1.remove(dataEntity);
//                            dataEntity.setSchoolName(dataEntity.getSchoolName().substring(1,dataEntity.getSchoolName().length()));
//                            data1.add(0,dataEntity);
//                        }
//                    }
//                    itemSchoolAdapter = new ItemSchoolAdapter(SchoolListActivity2.this, data1);
//                    listView.setAdapter(itemSchoolAdapter);
//
//                } else {
//                    Toast.makeText(SchoolListActivity2.this, data.getMsg(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        initViews();
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SchoolListEntity.DataEntity item = itemSchoolAdapter.getItem(position);
//                int schoolId = item.getSchoolId();
//                String schoolName = item.getSchoolName();
//                setResult(100, new Intent().putExtra("schoolId", schoolId).putExtra("name", schoolName));
//                finish();
//            }
//        });
    }

    private void initViews() {

        //ʵ��������תƴ����
        characterParser = CharacterParser.getInstance();

        pinyinComparator = new PinyinComparator();

        sideBar = (SideBar) findViewById(R.id.sidrbar);

//        sideBar.setTextView(dialog);

        //�����Ҳഥ������
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                //����ĸ�״γ��ֵ�λ��
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }

            }
        });

        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                SortModel item = adapter.getItem(position);
                int schoolId = item.getId();
                String schoolName = item.getName();
                setResult(100, new Intent().putExtra("schoolId", schoolId).putExtra("name", schoolName));
                finish();
            }
        });


        new HttpServiceImpl().getSchoolList(new HttpServiceImpl.OnObjectDataListener<SchoolListEntity>() {
            @Override
            public void onData(SchoolListEntity data) {
                if (data.getStatus() == 200) {
                    List<SchoolListEntity.DataEntity> data1 = data.getData();

//                    for (int i = 0; i < data1.size(); i++) {
//                        SchoolListEntity.DataEntity dataEntity = data1.get(i);
//                        if (dataEntity.getSchoolName().equals("#其它院校")) {
//                            dataEntity.setSchoolName("A其它院校");
//                        }
//                    }

                    SourceDateList = filledData(data1);

                    // ����a-z��������Դ����
                    Collections.sort(SourceDateList, pinyinComparator);
                    adapter = new SortAdapter(SchoolListActivity2.this, SourceDateList);
                    sortListView.setAdapter(adapter);
                } else {
                    Toast.makeText(SchoolListActivity2.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /**
     * ΪListView�������
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(List<SchoolListEntity.DataEntity> date) {
        List<SortModel> mSortList = new ArrayList<SortModel>();

        for (int i = 0; i < date.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.setId(date.get(i).getSchoolId());
            sortModel.setName(date.get(i).getSchoolName());
            String pinyin;
            if (!date.get(i).getSchoolName().contains("重庆")) {
                pinyin = characterParser.getSelling(date.get(i).getSchoolName());
            } else {
                pinyin = characterParser.getSelling("chongqing");
            }

            String sortString = pinyin.substring(0, 1).toUpperCase();

            // ������ʽ���ж�����ĸ�Ƿ���Ӣ����ĸ
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * ����������е�ֵ���������ݲ�����ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<SortModel>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr.toString())) {
                    filterDateList.add(sortModel);
                }
            }
        }

        // ����a-z��������
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
    }
}
