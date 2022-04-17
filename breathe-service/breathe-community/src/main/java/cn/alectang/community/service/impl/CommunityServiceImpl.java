package cn.alectang.community.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.community.entity.Community;
import cn.alectang.community.entity.CommunityPersonnel;
import cn.alectang.community.mapper.CommunityMapper;
import cn.alectang.community.service.ICommunityPersonnelService;
import cn.alectang.community.service.ICommunityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements ICommunityService {

    @Resource
    ICommunityPersonnelService communityPersonnelService;


    /**
     * 创建社区
     *
     * @param community
     */
    @Override
    public void createCommunity(Community community) {
        QueryWrapper<Community> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("community_name", community.getCommunityName());
        //判断是否有该社区
        Long count = baseMapper.selectCount(queryWrapper);
        if (count!=0) {
            throw new BreatheException(20001, "已有该社区");
        }
        //插入
        baseMapper.insert(community);

        QueryWrapper<Community> getCommunityID=new QueryWrapper<>();
        queryWrapper.eq("community_name", community.getCommunityName());
        Community getCommunity = baseMapper.selectOne(queryWrapper);

        CommunityPersonnel communityPersonnel=new CommunityPersonnel();
        communityPersonnel.setCommunityId(getCommunity.getId());
        communityPersonnel.setUid(community.getFounder());
        communityPersonnel.setUserType(0);
        //添加社区人员
        communityPersonnelService.addCommunity(communityPersonnel);
    }

    /**
     * 更新社区简介
     * @param id
     * @param description
     */
    @Override
    public void updateDescription(String id, String description) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", id);
        updateWrapper.set("description", description);
        baseMapper.update(null, updateWrapper);
    }
}
