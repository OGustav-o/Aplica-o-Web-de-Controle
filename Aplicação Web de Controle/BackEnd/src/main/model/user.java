// User.java
@Entity @Table(name="USERS")
public class User {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(unique=true,nullable=false) private String username;
  @Column(name="PASSWORD_HASH",nullable=false) private String passwordHash;
  private boolean enabled = true;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="USER_ROLES",
     joinColumns=@JoinColumn(name="USER_ID"),
     inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
  private Set<Role> roles = new HashSet<>();
  // getters/setters
}