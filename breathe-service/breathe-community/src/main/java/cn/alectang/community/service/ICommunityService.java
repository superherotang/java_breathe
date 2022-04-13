package cn.alectang.community.service;

import cn.alectang.common.entity.Community;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
public interface ICommunityService extends IService<Community> {

    void createCommunity(Community community);

    void updateDescription(String id, String description);
}
