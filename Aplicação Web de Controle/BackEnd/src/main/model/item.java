// Item.java (domínio)
@Entity @Table(name="ITEMS")
public class Item {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String name;
  private String description;
  @ManyToOne @JoinColumn(name="CREATED_BY") private User createdBy;
  private Instant createdAt = Instant.now();
  // getters/setters
}