package com.mix.easycalculator.api;

import com.mix.easycalculator.bean.AccountInfo;
import com.mix.easycalculator.bean.ArticleSubBean;
import com.mix.easycalculator.bean.CalDealBean;
import com.mix.easycalculator.bean.CalInfoBean;
import com.mix.easycalculator.bean.CommentDetailBean;
import com.mix.easycalculator.bean.FanFollow;
import com.mix.easycalculator.bean.FastNewsBean;
import com.mix.easycalculator.bean.GetKeyBean;
import com.mix.easycalculator.bean.LoginBack;
import com.mix.easycalculator.bean.MsgActionBean;
import com.mix.easycalculator.bean.MsgCommentBean;
import com.mix.easycalculator.bean.MsgFansBean;
import com.mix.easycalculator.bean.MsgSysmsgBean;
import com.mix.easycalculator.bean.MsgTopicBean;
import com.mix.easycalculator.bean.OtherFanFollow;
import com.mix.easycalculator.bean.People;
import com.mix.easycalculator.bean.PeopleTopic;
import com.mix.easycalculator.bean.TopicBean;
import com.mix.easycalculator.bean.TopicCommentBean;
import com.mix.easycalculator.bean.VersionInfo;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by huang on 2018/4/16.
 */

public interface ApiService {

    /**
     * 是否需要升级
     */
    @FormUrlEncoded
    @POST("app/version/check")
    Observable<ApiResponse<VersionInfo>> versionCheck(@FieldMap HashMap<String, Object> map);




    //根据币种获取挖矿信息
    @FormUrlEncoded
    @POST("cal/coin/mining/info")
    Observable<ApiResponse<CalInfoBean>> calInfo(@FieldMap HashMap<String, Object> map);

    //处理计算请求
    @FormUrlEncoded
    @POST("cal/coin/mining/deal")
    Observable<ApiResponse<CalDealBean>> calDeal(@FieldMap HashMap<String, Object> map);


    //获取文章列表内容
    @FormUrlEncoded
    @POST("feed/news/article/list")
    Observable<ApiResponse<ArticleSubBean>> fedArticleList(@FieldMap HashMap<String, Object> map);


    //获取快讯列表内容
    @FormUrlEncoded
    @POST("feed/news/fastNews/list")
    Observable<ApiResponse<FastNewsBean>> fedFastNewsList(@FieldMap HashMap<String, Object> map);


    //判断是否收藏
    @FormUrlEncoded
    @POST("feed/article/user/isCollect")
    Observable<ApiResponse<Object>> fedUserIsCollect(@FieldMap HashMap<String, Object> map);

    //收藏文章
    @FormUrlEncoded
    @POST("feed/article/collect")
    Observable<ApiResponse<Object>> fedCollectNews(@FieldMap HashMap<String, Object> map);

    //取消收藏文章
    @FormUrlEncoded
    @POST("feed/article/collect/cancel")
    Observable<ApiResponse<Object>> fedUnCollectNews(@FieldMap HashMap<String, Object> map);


    //话题列表
    @FormUrlEncoded
    @POST("feed/topic/list")
    Observable<ApiResponse<TopicBean>> fedTopicList(@FieldMap HashMap<String, Object> map);


    //话题详情
    @FormUrlEncoded
    @POST("feed/topic/detail")
    Observable<ApiResponse<TopicBean.TopicList>> fedTopicDetail(@FieldMap HashMap<String, Object> map);

    //话题讨论列表
    @FormUrlEncoded
    @POST("feed/topic/discuss/list")
    Observable<ApiResponse<TopicCommentBean>> fedTopicComment(@FieldMap HashMap<String, Object> map);

    //登录
    @FormUrlEncoded
    @POST("user/login")
    Observable<ApiResponse<LoginBack>> login(@FieldMap HashMap<String, Object> map);

    //注册
    @FormUrlEncoded
    @POST("user/reg")
    Observable<ApiResponse<Object>> register(@FieldMap HashMap<String, Object> map);

    //获取邮件验证码
    @FormUrlEncoded
    @POST("auth/code/email/get")
    Observable<ApiResponse<Object>> getEmailCode(@FieldMap HashMap<String, Object> map);

    //获取手机验证码
    @FormUrlEncoded
    @POST("auth/code/mobile/get")
    Observable<ApiResponse<Object>> getMobileCode(@FieldMap HashMap<String, Object> map);

    //忘记密码，修改密码
    @FormUrlEncoded
    @POST("user/password/get/do")
    Observable<ApiResponse<Object>> changePas(@FieldMap HashMap<String, Object> map);



    //对话题进行评论
    @FormUrlEncoded
    @POST("feed/topic/discuss/add")
    Observable<ApiResponse<TopicCommentBean.TopicCommentList>> fedTopicReply(@FieldMap HashMap<String, Object> map);


    //话题讨论详情
    @FormUrlEncoded
    @POST("feed/topic/discuss/detail")
    Observable<ApiResponse<TopicCommentBean.TopicCommentList>> fedTopicDiscussDetail(@FieldMap HashMap<String, Object> map);


    //讨论评论列表
    @FormUrlEncoded
    @POST("feed/topic/discuss/comment/list")
    Observable<ApiResponse<CommentDetailBean>> fedTopicDiscussCommentList(@FieldMap HashMap<String, Object> map);


    //对讨论回复
    @FormUrlEncoded
    @POST("feed/topic/discuss/comment/add")
    Observable<ApiResponse<CommentDetailBean.CommentDetailSub>> fedCommentReply(@FieldMap HashMap<String, Object> map);

    //对讨论的评论回复
    @FormUrlEncoded
    @POST("feed/topic/discuss/comment/add")
    Observable<ApiResponse<CommentDetailBean.CommentDetailSub>> fedCommentSubReply(@FieldMap HashMap<String, Object> map);

   // 获取指定用户用户信息(粉丝数，关注数)
    @FormUrlEncoded
    @POST("user/people/info")
    Observable<ApiResponse<People>> peopleMainPageInfo(@FieldMap HashMap<String, Object> map);



    //他人参与话题列表
    @FormUrlEncoded
    @POST("user/people/topicTake/list")
    Observable<ApiResponse<PeopleTopic>> peoplesTopic(@FieldMap HashMap<String, Object> map);

    //忘记密码，使用邮箱账户找回
    @FormUrlEncoded
    @POST("user/password/email/get")
    Observable<ApiResponse<Object>> getEmailToken(@FieldMap HashMap<String, Object> map);

    //获取用户信息
    @FormUrlEncoded
    @POST("user/info")
    Observable<ApiResponse<AccountInfo>> getMineInfo(@FieldMap HashMap<String, Object> map);

    //更换邮箱，(step1.解绑，获取重新绑定令牌)
    @FormUrlEncoded
    @POST("user/account/email/rebind/token")
    Observable<ApiResponse<Object>> untie(@FieldMap HashMap<String, Object> map);

    //更换邮箱，(step2.重新绑定账户)
    @FormUrlEncoded
    @POST("user/account/email/rebind/do")
    Observable<ApiResponse<Object>> rebind(@FieldMap HashMap<String, Object> map);

    //登录用户修改旧密码
    @FormUrlEncoded
    @POST("user/password/edit")
    Observable<ApiResponse<Object>> editPas(@FieldMap HashMap<String, Object> map);





    //获取粉丝消息
    @FormUrlEncoded
    @POST("message/userFans/list")
    Observable<ApiResponse<MsgFansBean>> msgFans(@FieldMap HashMap<String, Object> map);


    //获取话题消息
    @FormUrlEncoded
    @POST("message/topic/list")
    Observable<ApiResponse<MsgTopicBean>> msgTopic(@FieldMap HashMap<String, Object> map);


    //获取系统消息
    @FormUrlEncoded
    @POST("message/sys/list")
    Observable<ApiResponse<MsgSysmsgBean>> msgSysmsg(@FieldMap HashMap<String, Object> map);


    //获取活动消息
    @FormUrlEncoded
    @POST("message/activity/list")
    Observable<ApiResponse<MsgActionBean>> msgActionmsg(@FieldMap HashMap<String, Object> map);


    //获取评论消息
    @FormUrlEncoded
    @POST("message/newComment/list")
    Observable<ApiResponse<MsgCommentBean>> msgContent(@FieldMap HashMap<String, Object> map);


    // 反馈
    @FormUrlEncoded
    @POST("user/feedback")
    Observable<ApiResponse<Object>> feedback(@FieldMap HashMap<String, Object> map);

    //修改用户头像
    @FormUrlEncoded
    @POST("user/info/nickName/save")
    Observable<ApiResponse<Object>> changeName(@FieldMap HashMap<String, Object> map);

    // 修改用户性别
    @FormUrlEncoded
    @POST("user/info/gender/save")
    Observable<ApiResponse<Object>> setSex(@FieldMap HashMap<String, Object> map);

    //修改用户出生日期
    @FormUrlEncoded
    @POST("user/info/birthDate/save")
    Observable<ApiResponse<Object>> setBirth(@FieldMap HashMap<String, Object> map);


     //获取登录用户信息(粉丝数，关注数)
    @FormUrlEncoded
    @POST("user/info/count")
    Observable<ApiResponse<People>> myInfo(@FieldMap HashMap<String, Object> map);
    //获取登录用户关注话题列表
    @FormUrlEncoded
    @POST("user/topic/follow/list")
    Observable<ApiResponse<TopicBean>> myFollowTopic(@FieldMap HashMap<String, Object> map);
    //获取登录用户参与话题列表
    @FormUrlEncoded
    @POST("user/topicTake/list")
    Observable<ApiResponse<PeopleTopic>> myTakeTopic(@FieldMap HashMap<String, Object> map);
    //关注话题
    @FormUrlEncoded
    @POST("feed/topic/follow")
    Observable<ApiResponse<Object>> followTopic(@FieldMap HashMap<String, Object> map);
    //取消关注话题
    @FormUrlEncoded
    @POST("feed/topic/follow/cancel")
    Observable<ApiResponse<Object>> cancelFollowTopic(@FieldMap HashMap<String, Object> map);
    //关注列表
    @FormUrlEncoded
    @POST("user/follower/list")
    Observable<ApiResponse<FanFollow>> myFollow(@FieldMap HashMap<String, Object> map);
    //粉丝列表
    @FormUrlEncoded
    @POST("user/fans/list")
    Observable<ApiResponse<FanFollow>> myFans(@FieldMap HashMap<String, Object> map);
    //关注他人
    @FormUrlEncoded
    @POST("user/attention/pay")
    Observable<ApiResponse<Object>> doFans(@FieldMap HashMap<String, Object> map);
    //取消关注他人
    @FormUrlEncoded
    @POST("user/attention/cancelPay")
    Observable<ApiResponse<Object>> cancelDoFans(@FieldMap HashMap<String, Object> map);
    //  他人粉丝列表
    @FormUrlEncoded
    @POST("user/people/fans/list")
    Observable<ApiResponse<OtherFanFollow>> peopleFans(@FieldMap HashMap<String, Object> map);
    //  他人关注列表
    @FormUrlEncoded
    @POST("user/people/follower/list")
    Observable<ApiResponse<OtherFanFollow>> peopleFollower(@FieldMap HashMap<String, Object> map);

    //获取七牛云文件上传token
    @FormUrlEncoded
    @POST("config/cloud/file/token/get")
    Observable<ApiResponse<GetKeyBean>> getKey(@FieldMap HashMap<String, Object> map);

    //修改用户头像
    @FormUrlEncoded
    @POST("user/info/headIcon/save")
    Observable<ApiResponse<Object>> changeHead(@FieldMap HashMap<String, Object> map);

    //获取用户收藏
    @FormUrlEncoded
    @POST("user/news/article/collect/list")
    Observable<ApiResponse<ArticleSubBean>> getMyCollect(@FieldMap HashMap<String, Object> map);

   //资讯浏览上报
    @FormUrlEncoded
    @POST("feed/report/article/view")
    Observable<ApiResponse<Object>> reportArticleView(@FieldMap HashMap<String, Object> map);



    //客户端绑定user id和极光推送的reg id
    @FormUrlEncoded
    @POST("push/bind")
    Observable<ApiResponse<Object>> pushBind(@FieldMap HashMap<String, Object> map);


    //客户端解绑user id和极光推送的reg id， 可以在退出登录时调用
    @FormUrlEncoded
    @POST("push/unbind")
    Observable<ApiResponse<Object>> pushunBind(@FieldMap HashMap<String, Object> map);

}
