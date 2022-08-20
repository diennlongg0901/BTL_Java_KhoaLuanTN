/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author PC
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.demo.repository",
    "com.demo.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary();
    } 
    
    @Override
    protected void configure(AuthenticationManagerBuilder a) throws Exception{
        a.userDetailsService(userDetailsService).passwordEncoder(encoder());
    } 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/DangNhap").usernameParameter("username")
                .passwordParameter("password");
        
        http.formLogin().defaultSuccessUrl("/").failureUrl("/DangNhap?error"); 
        
        http.exceptionHandling().accessDeniedPage("/DangNhap?accessDenied");
        

        http.logout().logoutSuccessUrl("/DangNhap");
        
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/quantri/**").access("hasRole('ROLE_QT')")
                .antMatchers("/giangvien/**").access("hasRole('ROLE_GV')")
                .antMatchers("/giaovu/**").access("hasRole('ROLE_GVU')")
                .antMatchers("/sinhvien/**").access("hasRole('ROLE_SV')");
      
        http.csrf().disable();
    }
}
