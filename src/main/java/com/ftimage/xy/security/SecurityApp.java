package com.ftimage.xy.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@MapperScan("com.ftimage.xy.security.mapper")
public class SecurityApp {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello SecurityApp!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SecurityApp.class, args);
    }

}
