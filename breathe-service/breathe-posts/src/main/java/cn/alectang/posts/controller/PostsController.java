package cn.alectang.posts.controller;

import cn.alectang.common.utils.R;
import cn.alectang.posts.entity.Posts;
import cn.alectang.posts.service.IPostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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


    @ApiOperation("上传帖子")
    @PostMapping("/release")
    public R release(Posts posts){
        postsService.release(posts);
        return R.ok();
    }

    @ApiOperation("根据UID或者类型获取帖子所有信息")
    @PostMapping("/getPostInfoPage")
    public R getPostInfoPage(@RequestParam(name = "uid",required = false) String uid,@RequestParam(name = "type",required = false) String type,@RequestParam(name = "current") int current){
        System.out.println(uid);
        System.out.println(type);
        Map<String, Object> postsInfoPage= postsService.getPostInfoPage(String.valueOf(uid),String.valueOf(type),current);
        return R.ok().data(postsInfoPage);
    }

}
