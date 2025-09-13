@Repository
public interface UserRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByUsername(String username);
    boolean existsByUsername(String username);
}