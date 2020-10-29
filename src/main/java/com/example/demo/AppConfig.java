package com.example.demo;

import com.example.demo.pojo.Lion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    private Logger log = LoggerFactory.getLogger(AppConfig.class);
//    @Bean(name = "animal")
//    public Animal animal(){
//        return new Animal() {
//            @Override
//            public void use() {
//                System.out.println("hhhhhhh");
//            }
//        };
//    }
//    @Bean
//    public BussinessPerson bussinessPerson(){
//        return new BussinessPerson();
//    }

    // 使用@Profile
    // 在企业开发过程中，项目往往要在开发环境、测试环境、准生产环境和生产环境之间切换，每一套环境所应对的上下文是不一样的，例如，每个环境所使用的数据库是不一样的，那么就需要一种机制在不同的数据源之间切换。
    // profile就提供了这样的机制，可以方便的在多个环境中切换
    // spring默认不会启动profile机制，这也就意味着，被@Profile标注的bean将不会装配到IoC容器中。
    @Bean(name = "lion")
    @Profile("test")
    public Lion getTestLion() {
        log.info("正在使用test环境");
        return new Lion();
    }

    @Bean(name = "lion")
    @Profile("dev")
    public Lion getDevLion() {
        log.info("正在使用dev环境");
        return new Lion();
    }
}
