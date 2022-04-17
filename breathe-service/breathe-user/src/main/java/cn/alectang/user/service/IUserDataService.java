package cn.alectang.user.service;

import cn.alectang.user.entity.UserCount;
import cn.alectang.user.entity.UserData;
import cn.alectang.user.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    void getUserInfoVo(List<Long> uid);

}
