package cuit.epoch.pymjl.utils;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/4/28 19:16
 **/
public class CodeGenerator {
    private final static String URL = "jdbc:mysql://127.0.0.1:3306/security?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "pl20020116";
    private final static String OUT_PUT_DIR = "C:\\Users\\Admin\\JavaProjects\\blog-code-demo\\security\\src\\main\\java";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USER_NAME, PASSWORD)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride()
                        .outputDir(OUT_PUT_DIR)
                        .fileOverride())
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .addTablePrefix("t_")
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();

    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
