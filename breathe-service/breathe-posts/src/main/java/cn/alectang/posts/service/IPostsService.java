package cn.alectang.posts.service;

import cn.alectang.common.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

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
}
