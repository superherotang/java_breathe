package cn.alectang.community.controller;

import cn.alectang.common.utils.R;
import cn.alectang.community.entity.Community;
import cn.alectang.community.feign.UserDataService;
import cn.alectang.community.service.ICommunityService;
import cn.alectang.user.feign.IUserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Map;

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
    public R createCommunity(Community community){
        String cid =  communityService.createCommunity(community);
        return  R.ok().data("cid",cid);
    }


    @ApiOperation(value = "更改社区简介")
    @PostMapping("/updateDescription/{id}")
    public R updateDescription(@PathVariable String id,@RequestParam("description") String description){
        communityService.updateDescription(id,description);
        return  R.ok();
    }

    @ApiOperation(value = "获取社区信息")
    @GetMapping("/getCommunityInfo/{id}")
    public R getCommunityInfo(@PathVariable long id){
         Map<String,Object> map = communityService.getCommunityInfo(id);


        return  R.ok().data(map);
    }


}
