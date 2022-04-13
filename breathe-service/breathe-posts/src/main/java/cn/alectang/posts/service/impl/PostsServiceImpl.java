package cn.alectang.posts.service.impl;

import cn.alectang.common.entity.Posts;
import cn.alectang.posts.mapper.PostsMapper;
import cn.alectang.posts.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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




    @Override
    public void release(Posts posts) {
        baseMapper.insert(posts);
    }

}
