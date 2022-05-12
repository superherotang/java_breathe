package cn.alectang.user.controller;

import cn.alectang.common.utils.R;
import cn.alectang.common.entity.LoginState;
import cn.alectang.user.service.IUserService;
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
 * @since 2022-04-06
 */

@Api(tags = "用户登录注册等")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation(value = "短信登录")
    @GetMapping("/codeLogin")
    public R smsLoginOrRegister(@RequestParam("phone") String phone,@RequestParam("code") String code){
        LoginState loginState= userService.smsLoginOrRegister(phone,code);

        return  R.ok().data("token",loginState.getToken()).data("status",loginState.getStates());
    }


    @ApiOperation(value = "发送短信")
    @GetMapping("/sentSms")
    public R sentSms(@RequestParam("phone") String phone){
        userService.sentSms(phone);
        return  R.ok();
    }

    @ApiOperation(value = "密码登录")
    @PostMapping("/pwdLogin")
    public R pwdLogin(@RequestParam("phone") String phone,@RequestParam("password") String password){
        String token=  userService.pwdLogin(phone,password);
        return  R.ok().data("token",token);
    }


    @ApiOperation(value = "设置密码")
    @PostMapping("/setPwd")
    public R setPwd(@RequestParam("uid") String uid,@RequestParam("password") String password){
        userService.setPwd(uid,password);
        return  R.ok();
    }

    @ApiOperation(value = "更新用户状态")
    @GetMapping("/changeStates/{uid}/{states}")
    public R changeStates(@PathVariable("uid") String uid,@PathVariable("states") String states){
        userService.changeStates(uid,states);
        return  R.ok();
    }


}
