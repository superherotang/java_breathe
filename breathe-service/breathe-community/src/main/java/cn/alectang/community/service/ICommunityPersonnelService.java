package cn.alectang.community.service;

import cn.alectang.common.entity.CommunityPersonnel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
public interface ICommunityPersonnelService extends IService<CommunityPersonnel> {

    void addCommunity(CommunityPersonnel communityPersonnel);

    void updateAdmin(CommunityPersonnel communityPersonnel,Long admin);

    void outCommunity(Long cid, Long uid);
}
