package com.dontwaste.filter;

import com.dontwaste.model.customer.entity.User;
import com.dontwaste.service.SessionService;
import com.dontwaste.service.UserRoleService;
import com.dontwaste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("Authorization");
        if(token != null){
                User user = sessionService.getUserByToken(token);
                if(user != null){
                    List<GrantedAuthority> roles = userRoleService.getAllByUser(user).stream()
                            .map(userRole -> userRole.getRole().getRoleName())
                            .map(roleName -> new SimpleGrantedAuthority(roleName))
                            .collect(Collectors.toList());

                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            null,
                            roles
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
