package cn.alectang.community.service;

import cn.alectang.community.vo.CommunityAnnouncementSimple;
import cn.alectang.community.entity.CommunityAnnouncement;
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
public interface ICommunityAnnouncementService extends IService<CommunityAnnouncement> {

    List<CommunityAnnouncementSimple> getCommunityAnnouncement(String cid);
}
