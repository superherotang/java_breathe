package cn.alectang.user.controller;

import cn.alectang.common.utils.R;
import cn.alectang.user.entity.UserLike;
import cn.alectang.user.service.IUserLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author alectang
 * @since 2022-04-25
 */
@Api(tags = "用户点赞")
@RestController
@RequestMapping("/userLike")
public class UserLikeController {
    @Resource
    IUserLikeService userLikeService;

    @ApiOperation("用户点赞保存")
    @PostMapping("/save")
    public R UserLikeSave(UserLike userLike) {
        userLikeService.userLikeSave(userLike);
        return R.ok();
    }

    @ApiOperation("判断用户是否点赞")
    @PostMapping("/isLike")
    public R getUserLike(UserLike userLike) {
        Boolean flag = userLikeService.getUserLike(userLike);
        return R.ok().data("flag",flag);
    }

}
