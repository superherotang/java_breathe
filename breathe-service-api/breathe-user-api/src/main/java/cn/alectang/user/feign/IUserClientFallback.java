package cn.alectang.user.feign;

import org.springframework.stereotype.Component;

@Component
public class IUserClientFallback implements IUserClient {

    @Override
    public String getUserName(Long uid) {
        return "出错了";
    }
}
