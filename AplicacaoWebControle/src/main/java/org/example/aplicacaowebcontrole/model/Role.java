@Entity
@Table(name = "ROLES")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
// getters/setters
}