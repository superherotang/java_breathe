package cn.alectang.posts.mapper;

import cn.alectang.common.entity.Posts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
