package topic3.day14;

import java.util.Optional;

public interface UserRepo {
    Optional<UserG> findByAge(int age);
}
