package user.registration.repository;

import user.registration.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findByLoginAndPassword(String login, String password);

    UserModel findByName(String name);

}
