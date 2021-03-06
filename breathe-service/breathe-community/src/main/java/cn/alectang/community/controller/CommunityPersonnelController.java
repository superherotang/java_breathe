package cn.alectang.community.controller;

import cn.alectang.common.utils.R;
import cn.alectang.community.entity.CommunityPersonnel;
import cn.alectang.community.service.ICommunityPersonnelService;
import cn.alectang.community.vo.MyComment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alectang
 * @since 2022-04-08
 */

@Api(tags = "社区人员接口")
@RestController
@RequestMapping("/communityPersonnel")
public class CommunityPersonnelController {

    @Resource
    private ICommunityPersonnelService communityPersonnelService;



    @ApiOperation(value = "加入社区")
    @PostMapping("/addCommunity")
    public R addCommunity(@RequestBody CommunityPersonnel communityPersonnel){
        communityPersonnelService.addCommunity(communityPersonnel);
        return  R.ok();
    }


    @ApiOperation(value = "更改社区管理者")
    @PostMapping("/updateAdmin/{admin}")
    public R updateAdmin(@RequestBody CommunityPersonnel communityPersonnel,@PathVariable("admin") Long admin){
        communityPersonnelService.updateAdmin(communityPersonnel,admin);
        return  R.ok();
    }

    @ApiOperation(value = "退出社区")
    @GetMapping("/outCommunity/{cid}/{uid}")
    public R outCommunity(@PathVariable("cid") Long cid,@PathVariable("uid") Long uid){
        communityPersonnelService.outCommunity(cid,uid);
        return  R.ok();
    }

    @ApiOperation(value = "根据uid获取社区")
    @GetMapping("/getCommunityByUid/{uid}")
    public R getCommunityByUid(@PathVariable("uid") String uid){
        List<MyComment> myComments=communityPersonnelService.getCommunityByUid(uid);
        return  R.ok().data("myComments",myComments);
    }


    @ApiOperation(value = "判断用户是否加入社区")
    @GetMapping("/isAdd/{cid}/{uid}")
    public R isAdd(@PathVariable("cid") String cid, @PathVariable("uid") String uid){
        boolean flag = communityPersonnelService.isAdd(cid,uid);
        return  R.ok().data("flag",flag);
    }
}
