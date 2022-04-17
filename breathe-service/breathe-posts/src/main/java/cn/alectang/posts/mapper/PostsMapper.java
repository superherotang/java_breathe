package cn.alectang.posts.mapper;

import cn.alectang.posts.entity.Posts;
import cn.alectang.posts.vo.PostsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alectang
 * @since 2022-04-07
 */
@Mapper
public interface PostsMapper extends BaseMapper<Posts> {

   // @Select("SELECT p.*,u.nickname,u.avatar FROM t_posts p LEFT JOIN t_user_data u on p.uid=u.uid WHERE p.uid=11 ORDER BY p.create_time DESC ")
    Page<PostsInfo> selectPostInfoPage(@Param("page") Page<PostsInfo> page,@Param("uid")  String uid,@Param("postsType")  String postsType);
}
