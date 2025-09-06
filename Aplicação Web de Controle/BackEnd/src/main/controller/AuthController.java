// AuthController.java
@RestController @RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authManager;
  private final JwtService jwtService;
  private final UserRepo userRepo;

  public record LoginReq(String username, String password) {}
  public record LoginRes(String accessToken, Map<String,Object> user) {}

  public AuthController(AuthenticationManager am, JwtService js, UserRepo ur){
    this.authManager=am; this.jwtService=js; this.userRepo=ur;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginReq req){
    authManager.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
    var user = userRepo.findByUsername(req.username()).orElseThrow();
    String access = jwtService.generateAccessToken(
      org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
        .password(user.getPasswordHash())
        .authorities(user.getRoles().stream().map(Role::getName).toArray(String[]::new)).build()
    );
    Map<String,Object> u = Map.of("id", user.getId(), "username", user.getUsername(),
                                  "roles", user.getRoles().stream().map(Role::getName).toList());
    return ResponseEntity.ok(new LoginRes(access, u));
  }
}