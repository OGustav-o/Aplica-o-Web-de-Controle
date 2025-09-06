public interface ItemRepo extends JpaRepository<Item,Long> {
  List<Item> findByCreatedById(Long userId);
}