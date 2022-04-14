package cn.alectang.posts.service.impl;

import cn.alectang.common.entity.CommunityPersonnel;
import cn.alectang.common.entity.Posts;
import cn.alectang.common.entity.PostsCount;
import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.common.utils.RedisUtils;
import cn.alectang.posts.mapper.PostsMapper;
import cn.alectang.posts.service.IPostsService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-07
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

    @Resource
    RedisUtils redisUtils;


    @Override
    public void release(Posts posts) {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        posts.setUuid(uuid);

        baseMapper.insert(posts);

        PostsCount postsCount =new PostsCount().init();
        String json = JSON.toJSONString(postsCount);
        redisUtils.inset(uuid,json);
    }

}
