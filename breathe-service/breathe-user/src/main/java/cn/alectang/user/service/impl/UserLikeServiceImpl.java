package cn.alectang.user.service.impl;

import cn.alectang.common.utils.RedisUtils;
import cn.alectang.posts.entity.PostsCount;
import cn.alectang.user.entity.UserLike;
import cn.alectang.user.mapper.UserLikeMapper;
import cn.alectang.user.service.IUserLikeService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-25
 */
@Service
public class UserLikeServiceImpl extends ServiceImpl<UserLikeMapper, UserLike> implements IUserLikeService {

    @Resource
    RedisUtils redisUtils;

    @Override
    public void userLikeSave(UserLike userLike) {
        if (userLike.getStatus() == 1) {
            PostsCount postsCount = JSON.parseObject((String) redisUtils.get(userLike.getPid()), PostsCount.class);
            postsCount.setLike(postsCount.getLike() + 1);
            redisUtils.set(userLike.getPid(), JSON.toJSONString(postsCount));

        } else {
            PostsCount postsCount = JSON.parseObject((String) redisUtils.get(userLike.getPid()), PostsCount.class);
            postsCount.setLike(postsCount.getLike() - 1);
            redisUtils.set(userLike.getPid(), JSON.toJSONString(postsCount));
        }
        QueryWrapper<UserLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", userLike.getUid());
        queryWrapper.eq("pid", userLike.getPid());
        Long isLike = baseMapper.selectCount(queryWrapper);
        if (isLike > 0) {
            baseMapper.update(userLike, queryWrapper);
        } else {
            baseMapper.insert(userLike);
        }
    }

    @Override
    public Boolean getUserLike(UserLike userLike) {
        QueryWrapper<UserLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", userLike.getUid());
        queryWrapper.eq("pid", userLike.getPid());
        queryWrapper.eq("status", 1);
        Long isLike = baseMapper.selectCount(queryWrapper);
        if (isLike > 0) {
            return true;
        } else {
            return false;
        }

    }
}
