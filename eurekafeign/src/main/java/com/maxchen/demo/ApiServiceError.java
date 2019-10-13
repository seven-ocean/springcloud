package com.maxchen.demo;

import org.springframework.stereotype.Component;

@Component
//ApiServiceError用于实现ApiService中的index方法
public class ApiServiceError implements ApiService {

    @Override
    public String index() {
        return "服务发生故障！";
    }
}
