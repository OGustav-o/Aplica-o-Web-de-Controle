@Entity
@Table(name = "ITEMS")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Instant createdAt = Instant.now();
// getters/setters
}