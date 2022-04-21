package cn.alectang.community.service;

import cn.alectang.community.entity.Community;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
public interface ICommunityService extends IService<Community> {

    String createCommunity(Community community);

    void updateDescription(String id, String description);

    Map<String,Object> getCommunityInfo(long id);
}
