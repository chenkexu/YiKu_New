package com.dexfun.yiku;

/**
 * Created by Smile on 17/12/8.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;

import com.dexfun.yiku.activity.MessageActivity;
import com.dexfun.yiku.activity.PocketActivity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class DemoIntentService extends GTIntentService {

    public DemoIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String string = new String(msg.getPayload());
        System.out.println(string);
//        try {
//            JSONObject jsonObject = new JSONObject(string);
//            if (jsonObject.optInt("type")==1) {
//                startActivity(new Intent(this, PocketActivity.class));
//            } else {
        startActivity(new Intent(this, MessageActivity.class).putExtra("msg", string));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
//        if (UserClass.getInstance().isLogin2(this))
            new HttpServiceImpl().setUploadPushId(clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }
}