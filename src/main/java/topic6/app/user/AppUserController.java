package topic6.app.user;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import topic6.app.user.dto.AppUserDto;

import java.util.List;

import static topic6.app.user.AppUserMapper.*;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUserDto> getAll() {
        return service.getAll().stream()
                .map(AppUserMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public AppUserDto getById(@PathVariable Long id) {
        return toDto(service.getById(id));
    }

    @PostMapping
    public AppUserDto create(@Valid @RequestBody AppUserDto dto) {
        return toDto(service.create(toEntity(dto)));
    }

    @PutMapping("/{id}")
    public AppUserDto update(@PathVariable Long id, @Valid @RequestBody AppUserDto dto) {
        return toDto(service.update(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<AppUserDto> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/paged")
    public Page<AppUserDto> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return service.getAll(pageable);
    }

    @PostMapping("/register")
    public AppUserDto register(@Valid @RequestBody AppUserDto dto) {
        AppUser user= toEntity(dto);
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        return toDto(service.create(user));
    }
}
