package cn.alectang.user.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.common.entity.UserData;
import cn.alectang.user.mapper.UserDataMapper;
import cn.alectang.user.service.IUserDataService;
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
 * @since 2022-04-06
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserData> implements IUserDataService {


    /**
     * 根据UID获取用户信息
     * @param uid
     * @return
     */
    @Override
    public UserData getUserDataByUid(String uid) {
        QueryWrapper<UserData> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        UserData userData = baseMapper.selectOne(queryWrapper);
        if (userData==null){
            throw new BreatheException(20001,"未找到该用户");
        }
        return userData;
    }

    /**
     * 更新用户信息
     * @param userData
     */
    @Override
    public void updateUserInfoByUid(UserData userData) {
        UpdateWrapper<UserData> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uid",userData.getUid());
        baseMapper.update(userData, updateWrapper);
    }

    /**
     * 初始用户信息
     * @param userData
     */
    @Override
    public void initUser(UserData userData) {
        baseMapper.insert(userData);
    }


}
