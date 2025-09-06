// JwtService.java
@Service
public class JwtService {
  @Value("${app.jwt.secret}") private String secret;
  @Value("${app.jwt.access-exp-minutes}") private long accessExpMin;

  public String generateAccessToken(UserDetails user) {
    Instant now = Instant.now();
    return Jwts.builder()
      .setSubject(user.getUsername())
      .claim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
      .setIssuedAt(Date.from(now))
      .setExpiration(Date.from(now.plus(Duration.ofMinutes(accessExpMin))))
      .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
      .compact();
  }

  public String extractUsername(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
      .build()
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }
}