package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.AllAddressEntity;
import com.dexfun.yiku.entity.EditAddressEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.AddressPickTask;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

public class EditAddressActivity extends BaseActivity {

    @BindView(R.id.addAddress_consignee)
    EditText addAddressConsignee;
    @BindView(R.id.addAddress_contactNumber)
    EditText addAddressContactNumber;
    @BindView(R.id.addAddress_region)
    TextView addAddressRegion;
    @BindView(R.id.addAddress_detailedAddress)
    EditText addAddressDetailedAddress;

    @BindView(R.id.sw_switch)
    Switch swSwitch;
    private int addressId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_address;

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("编辑地址");
        AllAddressEntity.DataBean bean = (AllAddressEntity.DataBean) getIntent().getSerializableExtra("address");
        if (null != bean) {
            addAddressConsignee.setText(bean.getConsignee());
            addAddressContactNumber.setText(bean.getContactNumber());
            addAddressRegion.setText(bean.getRegion());
            addAddressDetailedAddress.setText(bean.getDetailedAddress());
            addressId = bean.getAddressId();
            int defaultAddress = bean.getDefaultAddress();
            swSwitch.setChecked(defaultAddress == 1);
        }
    }

    @Override
    public void getData(Bundle savedInstanceState) {
    }


    @OnClick(R.id.addAddress_verify)
    public void onViewClicked() {
        String Consignee = addAddressConsignee.getText().toString().trim();
        String ContactNumber = addAddressContactNumber.getText().toString().trim();
        String Region = addAddressRegion.getText().toString().trim();
        String DetailedAddress =  addAddressDetailedAddress.getText().toString().trim();
        HashMap<String, Object> map = new HashMap<>();
        map.put("consignee", Consignee);
        map.put("contactNumber", ContactNumber);
        map.put("region", Region);
        map.put("detailedAddress", DetailedAddress);
        map.put("defaultAddress", swSwitch.isChecked() ? 1 : 0);
        //TODO 调用编辑网络请求
        new HttpServiceImpl().editAddress(addressId, map, new HttpServiceImpl.OnObjectDataListener<EditAddressEntity>() {
            @Override
            public void onData(EditAddressEntity data) {
                if (data.getStatus() == 200) {
                    EditAddressActivity.this.finish();
                } else {
                    Toast.makeText(EditAddressActivity.this, "error" + data.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @OnClick(R.id.addAddress_region)
    void addAddress_region() {
        AddressPickTask addressPickTask = new AddressPickTask(this);
        addressPickTask.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {

            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                if (county == null) {
                    addAddressRegion.setText(province.getAreaName() + "-" + city.getAreaName());
                } else {
                    addAddressRegion.setText(province.getAreaName() + "-" + city.getAreaName() + "-" + county.getAreaName());
                }
            }
        });
        addressPickTask.execute();
    }
}
