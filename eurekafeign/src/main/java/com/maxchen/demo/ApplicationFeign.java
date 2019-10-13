package com.maxchen.demo;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableFeignClients //如果我们要使用 OpenFeign 声明式 HTTP 客户端，必须要在启动类加入这个注解，以开启 OpenFeign
@EnableHystrixDashboard //添加熔断器dashboard
@EnableCircuitBreaker
public class ApplicationFeign {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationFeign.class, args);
    }

    @Bean //添加熔断器dashboard
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet );
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}