package cn.alectang.community.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.community.entity.CommunityPersonnel;
import cn.alectang.community.mapper.CommunityPersonnelMapper;
import cn.alectang.community.service.ICommunityPersonnelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
@Service
public class CommunityPersonnelServiceImpl extends ServiceImpl<CommunityPersonnelMapper, CommunityPersonnel> implements ICommunityPersonnelService {

    /**
     * 加入社区
     * @param communityPersonnel
     */
    @Override
    public void addCommunity(CommunityPersonnel communityPersonnel) {
        QueryWrapper<CommunityPersonnel> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("community_id",communityPersonnel.getCommunityId());
        queryWrapper.eq("uid",communityPersonnel.getUid());
        Long count = baseMapper.selectCount(queryWrapper);
        if (count!=0){
            throw new BreatheException(20001,"您已加入该社区");
        }
        baseMapper.insert(communityPersonnel);
    }

    /**
     * 更新社区管理员
     * @param communityPersonnel
     * @param admin
     */
    @Override
    public void updateAdmin(CommunityPersonnel communityPersonnel,Long admin) {
        //任命管理员
        UpdateWrapper<CommunityPersonnel> updateWrapperToUser=new UpdateWrapper<>();
        updateWrapperToUser.eq("uid", communityPersonnel.getUid());
        updateWrapperToUser.set("user_type", 0);
        baseMapper.update(null, updateWrapperToUser);

        //去除管理员
        UpdateWrapper<CommunityPersonnel> updateWrapperToAdmin=new UpdateWrapper<>();
        updateWrapperToAdmin.eq("uid", admin);
        updateWrapperToAdmin.set("user_type", 2);
        baseMapper.update(null, updateWrapperToAdmin);
    }

    /**
     * 退出社区
     * @param cid
     * @param uid
     */
    @Override
    public void outCommunity(Long cid, Long uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("community_id",cid);
        wrapper.eq("uid",uid);
        int rows = baseMapper.delete(wrapper);
        if (rows==0){
            throw new BreatheException(20001,"退出失败请重试");
        }
    }
}
