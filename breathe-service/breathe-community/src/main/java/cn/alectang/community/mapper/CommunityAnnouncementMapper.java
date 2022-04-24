package cn.alectang.community.mapper;

import cn.alectang.community.vo.CommunityAnnouncementSimple;
import cn.alectang.community.entity.CommunityAnnouncement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
@Mapper
public interface CommunityAnnouncementMapper extends BaseMapper<CommunityAnnouncement> {
    List<CommunityAnnouncementSimple> getCommunityAnnouncement(@Param("cid") String cid);


}
