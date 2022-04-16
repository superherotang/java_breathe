package cn.alectang.posts.service;

import cn.alectang.common.entity.Posts;
import cn.alectang.common.entity.PostsCount;
import cn.alectang.common.entity.PostsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

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

    List<Posts> getAllPosts(int current, int size);

    PostsCount getPostsCount(String uuid);

    List<PostsInfo> getUserPosts(int uid, int current, int i);
}
