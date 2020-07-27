package com.dontwaste.configuration;

import com.dontwaste.filter.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilter securityFilter(){
        return new SecurityFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/registration", "/login",
                        "/product/searchProduct", "/product/getAllProducts").permitAll()
                .antMatchers("/institution/getAllInstitutions",
                                        "/institution/createInstitution",
                                        "/institution/deleteInstitution",
                                        "/institution/getInstitution",
                                        "/user/deleteUser").hasAuthority( "ADMIN")
                .antMatchers("/product/createProduct",
                                        "/product/deleteProduct").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/user/getUser","/user/logout").authenticated();

        http.addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
