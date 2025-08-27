package com.infrastructure.security.jwt;
import com.infrastructure.security.userdetails.UserInfoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
public class JwtFilter extends OncePerRequestFilter {
    UserInfoService userInfoService;
    JwtService jwtService;
    public JwtFilter(UserInfoService userInfoService, JwtService jwtService) {
        this.jwtService = jwtService;
        this.userInfoService = userInfoService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        System.out.println(token);

        String username = jwtService.extractUsername(token);
        UserDetails user = userInfoService.loadUserByUsername(username);
        boolean validateToken = jwtService.validateToken(token, user.getUsername());
        if(!validateToken) {
            throw new BadCredentialsException("Invalid JWT token");
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                user,
                null,
                user.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
    }

}