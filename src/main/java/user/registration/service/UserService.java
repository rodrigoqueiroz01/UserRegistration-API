package user.registration.service;

import user.registration.exception.DataAlreadyRegisteredException;
import user.registration.http.dto.response.UserResponse;
import user.registration.model.UserModel;
import user.registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel registerUser(UserModel userModel) {
        if (!Objects.isNull(userRepository.findByName(userModel.getName()))) {
            throw new DataAlreadyRegisteredException("Já existe usuário com esse nome!");
        }
        return userRepository.save(userModel);
    }

    public UserResponse findByLoginAndPassword(String login, String password) {
        var userModel = userRepository.findByLoginAndPassword(login, password);

        if (Objects.isNull(userModel)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login ou senha estão incorretas!");
        }
        return UserResponse
                .builder()
                .name(userModel.getName())
                .login(userModel.getLogin())
                .password(userModel.getPassword())
                .build();
    }

}
