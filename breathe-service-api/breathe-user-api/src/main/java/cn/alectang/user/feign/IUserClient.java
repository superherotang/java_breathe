package cn.alectang.user.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "breathe-user",
        path = "/userData"
)
@Component
public interface IUserClient {
    @GetMapping( "/getUserName/{uid}")
    String getUserName(@PathVariable("uid") Long uid);
}
