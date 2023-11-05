package com.spring.test.Jwt;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.test.Security.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtils jwtutils;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

		
	  private String parseJwt(HttpServletRequest request) 
	  {
	    String headerAuth = request.getHeader("Authorization");

	    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
	      return headerAuth.substring(7);
	    }

	    return null;
	  }


	  @Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	      throws ServletException, IOException {
		  try {
		        String jwt = parseJwt(request);

		        if (jwt != null && jwtutils.validateJwtToken(jwt)) {
		            String email = jwtutils.getUserNameFromJwtToken(jwt);

		            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

		            UsernamePasswordAuthenticationToken authentication =
		                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

		            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		            SecurityContextHolder.getContext().setAuthentication(authentication);  
		        } 
		        else {
		            	logger.error("retailer jwt");
		            }
		        
		    } catch (Exception e) {
		        logger.error("Cannot set user authentication: {}", e);
		    }

		    filterChain.doFilter(request, response);
	  }

}
