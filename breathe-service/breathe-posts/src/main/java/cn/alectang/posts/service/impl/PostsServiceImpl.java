package cn.alectang.posts.service.impl;

import cn.alectang.common.entity.CommunityPersonnel;
import cn.alectang.common.entity.Posts;
import cn.alectang.common.entity.PostsCount;
import cn.alectang.common.entity.PostsInfo;
import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.common.utils.RedisUtils;
import cn.alectang.posts.mapper.PostsMapper;
import cn.alectang.posts.service.IPostsService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
        redisUtils.set(uuid,json);
    }

    /**
     * 获取用户的帖子内容
     * @param uid
     * @param i
     * @return
     */
    @Override
    public List<PostsInfo> getUserPosts(int uid, int current, int i) {
        List<PostsInfo> postsInfoList;
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("uid",uid);
        queryWrapper.select().orderByDesc("create_time");
        final Page<Posts> mpPage = baseMapper.selectPage(new Page<>(current, i), Wrappers.<Posts>query().select().orderByDesc("create_time"));
        final List<Posts> userList = mpPage.getRecords();
        Collection<String> postsUuidList=new ArrayList<>();
        for (Posts posts:userList) {
            postsUuidList.add(posts.getUuid());
        }
        List<String> postsCountList= redisUtils.multiGet(postsUuidList);


        return null;
    }


    @Override
    public List<Posts> getAllPosts(int current, int size) {
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().orderByDesc("create_time");
        final Page<Posts> mpPage = baseMapper.selectPage(new Page<>(current, size), Wrappers.<Posts>query().select().orderByDesc("create_time"));
        System.out.println("总页数 " + mpPage.getPages());
        System.out.println("总记录数 " + mpPage.getTotal());
        final List<Posts> userList = mpPage.getRecords();
        userList.forEach(System.out::println);

        return userList;
    }

    @Override
    public PostsCount getPostsCount(String uuid) {
        PostsCount postsCount = JSON.parseObject((String)redisUtils.get(uuid),PostsCount.class);
        return postsCount;
    }


}
