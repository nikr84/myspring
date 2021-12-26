package com.nikorp.myspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.nikorp.ioc", "com.nikorp.di"})
@PropertySource("classpath:/sports.properties")
public class OldSportsConfig {

}
