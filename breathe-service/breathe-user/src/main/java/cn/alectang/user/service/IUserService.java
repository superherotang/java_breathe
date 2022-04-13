package cn.alectang.user.service;

import cn.alectang.common.entity.LoginState;
import cn.alectang.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-06
 */
public interface IUserService extends IService<User> {

    LoginState smsLoginOrRegister(String phone, String code);

   void sentSms(String phone);


    String pwdLogin(String phone, String password);

    void setPwd(String uid,String password);

}
