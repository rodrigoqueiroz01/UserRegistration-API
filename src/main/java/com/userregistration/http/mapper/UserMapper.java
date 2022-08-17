package com.userregistration.http.mapper;

import com.userregistration.http.dto.request.UserRequest;
import com.userregistration.http.dto.response.UserResponse;
import com.userregistration.model.UserModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class UserMapper {

    public static UserModel toModel(UserRequest userRequest) {
        return UserModel
                .builder()
                .name(userRequest.getName())
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .build();
    }

    public static UserResponse toResponse(UserModel userModel) {
        return UserResponse
                .builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .login(userModel.getLogin())
                .password(userModel.getPassword())
                .build();
    }

    public static List<UserResponse> toResponseList(List<UserModel> userModelList) {
        if (isNull(userModelList) || userModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return userModelList
                    .stream()
                    .map(UserMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
