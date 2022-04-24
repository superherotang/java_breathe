package cn.alectang.community.service.impl;

import cn.alectang.community.vo.CommunityAnnouncementSimple;
import cn.alectang.community.entity.CommunityAnnouncement;
import cn.alectang.community.mapper.CommunityAnnouncementMapper;
import cn.alectang.community.service.ICommunityAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
@Service
public class CommunityAnnouncementServiceImpl extends ServiceImpl<CommunityAnnouncementMapper, CommunityAnnouncement> implements ICommunityAnnouncementService {

    @Override
    public List<CommunityAnnouncementSimple> getCommunityAnnouncement(String cid) {


        List<CommunityAnnouncementSimple> announcement= baseMapper.getCommunityAnnouncement(cid);
        return announcement;
    }


}
