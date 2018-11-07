package com.dexfun.yiku.service;

import android.support.annotation.NonNull;

import com.dexfun.yiku.entity.AddAddressEntity;
import com.dexfun.yiku.entity.AllAddressEntity;
import com.dexfun.yiku.entity.ArticlesHomePageEntity;
import com.dexfun.yiku.entity.ArticlesListEntity;
import com.dexfun.yiku.entity.BrandAllListEntity;
import com.dexfun.yiku.entity.BrandCategoryEntity;
import com.dexfun.yiku.entity.BrandEntity;
import com.dexfun.yiku.entity.CardPriceEntity;
import com.dexfun.yiku.entity.ChooseClothesEntity;
import com.dexfun.yiku.entity.DefaultAddressEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.DeleteAddressEntity;
import com.dexfun.yiku.entity.DeleteKnapsackDOTO;
import com.dexfun.yiku.entity.DetailEntity;
import com.dexfun.yiku.entity.EditAddressEntity;
import com.dexfun.yiku.entity.FreshClothEntity;
import com.dexfun.yiku.entity.GetProductListEntity;
import com.dexfun.yiku.entity.HomeEntity;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.LogBackEntity;
import com.dexfun.yiku.entity.LoginEntity;
import com.dexfun.yiku.entity.LogisticsEntity;
import com.dexfun.yiku.entity.NewOrderEntity;
import com.dexfun.yiku.entity.OrderEntity;
import com.dexfun.yiku.entity.OrnamentEntity;
import com.dexfun.yiku.entity.PayEntity;
import com.dexfun.yiku.entity.SchoolListEntity;
import com.dexfun.yiku.entity.SelectClothEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.SizeTabEntity;
import com.dexfun.yiku.entity.StartEntity;
import com.dexfun.yiku.entity.VersionEntity;
import com.dexfun.yiku.entity.WalletDetailEntity;
import com.dexfun.yiku.entity.WalletEntity;
import com.dexfun.yiku.entity.WeiChatEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import java.io.File;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Smile on 17/10/31.
 */

public interface HttpService {



    void doLogin(@NonNull String phone, @NonNull String captcha, @NonNull HttpServiceImpl.OnObjectDataListener<LoginEntity> listener);

    void getVerifyCode(@NonNull String phone, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getHomeList(int num, int size, @NonNull HttpServiceImpl.OnObjectDataListener<HomeEntity> listener);

    void getShoppingCart(@NonNull HttpServiceImpl.OnObjectDataListener<KnapsacEntry> listener);

    void getDetail(int clothingId, @NonNull HttpServiceImpl.OnObjectDataListener<DetailEntity> listener);

    void getPay(int payMethod, int payType, @NonNull HttpServiceImpl.OnObjectDataListener<PayEntity> listener);

    void getBrandDetail(int brandId, @NonNull HttpServiceImpl.OnObjectDataListener<BrandEntity> listener);

//    void getBrandList(@NonNull HttpServiceImpl.OnObjectDataListener<GetProductListEntity> listener);

    void getBrandList(@NonNull HttpServiceImpl.OnObjectDataListener<BrandAllListEntity> listener);

    void getBrandPageByCategory(int brandId, int categoryId, @NonNull HttpServiceImpl.OnObjectDataListener<BrandCategoryEntity> listener);

    void addClothingToCart(int clothingId, int clothingStckType, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void selectClothPage(int num, int size, @NonNull HttpServiceImpl.OnObjectDataListener<SelectClothEntity> listener);

    void selectClothBySortIdAndTypeId(int clothingTypeId, int clothingSortId, @NonNull HttpServiceImpl.OnObjectDataListener<GetProductListEntity> listener);

    void getUserInfo(@NonNull HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity> listener);

    void queryOrder(int orderStatus, @NonNull HttpServiceImpl.OnObjectDataListener<OrderEntity> listener);

    void deleteClothingToCart(int shoppingCartId, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

     void addAddress(HashMap<String,Object> map, @NonNull HttpServiceImpl.OnObjectDataListener<AddAddressEntity> listener);

     void deleteAddress(int addressId, @NonNull HttpServiceImpl.OnObjectDataListener<DeleteAddressEntity> listener);

     void getAllAddress(@NonNull HttpServiceImpl.OnObjectDataListener<AllAddressEntity> listener);

     void editAddress(int id,HashMap<String,Object> map,@NonNull HttpServiceImpl.OnObjectDataListener<EditAddressEntity> listener);

    void getWallet(@NonNull HttpServiceImpl.OnObjectDataListener<WalletEntity> listener);

    void getTransactionDetails(@NonNull HttpServiceImpl.OnObjectDataListener<WalletDetailEntity> listener);

    void getRefundApply(@NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void setUploadPushId(String pushId);

    void setUploadFile(File file);

    void setUpdateOrder(int orderId, int orderStatus, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void createOrder(HashMap<String,Object> map,@NonNull HttpServiceImpl.OnObjectDataListener<NewOrderEntity> listener);

    void getDefaultAddress(@NonNull HttpServiceImpl.OnObjectDataListener<DefaultAddressEntity> listener);

//    void creatYTOrder(String orderNo, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void creatYTOrder(String orderNo, int addressId,  @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getSFTrack(String orderNo, @NonNull HttpServiceImpl.OnObjectDataListener<LogisticsEntity> listener);

    void getExpressTrack(String orderNo, @NonNull HttpServiceImpl.OnObjectDataListener<LogBackEntity> listener);

    void getVerificationCode(String phone, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void setPhone(@NonNull String phone, @NonNull String captcha, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void setPhone2(@NonNull String phone, @NonNull String captcha,  @NonNull Integer code,@NonNull HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN> listener);

    void setUserInfo(String nickname, int gender,int schoolId, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void settingDefaultAddress(int addressId, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getCardPrice(@NonNull HttpServiceImpl.OnObjectDataListener<CardPriceEntity> listener);

    void getFreshClothList(int page, int size, int sytleId, int typeId, int sortId, int brandId, @NonNull HttpServiceImpl.OnObjectDataListener<FreshClothEntity> listener);

    void shareInfo(@NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getYTTrackResult(String orderId, @NonNull HttpServiceImpl.OnObjectDataListener<Boolean> listener);

    void checkTheLatestVersion(@NonNull HttpServiceImpl.OnObjectDataListener<VersionEntity> listener);

    void getAccessToken(String code, @NonNull HttpServiceImpl.OnObjectDataListener<WeiChatEntity> listener);

    void getWeiChatInfo(String accessToken, @NonNull HttpServiceImpl.OnObjectDataListener<String> listener);

    void clipCoupons(int id, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getStartImg(@NonNull HttpServiceImpl.OnObjectDataListener<StartEntity> listener);

    void authenticationCode(String code, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void login(String wx, @NonNull HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN> listener);

    void login2(String qq, @NonNull HttpServiceImpl.OnObjectDataListener<LoginEntity.DSFLOGIN> listener);

    void deleteKnapsack(DeleteKnapsackDOTO deleteKnapsackDOTO, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getArticlesList(Integer page, Integer size, Integer articleStatus, Integer clothingId, Integer userId,Integer activityId, @NonNull HttpServiceImpl.OnObjectDataListener<ArticlesListEntity> listener);

    void getArticlesHomePage(@NonNull HttpServiceImpl.OnObjectDataListener<ArticlesHomePageEntity> listener);

    void getArticlesFabulous(String articleId, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getChooseClothes(Integer page, Integer size, @NonNull HttpServiceImpl.OnObjectDataListener<ChooseClothesEntity> listener);

    void setPublishArticles(Integer clothingId, String textContent, List<File> imgList,Integer id, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getUserSizeTable(@NonNull HttpServiceImpl.OnObjectDataListener<SizeTabEntity> listener);

    void addUserSizeTable(String bust, String theWaist, String hipline, String shoulderWidth, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void register(String phone, String captcha, Integer code, @NonNull HttpServiceImpl.OnObjectDataListener<LoginEntity> listener);

    void getSchoolList(@NonNull HttpServiceImpl.OnObjectDataListener<SchoolListEntity> listener);

    void setSchoolList(int schoolId, @NonNull HttpServiceImpl.OnObjectDataListener<DefaultEntity> listener);

    void getOrnamentPage(int page, int size, @NonNull HttpServiceImpl.OnObjectDataListener<OrnamentEntity> listener);


}
