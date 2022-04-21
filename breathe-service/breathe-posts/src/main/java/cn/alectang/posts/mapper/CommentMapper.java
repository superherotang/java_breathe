package cn.alectang.posts.mapper;

import cn.alectang.posts.entity.Comment;
import cn.alectang.posts.vo.CommentInfo;
import cn.alectang.posts.vo.PostsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alectang
 * @since 2022-04-21
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    Page<CommentInfo> getCommentByPid(@Param("page") Page<CommentInfo> page, @Param("pid") String pid);


}
