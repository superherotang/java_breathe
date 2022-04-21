package cn.alectang.posts.service;


import cn.alectang.posts.entity.Posts;
import cn.alectang.posts.entity.PostsCount;
import cn.alectang.posts.vo.PostsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-07
 */
public interface IPostsService extends IService<Posts> {

    void release(Posts posts);

    Map<String, Object> getPostInfoPage(List<String> uid,List<String> cid,String type, int current);

}
