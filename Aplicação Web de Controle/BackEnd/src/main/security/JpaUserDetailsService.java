// UserDetailsService impl
@Service
public class JpaUserDetailsService implements UserDetailsService {
  private final UserRepo repo;
  public JpaUserDetailsService(UserRepo r){ this.repo=r; }
  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User u = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("not found"));
    return org.springframework.security.core.userdetails.User
      .withUsername(u.getUsername())
      .password(u.getPasswordHash())
      .authorities(u.getRoles().stream().map(Role::getName).toArray(String[]::new))
      .accountLocked(!u.isEnabled())
      .build();
  }
}