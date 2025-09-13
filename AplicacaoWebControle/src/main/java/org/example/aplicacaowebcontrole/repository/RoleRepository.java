
@Repository
public interface UserRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByUsername(String username);
    boolean existsByUsername(String username);
}