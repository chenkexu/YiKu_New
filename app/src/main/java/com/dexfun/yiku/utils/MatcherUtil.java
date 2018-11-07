package com.dexfun.yiku.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Smile on 17/11/2.
 */

public class MatcherUtil {

    /**
     * 验证手机号码
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147、182
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189、177
     *
     * @param cellphone
     * @return matches
     */
    public static boolean checkPhoneNumber(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellphone);
        return matcher.matches();
    }

    /**
     * 验证邮箱地址
     * 包含"@"和"."就算过
     *
     * @param address
     * @return matches
     */
    public static boolean checkMailAddress(String address) {
        return address.contains(".") && address.contains("@");
    }

    public static boolean checkUserName(String username) {
        if (username.contains(".") && username.contains("@")) {
            return true;
        }
        return checkPhoneNumber(username);
    }


}
