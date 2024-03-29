package com.cvilia.netease.config;

/**
 * author: lzy
 * date: 2020/10/9
 * describe：描述
 */
public class Constants {

    public static final String AGREEMENT = "";

    public static final String COPY_DB_ALREADY = "copy_db_already";
    public static final String FIRST_START = "first_start";

    public static int DEVICE_FIRM = -1;


    /**
     * 登录相关
     */

    public static final String LOGIN_TYPE = "login_type";//1=手机 其他=邮箱
    public static final String LOGIN_ACCOUNT = "login_account";
    public static final String LOGIN_PASSWORD = "login_password";

    /**
     * 用户信息相关
     */
    public static final String USER_PHONE = "user_phone";
    public static final String USER_NAME = "user_name";
    public static final String USER_NICK_NAME = "user_nick_name";
    public static final String USER_ID = "user_id";
    public static final String USER_TOKEN = "user_token";
    public static final String USER_COOKIE = "user_cookie";


    /**
     * 转发到音乐动态的资源类型
     */
    public enum ResourceType {
        song, playlist, mv, djradio, djprogram
    }

}
