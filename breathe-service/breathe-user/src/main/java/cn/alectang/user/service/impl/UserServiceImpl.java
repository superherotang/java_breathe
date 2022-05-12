package cn.alectang.user.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.common.utils.BCryptUtils;
import cn.alectang.common.utils.JwtUtils;
import cn.alectang.common.utils.RedisUtils;
import cn.alectang.common.utils.VerifyUtils;
import cn.alectang.common.entity.LoginState;
import cn.alectang.user.entity.User;
import cn.alectang.user.entity.UserCount;
import cn.alectang.user.entity.UserData;
import cn.alectang.user.mapper.UserMapper;
import cn.alectang.user.service.IUserDataService;
import cn.alectang.user.service.IUserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private IUserDataService userDataService;

    @Resource
    private RedisUtils redisUtils;


    /**
     * 短信登录或注册
     *
     * @param phone
     * @param code
     * @return
     */
    @Override
    public LoginState smsLoginOrRegister(String phone, String code) {

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)) {
            throw new BreatheException(20001, "手机号或验证码为空");
        }
        if (!VerifyUtils.verifyPhone(phone)) {
            throw new BreatheException(20001, "手机号格式错误");
        }
        if (!VerifyUtils.verifyCode(code)) {
            throw new BreatheException(20001, "验证码格式错误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        User user = baseMapper.selectOne(queryWrapper);
        if (user == null) {
            //未注册用户注册
            User newUser = new User();
            newUser.setPhone(phone);
            newUser.setStatus(2);
            baseMapper.insert(newUser);


            queryWrapper.eq("phone", phone);
            user = baseMapper.selectOne(queryWrapper);

            UserCount userCount = new UserCount().init();
            String json = JSON.toJSONString(userCount);
            redisUtils.set(user.getId()+"c", json);

            UserData userData = new UserData();
            userData.setUid(user.getId());
            userData.setNickname("用户" + user.getId());
            userDataService.initUser(userData);
        }
        //判断用户是否被禁用
        if (user.getStatus() == 0) {
            throw new BreatheException(20001, "用户被禁用登录失败");
        }

        //登录成功
        String token = JwtUtils.getJwtToken(user.getId());

        //取用户状态
        LoginState loginState = new LoginState();
        loginState.setToken(token);
        loginState.setStates(user.getStatus());

        return loginState;
    }


    /**
     * 发送短信
     *
     * @param phone
     */
    @Override
    public void sentSms(String phone) {
        //throw new BreatheException(-1,"test");
        System.out.println(phone + "发送了一条短信");
    }

    @Override
    public String pwdLogin(String phone, String password) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            throw new BreatheException(20001, "手机号或密码为空");
        }
        if (!VerifyUtils.verifyPhone(phone)) {
            throw new BreatheException(20001, "手机号格式错误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        User user = baseMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new BreatheException(20001, "登录错误错误");
        }
        if (!BCryptUtils.verify(password, user.getPassword())) {
            throw new BreatheException(20001, "密码错误");
        }
        //判断用户是否被禁用
        if (user.getStatus() == 0) {
            throw new BreatheException(20001, "用户被禁用登录失败");
        }
        //登录成功
        String token = JwtUtils.getJwtToken(user.getId());
        return token;
    }


    /**
     * 设置密码
     *
     * @param password
     */
    @Override
    public void setPwd(String uid, String password) {
        String encryptPwd = BCryptUtils.encrypt(password);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("phone", uid);
        updateWrapper.set("password", encryptPwd);
        baseMapper.update(null, updateWrapper);
    }

    /***
     * 更新状态
     * @param uid
     * @param states
     */
    @Override
    public void changeStates(String uid, String states) {
        UpdateWrapper<User> userUpdate=new UpdateWrapper<>();
        userUpdate.eq("uid",uid).set("status",states);
        baseMapper.update(null,userUpdate);
    }
}
