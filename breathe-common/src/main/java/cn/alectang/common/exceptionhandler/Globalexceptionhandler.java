package cn.alectang.common.exceptionhandler;


import cn.alectang.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Slf4j
@RestControllerAdvice
public class Globalexceptionhandler {

    //指定异常执行方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("方法执行Exception异常！");
    }

    //自定义的异常处理
    @ExceptionHandler(BreatheException.class)
    @ResponseBody
    public R error(BreatheException e){
        //log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
