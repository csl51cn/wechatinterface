package org.starlightfinancial.wechatinterface.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by sili.chen on 2017/5/31.
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "org.starlightfinancial.wechatinterface.token")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
