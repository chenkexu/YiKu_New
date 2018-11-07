package com.dexfun.yiku.service.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.dexfun.yiku.BuildConfig;
import com.dexfun.yiku.Constant;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.entity.AccountPEntity;
import com.dexfun.yiku.entity.AddAddressEntity;
import com.dexfun.yiku.entity.AddCartEntity;
import com.dexfun.yiku.entity.AddToCartDOTO;
import com.dexfun.yiku.entity.AllAddressEntity;
import com.dexfun.yiku.entity.ArticlesHomePageEntity;
import com.dexfun.yiku.entity.ArticlesListEntity;
import com.dexfun.yiku.entity.AttentionListEntity;
import com.dexfun.yiku.entity.BrandAllListEntity;
import com.dexfun.yiku.entity.BrandCategoryEntity;
import com.dexfun.yiku.entity.BrandEntity;
import com.dexfun.yiku.entity.CardPriceEntity;
import com.dexfun.yiku.entity.ChooseClothesEntity;
import com.dexfun.yiku.entity.CollectionEntity;
import com.dexfun.yiku.entity.CommunityActivityEntity;
import com.dexfun.yiku.entity.CouponsListEntity;
import com.dexfun.yiku.entity.DefaultAddressEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.DeleteAddressEntity;
import com.dexfun.yiku.entity.DeleteKnapsackDOTO;
import com.dexfun.yiku.entity.DetailEntity;
import com.dexfun.yiku.entity.EditAddressEntity;
import com.dexfun.yiku.entity.FreshClothEntity;
import com.dexfun.yiku.entity.GetProductListEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.HOME_ENTITY;
import com.dexfun.yiku.entity.HomeEntity;
import com.dexfun.yiku.entity.HotWearPageEntity;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.LogBackEntity;
import com.dexfun.yiku.entity.LoginEntity;

import com.dexfun.yiku.entity.LogisticsEntity;
import com.dexfun.yiku.entity.NewOrderEntity;
import com.dexfun.yiku.entity.OrderEntity;
import com.dexfun.yiku.entity.OrnamentEntity;
import com.dexfun.yiku.entity.PayEntity;
import com.dexfun.yiku.entity.PopularityClothingPage;
import com.dexfun.yiku.entity.QueryAddClothingVoucher;
import com.dexfun.yiku.entity.SchoolListEntity;
import com.dexfun.yiku.entity.SelectClothEntity;
import com.dexfun.yiku.entity.SizeTabEntity;
import com.dexfun.yiku.entity.StartEntity;
import com.dexfun.yiku.entity.SuitWithPage;
import com.dexfun.yiku.entity.VersionEntity;
import com.dexfun.yiku.entity.WalletDetailEntity;
import com.dexfun.yiku.entity.WalletEntity;
import com.dexfun.yiku.entity.WeiChatEntity;
import com.dexfun.yiku.service.HttpService;
import com.dexfun.yiku.utils.CKENTITY;
import com.dexfun.yiku.utils.GsonUtil;
import com.dexfun.yiku.utils.UiUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.PostRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Smile on 17/10/31.
 */

public class HttpServiceImpl implements HttpService {

    public interface OnObjectDataListener<T> {
        void onData(T data);

    }

    @Override
    public void doLogin(@NonNull String phone, @NonNull String captcha, @NonNull OnObjectDataListener<LoginEntity> listener) {
        OkGo.get(BuildConfig.API_HOST.concat("/user/signIn"))
                .params("phone", phone)
                .params("captcha", captcha)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LoginEntity fromJson = gson.fromJson(s, LoginEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();

                    }
                });
    }

    public void queryAccount(@NonNull OnObjectDataListener<AccountPEntity> listener) {
        OkGo.get(BuildConfig.API_HOST.concat("/account/queryAccount"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AccountPEntity fromJson = gson.fromJson(s, AccountPEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();

                    }
                });
    }

    public void withdraw(@NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(BuildConfig.API_HOST.concat("/account/withdraw"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();

                    }
                });
    }

    @Override
    public void getVerifyCode(@NonNull String phone, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/encrypted/sendSms"))
                .params("phone", phone)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getHomeList(int num, int size, @NonNull OnObjectDataListener<HomeEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/homePage/getHomePage"))
                .params("num", num)
                .params("size", size)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        HomeEntity fromJson = gson.fromJson(s, HomeEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        HomeEntity fromJson = gson.fromJson(s, HomeEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        UiUtils.toastError();
                    }
                });
    }

    public void addCommodity(int clothingId, int clothingStockId, @NonNull OnObjectDataListener<AddCartEntity> listener) {
        Map<String, Object> map = new HashMap<>();
        map.put("clothingId", clothingId);
        map.put("clothingStockId", clothingStockId);
        OkGo.post(Constant.URL.API_HOST.concat("/collectionFolder/addCommodity"))
                .upJson(new JSONObject(map))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AddCartEntity fromJson = gson.fromJson(s, AddCartEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        UiUtils.toastError();
                    }
                });
    }


    public void getHomePage(@NonNull OnObjectDataListener<HOME_ENTITY> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/homePage/v1/getHomePage"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        HOME_ENTITY fromJson = gson.fromJson(s, HOME_ENTITY.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        HOME_ENTITY fromJson = gson.fromJson(s, HOME_ENTITY.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getDetail(int clothingId, @NonNull OnObjectDataListener<DetailEntity> listener) {

        OkGo.get(Constant.URL.API_HOST.concat("/product/getClothingDetail"))
                .params("clothing_id", clothingId)
                .params("userId", UserClass.getInstance().getUserid())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DetailEntity fromJson = gson.fromJson(s, DetailEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        DetailEntity fromJson = gson.fromJson(s, DetailEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void getOrnamentInfo(int clothingId, @NonNull OnObjectDataListener<DetailEntity> listener) {

        OkGo.get(Constant.URL.API_HOST.concat("/ornament/getOrnamentInfo"))
                .params("ornamentId", clothingId)
                .params("userId", 0)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DetailEntity fromJson = gson.fromJson(s, DetailEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        DetailEntity fromJson = gson.fromJson(s, DetailEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getShoppingCart(@NonNull OnObjectDataListener<KnapsacEntry> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/shoppingCart/toCart"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        KnapsacEntry fromJson = gson.fromJson(s, KnapsacEntry.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getPay(int payMethod, int payType, @NonNull OnObjectDataListener<PayEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/pay/payment"))
                .params("payMethod", payMethod)
                .params("payType", payType)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        PayEntity fromJson = gson.fromJson(s, PayEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void depositPayment(int payMethod, int payType, @NonNull OnObjectDataListener<PayEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/pay/depositPayment"))
                .params("payMethod", payMethod)
                .params("payType", payType)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        PayEntity fromJson = gson.fromJson(s, PayEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void nonDepositPayment(int payMethod, int payType, @NonNull OnObjectDataListener<PayEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/pay/nonDepositPayment"))
                .params("payMethod", payMethod)
                .params("payType", payType)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        PayEntity fromJson = gson.fromJson(s, PayEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void queryFrequencyCard(@NonNull OnObjectDataListener<CKENTITY> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/frequencyCard/queryFrequencyCard"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        CKENTITY fromJson = gson.fromJson(s, CKENTITY.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void pay(int payMethod, int payType, int deposit, int activity, @NonNull OnObjectDataListener<PayEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/pay/pay"))
                .params("payMethod", payMethod)
                .params("payType", payType)
                .params("deposit", deposit)
                .params("activity", 0)
                .params("couponId", activity)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        PayEntity fromJson = gson.fromJson(s, PayEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getBrandDetail(int brandId, @NonNull OnObjectDataListener<BrandEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/brand/getBrandPage"))
                .params("brandId", brandId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        BrandEntity fromJson = gson.fromJson(s, BrandEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        BrandEntity fromJson = gson.fromJson(s, BrandEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getBrandList(@NonNull OnObjectDataListener<BrandAllListEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/brand/getBrandList"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        BrandAllListEntity fromJson = gson.fromJson(s, BrandAllListEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        BrandAllListEntity fromJson = gson.fromJson(s, BrandAllListEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getBrandPageByCategory(int brandId, int categoryId, @NonNull OnObjectDataListener<BrandCategoryEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/brand/getBrandPageByCategory"))
                .params("brandId", brandId)
                .params("categoryId", categoryId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        BrandCategoryEntity fromJson = gson.fromJson(s, BrandCategoryEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        BrandCategoryEntity fromJson = gson.fromJson(s, BrandCategoryEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void addClothingToCart(int clothingId, int clothingStckType, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/shoppingCart/addClothingToCart"))
                .params("clothingId", clothingId)
                .params("clothingStckId", clothingStckType)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void batchAddition(List<AddToCartDOTO> addToCartDOTOS, @NonNull OnObjectDataListener<AddCartEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/shoppingCart/batchAddition"))
                .upJson(GsonUtil.create().toJson(addToCartDOTOS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AddCartEntity fromJson = gson.fromJson(s, AddCartEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void selectClothPage(int num, int size, @NonNull OnObjectDataListener<SelectClothEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/product/selectClothPage"))
                .params("num", num)
                .params("size", size)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        SelectClothEntity fromJson = gson.fromJson(s, SelectClothEntity.class);
                        listener.onData(fromJson);
                    }
//
//                    @Override
//                    public void onCacheSuccess(String s, Call call) {
//                        Gson gson = GsonUtil.create();
//                        SelectClothEntity fromJson = gson.fromJson(s, SelectClothEntity.class);
//                        listener.onData(fromJson);
//                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void selectClothBySortIdAndTypeId(int clothingTypeId, int clothingSortId, @NonNull OnObjectDataListener<GetProductListEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/product/selectClothBySortIdAndTypeId"))
                .params("clothingTypeId", clothingTypeId)
                .params("clothingSortId", clothingSortId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        GetProductListEntity fromJson = gson.fromJson(s, GetProductListEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        GetProductListEntity fromJson = gson.fromJson(s, GetProductListEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getUserInfo(@NonNull OnObjectDataListener<GetUserInfoEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/user/getUserInfo"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        GetUserInfoEntity fromJson = gson.fromJson(s, GetUserInfoEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        GetUserInfoEntity fromJson = gson.fromJson(s, GetUserInfoEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void queryOrder(int orderStatus, @NonNull OnObjectDataListener<OrderEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/order/queryOrder"))
                .params("orderStatus", orderStatus)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        OrderEntity fromJson = gson.fromJson(s, OrderEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        OrderEntity fromJson = gson.fromJson(s, OrderEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void deleteClothingToCart(int shoppingCartId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/shoppingCart/deleteClothingToCart"))
                .params("shoppingCartId", shoppingCartId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        OrderEntity fromJson = gson.fromJson(s, OrderEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void deleteCollectionByClothingId(int clothingId, @NonNull OnObjectDataListener<AddCartEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/collectionFolder/deleteCollectionByClothingId"))
                .params("clothingId", clothingId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AddCartEntity fromJson = gson.fromJson(s, AddCartEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void getCollectionFolder(@NonNull OnObjectDataListener<CollectionEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/collectionFolder/getCollectionFolder"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        CollectionEntity fromJson = gson.fromJson(s, CollectionEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void addAddress(HashMap<String, Object> map, @NonNull OnObjectDataListener<AddAddressEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/address/newAddress"))
                .upJson(new JSONObject(map).toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AddAddressEntity fromJson = gson.fromJson(s, AddAddressEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void deleteAddress(int addressId, @NonNull OnObjectDataListener<DeleteAddressEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/address/deleteAddress"))
                .params("addressId", addressId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DeleteAddressEntity fromJson = gson.fromJson(s, DeleteAddressEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getAllAddress(@NonNull OnObjectDataListener<AllAddressEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/address/queryAddress"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AllAddressEntity fromJson = gson.fromJson(s, AllAddressEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void editAddress(int id, HashMap<String, Object> map, @NonNull OnObjectDataListener<EditAddressEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/address/updateAddress?addressId=" + id))
                .upJson(new JSONObject(map).toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        EditAddressEntity fromJson = gson.fromJson(s, EditAddressEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getWallet(@NonNull OnObjectDataListener<WalletEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/membershipCard/toWallet"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        WalletEntity fromJson = gson.fromJson(s, WalletEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getTransactionDetails(@NonNull OnObjectDataListener<WalletDetailEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/membershipCard/transactionDetails"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        WalletDetailEntity fromJson = gson.fromJson(s, WalletDetailEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getRefundApply(@NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/pay/refundApply"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setUploadPushId(String pushId) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/uploadPushId"))
                .params("pushId", pushId)
//                .params("channel", 3)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void createOrder(HashMap<String, Object> map, @NonNull OnObjectDataListener<NewOrderEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/order/createOrder"))
                .upJson(new JSONObject(map).toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        NewOrderEntity fromJson = gson.fromJson(s, NewOrderEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setUploadFile(File file) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/upload"))
                .params("file", file)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setUpdateOrder(int orderId, int orderStatus, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/order/updateOrder"))
                .params("orderId", orderId)
                .params("orderStatus", orderStatus)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }


    @Override
    public void getDefaultAddress(@NonNull OnObjectDataListener<DefaultAddressEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/address/queryDefaultAddress"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultAddressEntity fromJson = gson.fromJson(s, DefaultAddressEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void creatYTOrder(String orderNo, int addressId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/sendback/makeAppointment"))
                .params("orderNo", orderNo)
                .params("addressId", addressId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getSFTrack(String orderNo, @NonNull OnObjectDataListener<LogisticsEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/sf/orderSFTrackQuery"))
                .params("orderNo", orderNo)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LogisticsEntity fromJson = gson.fromJson(s, LogisticsEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getExpressTrack(String orderNo, @NonNull OnObjectDataListener<LogBackEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/sendback/getExpressTrack"))
                .params("orderNo", orderNo)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LogBackEntity fromJson = gson.fromJson(s, LogBackEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getVerificationCode(String phone, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/encrypted/sendSms"))
                .params("phone", phone)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setPhone(@NonNull String phone, @NonNull String captcha, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/checkCaptcha"))
                .params("phone", phone)
                .params("captcha", captcha)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setPhone2(@NonNull String phone, @NonNull String captcha, @NonNull Integer code, @NonNull OnObjectDataListener<LoginEntity.DSFLOGIN> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/newBindingPhone"))
                .params("phone", phone)
                .params("captcha", captcha)
                .params("schoolId", code)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LoginEntity.DSFLOGIN fromJson = gson.fromJson(s, LoginEntity.DSFLOGIN.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setUserInfo(String nickname, int gender, int schoolId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        Map<String, Object> map = new HashMap<>();
        map.put("gender", gender);
        map.put("nickname", nickname);
//        map.put("schoolId", nickname);
        OkGo.post(Constant.URL.API_HOST.concat("/user/updateInfo"))
                .upJson(new JSONObject(map).toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void settingDefaultAddress(int addressId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/address/settingDefaultAddress"))
                .params("addressId", addressId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getCardPrice(@NonNull OnObjectDataListener<CardPriceEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/membershipCard/cardPrice"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        CardPriceEntity fromJson = gson.fromJson(s, CardPriceEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getFreshClothList(int page, int size, int sytleId, int typeId, int sortId, int brandId, @NonNull OnObjectDataListener<FreshClothEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/product/getFreshClothList"))
                .params("page", page)
                .params("styleId", sytleId)
                .params("size", size)
                .params("typeId", typeId)
                .params("sortId", sortId)
                .params("brandId", brandId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        FreshClothEntity fromJson = gson.fromJson(s, FreshClothEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void shareInfo(@NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/shareInfo"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getYTTrackResult(String orderId, @NonNull OnObjectDataListener<Boolean> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/sendback/getTrackResult"))
                .params("orderId", orderId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        JsonObject fromJson = gson.fromJson(s, JsonObject.class);
                        if (fromJson.get("status").getAsInt() == 200) {
                            listener.onData(fromJson.get("data").getAsString().equals("该订单已经预约归还"));
                        }

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void checkTheLatestVersion(@NonNull OnObjectDataListener<VersionEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/user/checkTheLatestVersion"))
                .params("appVersion", 2)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        VersionEntity fromJson = gson.fromJson(s, VersionEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getAccessToken(String code, @NonNull OnObjectDataListener<WeiChatEntity> listener) {
        OkGo.get("https://api.weixin.qq.com/sns/oauth2/access_token")
                .params("appid", Constant.LocalKey.APP_ID)
                .params("secret", "51a5ffb7b547d3cb3f1a0d4ecf366dfa")
                .params("code", code)
                .params("grant_type", "authorization_code")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        WeiChatEntity fromJson = gson.fromJson(s, WeiChatEntity.class);
                        if (s.contains("errcode")) {
                            fromJson.setStatus(400);
                        } else {
                            fromJson.setStatus(200);
                        }
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getWeiChatInfo(String accessToken, @NonNull OnObjectDataListener<String> listener) {
        OkGo.get("https://api.weixin.qq.com/sns/userinfo")
                .params("openID", Constant.LocalKey.APP_ID)
                .params("access_token", accessToken)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        listener.onData(s);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void clipCoupons(int id, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/coupon/clipCoupons"))
                .params("couponId", id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);


                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getStartImg(@NonNull OnObjectDataListener<StartEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/start/getStartImg"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        StartEntity fromJson = gson.fromJson(s, StartEntity.class);
                        listener.onData(fromJson);


                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void authenticationCode(String code, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/coupon/authenticationCode"))
                .params("code", code)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);


                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void login(String wx, @NonNull OnObjectDataListener<LoginEntity.DSFLOGIN> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/wxLogin"))
                .upJson(wx)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LoginEntity.DSFLOGIN fromJson = gson.fromJson(s, LoginEntity.DSFLOGIN.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void login2(String qq, @NonNull OnObjectDataListener<LoginEntity.DSFLOGIN> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/user/qqLogin"))
                .upJson(qq)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LoginEntity.DSFLOGIN fromJson = gson.fromJson(s, LoginEntity.DSFLOGIN.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void deleteKnapsack(DeleteKnapsackDOTO deleteKnapsackDOTO, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/shoppingCart/batchDeleting"))
                .upJson(GsonUtil.create().toJson(deleteKnapsackDOTO))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void deleteCollection(List<String> list, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        StringBuilder sss = new StringBuilder();
        for (String s : list) {
            sss.append(s).append(",");
        }
        OkGo.get(Constant.URL.API_HOST.concat("/collectionFolder/deleteCollection"))
                .params("collectionList", sss.toString().substring(0, sss.length() - 1))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getArticlesList(Integer page, Integer size, Integer articleStatus, Integer clothingId, Integer userId, Integer activityId, @NonNull OnObjectDataListener<ArticlesListEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/community/ArticlesList"))
                .params("page", page)
                .params("userId", userId)
                .params("size", size)
                .params("articleStatus", articleStatus)
                .params("clothingId", clothingId)
                .params("activityId", activityId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        ArticlesListEntity fromJson = gson.fromJson(s, ArticlesListEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getArticlesHomePage(@NonNull OnObjectDataListener<ArticlesHomePageEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/community/articlesHomePage"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        ArticlesHomePageEntity fromJson = gson.fromJson(s, ArticlesHomePageEntity.class);
                        listener.onData(fromJson);

                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        Gson gson = GsonUtil.create();
                        ArticlesHomePageEntity fromJson = gson.fromJson(s, ArticlesHomePageEntity.class);
                        listener.onData(fromJson);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getArticlesFabulous(String articleId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/community/articlesFabulous"))
                .params("articleId", articleId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getChooseClothes(Integer page, Integer size, @NonNull OnObjectDataListener<ChooseClothesEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/community/chooseClothes"))
                .params("page", page)
                .params("size", size)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        ChooseClothesEntity fromJson = gson.fromJson(s, ChooseClothesEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }


    @Override
    public void setPublishArticles(Integer clothingId, String textContent, List<File> imgList, Integer id, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/community/publishArticles"))
                .params("clothingId", clothingId)
                .params("textContent", textContent)
                .addFileParams("imgList", imgList)
                .params("activityId", id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getUserSizeTable(@NonNull OnObjectDataListener<SizeTabEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/sizeTable/getUserSizeTable"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        SizeTabEntity fromJson = gson.fromJson(s, SizeTabEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void addUserSizeTable(String bust, String theWaist, String hipline, String shoulderWidth, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        Map<String, Integer> map = new HashMap<>();
        if (!TextUtils.isEmpty(bust)) {
            map.put("bust", Integer.valueOf(bust));
        }
        if (!TextUtils.isEmpty(theWaist)) {
            map.put("theWaist", Integer.valueOf(theWaist));
        }
        if (!TextUtils.isEmpty(hipline)) {
            map.put("hipline", Integer.valueOf(hipline));
        }
        if (!TextUtils.isEmpty(shoulderWidth)) {
            map.put("shoulderWidth", Integer.valueOf(shoulderWidth));
        }
        OkGo.post(Constant.URL.API_HOST.concat("/sizeTable/addUserSizeTable"))
                .upJson(new JSONObject(map))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void register(String phone, String captcha, Integer code, @NonNull OnObjectDataListener<LoginEntity> listener) {

        OkGo.post(Constant.URL.API_HOST.concat("/user/schoolRegister"))
                .params("phone", phone)
                .params("captcha", captcha)
                .params("schoolId", code)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        LoginEntity fromJson = gson.fromJson(s, LoginEntity.class);
                        listener.onData(fromJson);

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }


    @Override
    public void getSchoolList(@NonNull OnObjectDataListener<SchoolListEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/school/schoolList"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        SchoolListEntity fromJson = gson.fromJson(s, SchoolListEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void setSchoolList(int schoolId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/school/selectSchool"))
                .params("schoolId", schoolId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    @Override
    public void getOrnamentPage(int page, int size, @NonNull OnObjectDataListener<OrnamentEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/ornament/getOrnamentPage"))
                .params("page", page)
                .params("size", size)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        OrnamentEntity fromJson = gson.fromJson(s, OrnamentEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void getAttentionList(@NonNull OnObjectDataListener<AttentionListEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/community/personal/getAttentionList"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        AttentionListEntity fromJson = gson.fromJson(s, AttentionListEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void setAttention(int articleUserId, @NonNull OnObjectDataListener<DefaultEntity> listener) {
        OkGo.post(Constant.URL.API_HOST.concat("/community/personal/attention?articleUserId=" + articleUserId))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void getCommunityActivity(@NonNull OnObjectDataListener<CommunityActivityEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/community/getCommunityActivity"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        CommunityActivityEntity fromJson = gson.fromJson(s, CommunityActivityEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void getUserCouponsList(@NonNull OnObjectDataListener<CouponsListEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/coupon/getUserCouponsList"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        CouponsListEntity fromJson = gson.fromJson(s, CouponsListEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void hotWearPage(@NonNull OnObjectDataListener<HotWearPageEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/hotWear/hotWearPage"))
                .params("page", "1")
                .params("size", "50")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        HotWearPageEntity fromJson = gson.fromJson(s, HotWearPageEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void suitWithPage(@NonNull OnObjectDataListener<SuitWithPage> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/suitWith/suitWithPage"))
                .params("page", "1")
                .params("size", "50")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        SuitWithPage fromJson = gson.fromJson(s, SuitWithPage.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void popularityClothingPage(String type, @NonNull OnObjectDataListener<PopularityClothingPage> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/popularity/popularityClothingPage"))
                .params("page", "1")
                .params("size", "100")
                .params("type", type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        PopularityClothingPage fromJson = gson.fromJson(s, PopularityClothingPage.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }


    public void queryAddClothingVoucher(OnObjectDataListener<QueryAddClothingVoucher> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/addClothingVoucher/queryAddClothingVoucher"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        QueryAddClothingVoucher fromJson = gson.fromJson(s, QueryAddClothingVoucher.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void usedAddClothingVoucher(int id, OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/addClothingVoucher/usedAddClothingVoucher"))
                .params("addClothingVoucherId", id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

    public void cancelUsedAddClothingVoucher(int id, OnObjectDataListener<DefaultEntity> listener) {
        OkGo.get(Constant.URL.API_HOST.concat("/addClothingVoucher/cancelUsedAddClothingVoucher"))
                .params("addClothingVoucherId", id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = GsonUtil.create();
                        DefaultEntity fromJson = gson.fromJson(s, DefaultEntity.class);
                        listener.onData(fromJson);
                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        UiUtils.toastError();
                    }
                });
    }

}
