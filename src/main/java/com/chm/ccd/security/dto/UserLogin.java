package com.chm.ccd.security.dto;

import javax.validation.constraints.NotBlank;

public class UserLogin {

	@NotBlank
    private String email;
    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setName(String emailUsuario) {
        this.email = emailUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
