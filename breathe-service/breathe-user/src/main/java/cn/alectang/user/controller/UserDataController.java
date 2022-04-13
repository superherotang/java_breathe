package cn.alectang.user.controller;

import cn.alectang.common.utils.JwtUtils;
import cn.alectang.common.utils.R;
import cn.alectang.common.entity.UserData;
import cn.alectang.common.utils.RedisUtils;
import cn.alectang.user.service.IUserDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Resource
    private RedisUtils redisUtils;

    @ApiOperation(value = "根据Token获取用户信息")
    @GetMapping("/getUserInfo")
    public R getUserInfoByToken(HttpServletRequest request){
        //调用jwt工具类，获取头部信息，返回用户id
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        //根据uid获得用户信息
        UserData userData = userDataService.getUserDataByUid(uid);
        return R.ok().data("userInfo",userData);
    }

    @ApiOperation(value = "根据uid获取用户信息")
    @GetMapping("/getUserInfo/{uid}")
    public R getUserInfoByUid(@PathVariable(name = "uid") String uid){
        //根据uid获得用户信息
        UserData userData = userDataService.getUserDataByUid(uid);
        return R.ok().data("userInfo",userData);
    }


    @ApiOperation(value = "更新用户信息")
    @PostMapping("/updateUserInfo")
    public R updateUserInfoByUid(@RequestBody UserData userData){
        userDataService.updateUserInfoByUid(userData);
        return R.ok();
    }

    @GetMapping("/test")
    public R test(){
        redisUtils.add("test","test");


        return  R.ok();
    }

    @GetMapping("/getTest")
    public R getTest(){
        String test = redisUtils.get("test").toString();

        return  R.ok().data("test",test);
    }

}
