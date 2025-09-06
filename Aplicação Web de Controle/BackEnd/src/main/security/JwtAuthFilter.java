// JwtAuthFilter.java
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
  private final JwtService jwtService; private final UserDetailsService uds;
  public JwtAuthFilter(JwtService j, UserDetailsService u){ this.jwtService=j; this.uds=u; }

  @Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws ServletException, IOException {
    String header = req.getHeader("Authorization");
    if (header != null && header.startsWith("Bearer ")) {
      String token = header.substring(7);
      try {
        String username = jwtService.extractUsername(token);
        if (username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
          UserDetails ud = uds.loadUserByUsername(username);
          UsernamePasswordAuthenticationToken auth =
              new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
          auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
          SecurityContextHolder.getContext().setAuthentication(auth);
        }
      } catch (Exception ignored) { }
    }
    chain.doFilter(req, res);
  }
}