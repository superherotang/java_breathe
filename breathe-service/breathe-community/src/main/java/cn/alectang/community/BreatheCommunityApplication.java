package cn.alectang.community;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.alectang"})
@EnableSwagger2
@EnableKnife4j
public class BreatheCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreatheCommunityApplication.class, args);
    }

}
