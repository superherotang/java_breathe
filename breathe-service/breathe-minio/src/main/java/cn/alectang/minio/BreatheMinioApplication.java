package cn.alectang.minio;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"cn.alectang"})
@EnableSwagger2
@EnableKnife4j
//@EnableDiscoveryClient  高版本不需要
public class BreatheMinioApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreatheMinioApplication.class, args);
    }

}
