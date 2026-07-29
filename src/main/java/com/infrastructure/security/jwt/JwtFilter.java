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
        UsernamePasswordAuthenticationToken authToken = createAuthToken(request);
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken createAuthToken(HttpServletRequest request) {
        try {
            String authHeader = request.getHeader("Authorization");
            String token = authHeader.substring(7);
            String username = jwtService.extractUsername(token);
            UserDetails user = userInfoService.loadUserByUsername(username);

            if (jwtService.isTokenExpired(token)) {
                throw new BadCredentialsException("Invalid JWT token");
            }

            return new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    user.getAuthorities()
            );

        } catch (Exception ex) {
            //this is a user without anything obviously+
            return new UsernamePasswordAuthenticationToken(
                    null,
                    null,
                    null);
        }
    }

}