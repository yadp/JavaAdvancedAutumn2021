package com.example.lecture20.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);

        UserDetails userAdmin = User.withUsername("yavor")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();
        UserDetails dbAdmin = User
                .withUsername("sa")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        jdbcUserDetailsManager.createUser(userAdmin);
        jdbcUserDetailsManager.createUser(dbAdmin);

        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.csrf().disable().authorizeRequests().mvcMatchers("/h2-console/**").permitAll();
        http.headers()
                .frameOptions()
                .sameOrigin();
        http.authorizeRequests().mvcMatchers("/hello").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().mvcMatchers("/testAdmin").hasRole("ADMIN");
        //http.authorizeRequests().anyRequest().hasAnyRole("USER");
    }
}
