package cn.alectang.community.controller;

import cn.alectang.common.utils.R;
import cn.alectang.common.entity.Community;
import cn.alectang.community.service.ICommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */
@Api(tags = "社区接口")
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Resource
    private ICommunityService communityService;


    @ApiOperation(value = "创建社区")
    @PostMapping("/createCommunity")
    public R createCommunity(@RequestBody Community community){
        communityService.createCommunity(community);
        return  R.ok();
    }


    @ApiOperation(value = "更改社区简介")
    @PostMapping("/updateDescription/{id}")
    public R updateDescription(@PathVariable String id,@RequestParam("description") String description){
        communityService.updateDescription(id,description);
        return  R.ok();
    }


}
