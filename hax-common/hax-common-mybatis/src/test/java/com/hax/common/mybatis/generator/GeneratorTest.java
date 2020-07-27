package com.hax.common.mybatis.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通过junit test 生成代码
 * 演示：自定义代码模板
 * 默认不会覆盖已有文件，如果需要覆盖，配置GlobalConfig.setFileOverride(true)
 * </p>
 *
 * @author yuxiaobin
 * @date 2018/11/29
 */
public class GeneratorTest {


    //作者
    private static final String AUTHOR = "hax";
    private static final String PARENT_PACKAGE = "com.hax";//父路径
    private static final String OUT_PUT_DIR = "d:/codeGen";
    //逻辑删除字段名
    private static final String DEL_FLAG_COLUMN = "del_flag";

    //JDBC配置，请修改为你项目的实际配置
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hax?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";


    //模板路径地址
    private static final String CONTROLLER_TEMPLATE = "templates/controller.java";
    private static final String ENTITY_TEMPLATE = "templates/entity.java";
    private static final String MAPPER_TEMPLATE = "templates/mapper.java";
    private static final String XML_TEMPLATE = "templates/mapper.xml";
    private static final String SERVICE_TEMPLATE = "templates/service.java";
    private static final String SERVICE_IMPL_TEMPLATE = "templates/serviceImpl.java";


    public static void main(String[] args) {
        generate("system.demo", "sys_user");
    }


    //TODO
    private static void generate(String moduleName, String... tableNamesInclude) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(OUT_PUT_DIR);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        //默认不覆盖，如果文件存在，将不会再生成，配置true就是覆盖
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(JDBC_URL);
        dsc.setDriverName(JDBC_DIVER_CLASS_NAME);
        dsc.setUsername(JDBC_USERNAME);
        dsc.setPassword(JDBC_PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(PARENT_PACKAGE);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tableNamesInclude);
        strategy.setLogicDeleteFieldName(DEL_FLAG_COLUMN);
        strategy.setEntityColumnConstant(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
//        strategy.entityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        // 封装模板数据
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        configCustomizedCodeTemplate(mpg);
        configInjection(mpg, moduleName);

        mpg.execute();
    }

    /**
     * 自定义模板
     *
     * @param mpg
     */
    private static void configCustomizedCodeTemplate(AutoGenerator mpg) {

        //配置 自定义模板
        TemplateConfig templateConfig = new TemplateConfig()
                .setEntity(ENTITY_TEMPLATE)//指定生成自定义模板
                .setXml(null)
                .setController(CONTROLLER_TEMPLATE)
                .setMapper(MAPPER_TEMPLATE)
                .setServiceImpl(null)
                .setService(null);
        mpg.setTemplate(templateConfig);
    }

    /**
     * 配置自定义参数/属性
     *
     * @param mpg
     */
    private static void configInjection(AutoGenerator mpg, String modelName) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                //   map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
                /*
                自定义属性注入: 模板配置：abc=${cfg.abc}
                 */
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        String output = PARENT_PACKAGE.replace(".", "\\");
        String outputModelName = modelName.replace(".", "\\");
        //xml生成
        focList.add(new FileOutConfig(XML_TEMPLATE + ".ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 指定模板生，自定义生成文件到哪个地方
                return OUT_PUT_DIR + "\\" + output + "\\" + outputModelName + "\\" + "xml" + "\\" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        //service
        focList.add(new FileOutConfig(SERVICE_TEMPLATE + ".ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 指定模板生，自定义生成文件到哪个地方
                return OUT_PUT_DIR + "\\" + output + "\\" + outputModelName + "\\" + "service" + "\\" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        //impl
        focList.add(new FileOutConfig(SERVICE_IMPL_TEMPLATE + ".ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 指定模板生，自定义生成文件到哪个地方
                return OUT_PUT_DIR + "\\" + output + "\\" + outputModelName + "\\" + "service\\impl" + "\\" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }
}
