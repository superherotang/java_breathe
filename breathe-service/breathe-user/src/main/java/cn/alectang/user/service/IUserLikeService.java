package cn.alectang.user.service;

import cn.alectang.user.entity.UserLike;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-25
 */
public interface IUserLikeService extends IService<UserLike> {

    void userLikeSave(UserLike userLike);

    Boolean getUserLike(UserLike userLike);
}
