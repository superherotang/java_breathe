package cn.alectang.user.service;

import cn.alectang.user.entity.UserCount;
import cn.alectang.user.entity.UserData;
import cn.alectang.user.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-06
 */
public interface IUserDataService extends IService<UserData> {

    UserData getUserDataByUid(String uid);

    void updateUserInfoByUid(UserData userData);


    void initUser(UserData userData);

    UserCount getUserCountByUid(String uid);


    Map<String,Object> getUserNameByUid(Long uid);

    Map<String, Object> searchUserList(String userStr,int current);
}
