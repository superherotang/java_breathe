package cn.alectang.posts.controller;

import cn.alectang.common.utils.R;
import cn.alectang.posts.entity.Comment;
import cn.alectang.posts.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alectang
 * @since 2022-04-21
 */
@Api(tags = "评论")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    @ApiOperation("根据pid获取评论列表")
    @GetMapping("/getComment/{pid}/{current}")
    public R getCommentByPid(@PathVariable("pid") String pid,@PathVariable("current") int current){
        Map<String,Object> map= commentService.getCommentByPid(current,pid);
        return  R.ok().data(map);
    }

    @ApiOperation("评论")
    @PostMapping("/insertComment")
    public R insertComment(Comment comment){
        commentService.insertComment(comment);
        return  R.ok();
    }
}
