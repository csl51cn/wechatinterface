package org.starlightfinancial.wechatinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sili.chen on 2017/5/31.
 */
@SpringBootApplication
//@ServletComponentScan(basePackages = "org.starlightfinancial.wechatinterface")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
