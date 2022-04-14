package cn.alectang.posts.feign;

import cn.alectang.common.utils.R;
import cn.alectang.posts.feign.fallback.UserDataFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "breathe-user",fallback = UserDataFeignServiceFallback.class, path = "/userData")
public interface UserDataFeignService {

    @GetMapping("/getUserInfo/{uid}")
    R getUserInfoByUid(@PathVariable(name = "uid") String uid);
}
