package com.maxchen.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope //以这种方式注释的bean可以在运行时刷新（可以在程序运行时刷新配置文件）
public class HelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("index")
    public String index() {
        return "Hello World!,端口：" + port;
    }
}

