package cn.alectang.posts.service;

import cn.alectang.posts.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alectang
 * @since 2022-04-21
 */
public interface ICommentService extends IService<Comment> {

    Map<String, Object> getCommentByPid(int current,String pid);

    void insertComment(Comment comment);
}
