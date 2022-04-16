package cn.alectang.posts.controller;

import cn.alectang.common.entity.PostsCount;
import cn.alectang.common.entity.PostsInfo;
import cn.alectang.common.utils.R;
import cn.alectang.common.entity.Posts;
import cn.alectang.common.utils.RedisUtils;
import cn.alectang.posts.feign.UserDataFeignService;
import cn.alectang.posts.service.IPostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        postsService.release(posts);
        return R.ok();
    }

    @ApiOperation("根据uid获取帖子")
    @GetMapping("/getUserPosts/{uid}/{current}")
    public R getUserPosts(@PathVariable(name = "uid") int uid,@PathVariable(name = "current") int current){
        List<PostsInfo> list= postsService.getUserPosts(uid,current,10);
        return R.ok().data("posts",list);
    }



    @ApiOperation("根据创建日期获取帖子")
    @GetMapping("/getAllPost/{current}")
    public R getAllPosts(@PathVariable(name = "current") int current){
        List<Posts> list= postsService.getAllPosts(current,10);
        return R.ok().data("posts",list);
    }




    @ApiOperation("根据帖子UUID获取帖子统计")
    @GetMapping("/getPostsCount/{uuid}")
    public R asd(@PathVariable(name = "uuid") String uuid){
        PostsCount count= postsService.getPostsCount(uuid);
        return R.ok().data("postsCount",count);
    }


}
