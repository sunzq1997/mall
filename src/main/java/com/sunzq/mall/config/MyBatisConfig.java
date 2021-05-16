package com.sunzq.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sunzq.mall.mbg.mapper")
public class MyBatisConfig {
}
