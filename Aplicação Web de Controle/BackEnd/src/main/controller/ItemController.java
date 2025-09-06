@RestController @RequestMapping("/api/items")
public class ItemController {
  private final ItemRepo itemRepo; private final UserRepo userRepo;
  public ItemController(ItemRepo i, UserRepo u){ this.itemRepo=i; this.userRepo=u; }

  @GetMapping public List<Item> list(){ return itemRepo.findAll(); }

  @PostMapping
  public Item create(@RequestBody Item item, Principal principal){
    User u = userRepo.findByUsername(principal.getName()).orElseThrow();
    item.setCreatedBy(u);
    item.setCreatedAt(Instant.now());
    return itemRepo.save(item);
  }
}