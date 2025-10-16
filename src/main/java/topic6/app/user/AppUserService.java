package topic6.app.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepository repo;

    public AppUserService(AppUserRepository repo) {
        this.repo = repo;
    }
    public List<AppUser> getAll() {
        return repo.findAll();
    }

    public AppUser getById(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public AppUser create(AppUser user) {
        return repo.save(user);
    }

    public AppUser update(Long id, AppUser updated) {
        AppUser user = getById(id);
        user.setEmail(updated.getEmail());
        user.setFullName(updated.getFullName());
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
