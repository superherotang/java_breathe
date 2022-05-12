package cn.alectang.community.service;

import cn.alectang.community.entity.CommunityPersonnel;
import cn.alectang.community.vo.MyComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    List<MyComment> getCommunityByUid(String uid);

    boolean isAdd(String cid, String uid);
}
