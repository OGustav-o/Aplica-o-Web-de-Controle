package org.example.aplicacaowebcontrole.config;

import io.jsonwebtoken.*;


import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class JwtTokenProvider {


    @Value("${jwt.secret}")
    private String secretKey;


    @Value("${jwt.expiration-ms}")
    private long validityInMilliseconds;


    private Key key;


    @PostConstruct
    protected void init() {
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }


    public String createToken(String username, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);


        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);


        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }


    @SuppressWarnings("unchecked")
    public Set<String> getRoles(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        Object rolesObj = claims.get("roles");
        if (rolesObj instanceof Collection) {
            return ((Collection<Object>) rolesObj).stream().map(Object::toString).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}