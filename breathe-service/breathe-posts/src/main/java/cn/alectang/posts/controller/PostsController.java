package cn.alectang.posts.controller;

import cn.alectang.common.utils.R;
import cn.alectang.common.entity.Posts;
import cn.alectang.posts.feign.UserDataFeignService;
import cn.alectang.posts.service.IPostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alectang
 * @since 2022-04-07
 */
@Api(tags = "帖子相关接口")
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Resource
    IPostsService postsService;

    @Resource
    UserDataFeignService minioFeignService;

    @ApiOperation("上传帖子")
    @PostMapping("/release")
    public R release(Posts posts){
        R userInfoByUid = minioFeignService.getUserInfoByUid("3");
        return userInfoByUid;
    }

}
