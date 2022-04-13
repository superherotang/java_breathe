package cn.alectang.common.utils;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtils {

    /**
     *   加密
     * @param password
     * @return
     */
    public static String encrypt(String password){
        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encodedPassword;
    }

    /**
     * 验证
     * @param password
     * @param encodedPassword
     * @return
     */
    public static Boolean verify(String password,String encodedPassword){
        boolean flag = BCrypt.checkpw(password, encodedPassword);
        return flag;
    }
}
