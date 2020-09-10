package com.beers.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        final String authorization = request.getHeader("Authorization");

        String userName = null;
        String jwt = null;

        log.info ("In auth chain " + request.getRequestURL());

        if ( authorization != null && authorization.startsWith("Bearer")) {

            jwt = authorization.substring(7);
            userName = jwtUtil.extractUsername(jwt);
            log.info("token passed is " + jwt);
        }
        if ( userName !=null && SecurityContextHolder.getContext().getAuthentication() == null){

            log.info("userName is  " + userName);

            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            if (jwtUtil.validateToken(jwt,userDetails)) {

                log.info("User details are   " + userDetails.getAuthorities());

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null, userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            else{
                log.info("token invalid");
            }

        }

        chain.doFilter(request,response);
    }



}
