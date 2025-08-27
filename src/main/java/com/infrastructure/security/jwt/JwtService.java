package com.infrastructure.security.jwt;


import com.application.login.TokenGenerator;
import com.domain.clock.SystemTime;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtService implements TokenGenerator {
    @Value("${jwt.secret}")
    private String secret;
    private final SystemTime time;

    public JwtService(SystemTime time) {
        this.time = time;
    }

    public String generateToken(String username) {
        Instant now = time.now();
        long expirationTimeSeconds = 30L * 60L;
        Instant expiration = now.plusSeconds(expirationTimeSeconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        Instant now = time.now();
        return extractExpiration(token).before(Date.from(now));
    }

    public Boolean validateToken(String token, String usernameInput) {
        final String username = extractUsername(token);
        return (username.equals(usernameInput) && !isTokenExpired(token));
    }
}
