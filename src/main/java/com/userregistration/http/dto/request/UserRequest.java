package com.userregistration.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "Informe o nome!")
    private String name;

    @NotBlank(message = "Informe o login!")
    private String login;

    @NotBlank(message = "Informe a senha!")
    private String password;

}
