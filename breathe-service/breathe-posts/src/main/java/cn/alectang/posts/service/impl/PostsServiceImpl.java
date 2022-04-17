package cn.alectang.posts.service.impl;

import cn.alectang.common.utils.RedisUtils;
import cn.alectang.posts.entity.Posts;
import cn.alectang.posts.entity.PostsCount;
import cn.alectang.posts.mapper.PostsMapper;
import cn.alectang.posts.service.IPostsService;
import cn.alectang.posts.vo.PostsInfo;
import cn.alectang.user.vo.UserInfoVo;
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
 * 服务实现类
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

        PostsCount postsCount = new PostsCount().init();
        String json = JSON.toJSONString(postsCount);
        redisUtils.set(uuid, json);
    }


    /***
     * 根据帖子uid获取分页帖子信息
     * @param uid
     * @return
     */
    @Override
    public Map<String, Object> getPostInfoPage(long uid,int c) {
        Page<PostsInfo> page = new Page<>(c, 10);
        baseMapper.selectPostInfoPage(page, uid);
        List<PostsInfo> postsInfoList = page.getRecords();
        long current = page.getCurrent();
        long pages = page.getPages();
        long size = page.getSize();
        long total = page.getTotal();

        //获取uuid
        Collection<String> keys=new ArrayList<>();
        for(PostsInfo postsInfo:postsInfoList){
            keys.add(postsInfo.getUuid());
        }

        //获取列表
        List<String> countList=redisUtils.multiGet(keys);

        for (int i = 0; i < postsInfoList.size(); i++) {
            PostsCount postsCount=JSON.parseObject(countList.get(i),PostsCount.class);
            PostsInfo postsInfo=postsInfoList.get(i);
            postsInfo.setLike(postsCount.getLike());
            postsInfo.setComment(postsCount.getComment());
            postsInfo.setShare(postsCount.getShare());

            postsInfoList.set(i,postsInfo);
        }


        Map<String, Object> map = new HashMap<>();
        map.put("items", postsInfoList);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);

        return map;
    }


//
//    @Override
//    public List<Posts> getAllPosts(int current, int size) {
//        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select().orderByDesc("create_time");
//        final Page<Posts> mpPage = baseMapper.selectPage(new Page<>(current, size), Wrappers.<Posts>query().select().orderByDesc("create_time"));
//        System.out.println("总页数 " + mpPage.getPages());
//        System.out.println("总记录数 " + mpPage.getTotal());
//        final List<Posts> userList = mpPage.getRecords();
//        userList.forEach(System.out::println);
//
//        return userList;
//    }


}
