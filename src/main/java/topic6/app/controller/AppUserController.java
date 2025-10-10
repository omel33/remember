package topic6.app.controller;


import org.springframework.web.bind.annotation.*;
import topic6.app.service.AppUserService;
import topic6.app.user.AppUser;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    private final AppUserService service;
    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUser> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AppUser getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        return service.create(user);
    }
    @PutMapping("/{id}")
    public AppUser update(@PathVariable Long id, @RequestBody AppUser user) {
        return service.update(id, user);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
