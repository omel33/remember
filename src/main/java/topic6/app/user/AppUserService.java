package topic6.app.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import topic6.app.user.dto.AppUserDto;

import java.util.List;

import static topic6.app.user.AppUserMapper.*;

@Service
public class AppUserService {

    private final AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    // 🟢 Отримати всіх користувачів
    public List<AppUser> getAll() {
        return repository.findAll();
    }

    // 🟢 Отримати користувача за ID
    public AppUser getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    // 🟢 Створити нового користувача
    public AppUser create(AppUser user) {
        return repository.save(user);
    }

    // 🟢 Оновити користувача
    public AppUser update(Long id, AppUser userData) {
        AppUser existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        existing.setFullName(userData.getFullName());
        existing.setEmail(userData.getEmail());
        existing.setCity(userData.getCity());
        existing.setAge(userData.getAge());

        return repository.save(existing);
    }

    // 🟢 Видалити користувача
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found: " + id);
        }
        repository.deleteById(id);
    }

    // 🟢 Пошук за іменем (через @Query)
    public List<AppUserDto> searchByName(String name) {
        return repository.searchByName(name).stream()
                .map(AppUserMapper::toDto)
                .toList();
    }

    // 🟢 Пагінація + сортування
    public Page<AppUserDto> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(AppUserMapper::toDto);
    }
}
