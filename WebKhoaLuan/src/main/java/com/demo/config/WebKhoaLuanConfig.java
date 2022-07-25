/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author PC
 */
@Configuration
@EnableWebMvc
@ComponentScan (basePackages = { "com.demo.controller" })
public class WebKhoaLuanConfig implements WebMvcConfigurer{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
    
    
//    @Bean
//    public InternalResourceViewResolver viewResolver () {
//        InternalResourceViewResolver r = new InternalResourceViewResolver ();
//        r.setPrefix("WEB-INF/jsp/");
//        r.setSuffix(".jsp");
//        return r;
//    }
}
