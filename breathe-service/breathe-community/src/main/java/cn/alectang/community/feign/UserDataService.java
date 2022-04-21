package cn.alectang.community.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(
        name = "breathe-user",
        path = "/userData"
)
public interface UserDataService {
    @GetMapping( "/getUserName/{uid}")
    Map<String,Object> getUserName(@PathVariable("uid") Long uid);
}
