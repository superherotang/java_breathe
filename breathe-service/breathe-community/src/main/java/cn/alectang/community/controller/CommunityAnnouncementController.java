package cn.alectang.community.controller;

import cn.alectang.community.vo.CommunityAnnouncementSimple;
import cn.alectang.common.utils.R;
import cn.alectang.community.service.ICommunityAnnouncementService;
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
@Api(tags = "社区公告")
@RestController
@RequestMapping("/communityAnnouncement")
public class CommunityAnnouncementController {

    @Resource
    ICommunityAnnouncementService communityAnnouncementService;

    @ApiOperation(value = "获取社区社区公告")
    @GetMapping("/getCommunityAnnouncement/{cid}")
    public R getCommunityAnnouncement(@PathVariable("cid") String cid){
        List<CommunityAnnouncementSimple> announcement=communityAnnouncementService.getCommunityAnnouncement(cid);
        return  R.ok().data("announcement",announcement);
    }



}
