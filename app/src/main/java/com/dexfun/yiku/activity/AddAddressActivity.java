package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.AddAddressEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.AddressPickTask;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

public class AddAddressActivity extends BaseActivity {

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

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_address;

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("添加地址");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
    }


    @OnClick(R.id.addAddress_verify)
    public void onViewClicked() {
        String Consignee = addAddressConsignee.getText().toString().trim();
        String ContactNumber = addAddressContactNumber.getText().toString().trim();
        String Region = addAddressRegion.getText().toString().trim();
        String DetailedAddress = addAddressDetailedAddress.getText().toString().trim();
        if (DetailedAddress.length()<2){
            Toast.makeText(this, "请输入详细地址", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("consignee", Consignee);
        map.put("contactNumber", ContactNumber);
        map.put("region", Region);
        map.put("detailedAddress", DetailedAddress);
        map.put("defaultAddress", swSwitch.isChecked() ? 1 : 0);
        new HttpServiceImpl().addAddress(map, new HttpServiceImpl.OnObjectDataListener<AddAddressEntity>() {
            @Override

            public void onData(AddAddressEntity data) {
                Log.e("address", "onData: " + data.getMsg() + "    " + data.getStatus());
                if (data.getStatus() == 200) {
                    AddAddressActivity.this.finish();
                } else {

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
