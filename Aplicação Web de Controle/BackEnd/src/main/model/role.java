// Role.java
@Entity @Table(name="ROLES")
public class Role {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(unique=true,nullable=false) private String name;
  // getters/setters
}

