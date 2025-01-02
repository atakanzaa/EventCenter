package com.example.EventCenter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
        private final String SECRET_KEY = "secret"; // Güçlü bir secret key kullanın
        private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 saat

        public String generateToken(String email) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("email", email); // Email'i payload'a ekliyoruz
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }

        public String extractEmail(String token) {
            return extractClaim(token, "email");
        }

        public <T> T extractClaim(String token, String claimName) {
            return (T) Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .get(claimName);
        }
    }