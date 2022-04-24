package cn.alectang.community.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.community.entity.Community;
import cn.alectang.community.entity.CommunityPersonnel;
import cn.alectang.community.feign.UserDataService;
import cn.alectang.community.mapper.CommunityMapper;
import cn.alectang.community.service.ICommunityPersonnelService;
import cn.alectang.community.service.ICommunityService;
import cn.alectang.posts.vo.PostsInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @Resource
    private UserDataService userDataService;


    /**
     * 创建社区
     *
     * @param community
     */
    @Override
    public String createCommunity(Community community) {
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

        return getCommunity.getId().toString();
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

    @Override
    public  Map<String,Object>  getCommunityInfo(long id) {
        QueryWrapper<Community> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        queryWrapper.eq("status",1);
        Community community = baseMapper.selectOne(queryWrapper);
        Map<String,Object> map = userDataService.getUserName(community.getAdministrator());
        Map<String, Object> mapa = new HashMap<String, Object>();
        try {

            Field[] declaredFields = community.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(community));
            }
        }catch (Exception e){
            throw new BreatheException(20001,"内部异常");
        }

        map.putAll(mapa);

        return map;
    }


    /***
     * 获取社区列表
     * @param c
     * @return
     */
    @Override
    public Map<String, Object> getCommunityList(int c) {
        Page<Community> page = new Page<>(c, 10);
        QueryWrapper<Community> queryWrapper = new QueryWrapper<>();
        baseMapper.selectPage(page,queryWrapper);
        HashMap<String, Object> map = new HashMap<>();
        List<Community> communityList = page.getRecords();
        long current = page.getCurrent();
        long pages = page.getPages();
        long size = page.getSize();
        long total = page.getTotal();

        map.put("items", communityList);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        return map;
    }
}
