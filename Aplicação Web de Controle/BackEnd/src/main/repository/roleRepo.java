public interface RoleRepo extends JpaRepository<Role,Long> {
  Optional<Role> findByName(String name);
}