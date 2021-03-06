package cn.alectang.user.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.common.utils.RedisUtils;
import cn.alectang.user.entity.UserCount;
import cn.alectang.user.entity.UserData;
import cn.alectang.user.mapper.UserDataMapper;
import cn.alectang.user.service.IUserDataService;
import cn.alectang.user.vo.SearchUser;
import cn.alectang.user.vo.UserInfoVo;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-06
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserData> implements IUserDataService {

    @Resource
    RedisUtils redisUtils;

    /**
     * 根据UID获取用户信息
     *
     * @param uid
     * @return
     */
    @Override
    public UserData getUserDataByUid(String uid) {
        QueryWrapper<UserData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        UserData userData = baseMapper.selectOne(queryWrapper);
        if (userData == null) {
            throw new BreatheException(20001, "未找到该用户");
        }
        return userData;
    }

    /**
     * 更新用户信息
     *
     * @param userData
     */
    @Override
    public void updateUserInfoByUid(UserData userData) {
        UpdateWrapper<UserData> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uid", userData.getUid());
        baseMapper.update(userData, updateWrapper);
    }

    /**
     * 初始用户信息
     *
     * @param userData
     */
    @Override
    public void initUser(UserData userData) {
        baseMapper.insert(userData);
    }


    /***
     * 获取用户统计
     * @param uid
     * @return
     */
    @Override
    public UserCount getUserCountByUid(String uid) {
        UserCount userCount = JSON.parseObject((String) redisUtils.get(uid + "c"), UserCount.class);
        return userCount;
    }


    @Override
    public Map<String,Object> getUserNameByUid(Long uid) {
        QueryWrapper<UserData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        UserData userData = baseMapper.selectOne(queryWrapper);
        Map<String,Object> map= new HashMap<>();
        map.put("cAdmin",userData.getNickname());
        map.put("cAvatar",userData.getAvatar());
        if (userData==null){
            throw new BreatheException(20001,"找不到该用户");
        }
        return map;
    }

    @Override
    public Map<String, Object> searchUserList(String userStr,int c) {
        Page<SearchUser> page = new Page<>(c, 10);
        baseMapper.searchUserListPage(page,userStr);
        HashMap<String, Object> map = new HashMap<>();
        List<SearchUser> communityList = page.getRecords();
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
