package topic6.app.user;

import jakarta.validation.Valid;
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
        return service.getAll().stream().map(AppUserMapper::toDto).toList();
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
}
