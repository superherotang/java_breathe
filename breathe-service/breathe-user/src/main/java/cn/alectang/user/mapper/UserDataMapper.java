package cn.alectang.user.mapper;

import cn.alectang.posts.vo.PostsInfo;
import cn.alectang.user.entity.UserData;
import cn.alectang.user.vo.SearchUser;
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
 * @since 2022-04-06
 */
@Mapper
public interface UserDataMapper extends BaseMapper<UserData> {
    Page<SearchUser>  searchUserListPage(@Param("page") Page<SearchUser> page, @Param("userStr")  String userStr);
}
