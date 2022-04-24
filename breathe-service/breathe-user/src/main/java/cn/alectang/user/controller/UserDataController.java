package cn.alectang.user.controller;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.common.utils.JwtUtils;
import cn.alectang.common.utils.R;
import cn.alectang.user.entity.UserCount;
import cn.alectang.user.entity.UserData;
import cn.alectang.user.service.IUserDataService;
import cn.alectang.user.vo.SearchUser;
import cn.alectang.user.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alectang
 * @since 2022-04-06
 */
@Api(tags = "用户资料")
@RestController
@RequestMapping("/userData")
@CrossOrigin
public class UserDataController {

    @Resource
    private IUserDataService userDataService;



    @ApiOperation(value = "根据Token获取用户信息")
    @GetMapping("/getUserData")
    public R getUserInfoByToken(HttpServletRequest request){
        //调用jwt工具类，获取头部信息，返回用户id
        String uid;
        try {
            uid = JwtUtils.getMemberIdByJwtToken(request);
        }catch (Exception e){
            throw  new BreatheException(20001,"jwtExpire");
        }
        //根据uid获得用户信息
        UserData userInfo = userDataService.getUserDataByUid(uid);
        return R.ok().data("userData",userInfo);
    }

    @ApiOperation(value = "根据uid获取用户信息")
    @GetMapping("/getUserData/{uid}")
    public R getUserInfoByUid(@PathVariable(name = "uid") String uid){
        //根据uid获得用户信息
        UserData userInfo = userDataService.getUserDataByUid(uid);
        return R.ok().data("userData",userInfo);
    }


    @ApiOperation(value = "更新用户信息")
    @PostMapping("/updateUserData")
    public R updateUserInfoByUid(@RequestBody UserData userData){
        userDataService.updateUserInfoByUid(userData);
        return R.ok();
    }

    @ApiOperation(value = "通过uid获取用户统计")
    @GetMapping("/getUserCount/{uid}")
    public R getUserCountByUid(@PathVariable(name = "uid") String uid){
        UserCount userCount=userDataService.getUserCountByUid(uid);
        return R.ok().data("userCount",userCount);
    }

    @ApiOperation(value = "搜索用户")
    @GetMapping("/getUserCount/{userStr}/{current}")
    public R  searchUserList(@PathVariable("userStr") String userStr, @PathVariable("current") int current){
        Map<String,Object> map = userDataService.searchUserList(userStr,current);
        return R.ok().data(map);
    }



    @ApiOperation(value = "远程调用获取name")
    @GetMapping( "/getUserName/{uid}")
    Map<String,Object> getUserName(@PathVariable("uid") Long uid) {

        return userDataService.getUserNameByUid(uid);
    }


}
