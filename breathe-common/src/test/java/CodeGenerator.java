
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @ALECTANG
 */
public class CodeGenerator {

    @Test
    public void run() {

        String url = "jdbc:mysql://192.168.10.150:3306/breathe_im?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";

        FastAutoGenerator.create(url, "root", "123456")
                .globalConfig(builder -> {
                    builder.author("alectang") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.alectang") // 设置父包名
                            .moduleName("im") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.entity, "E:\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_client_info") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
