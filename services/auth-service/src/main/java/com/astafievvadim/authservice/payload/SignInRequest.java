package com.astafievvadim.authservice.payload;

import org.springframework.lang.NonNull;

public class SignInRequest {

    @NonNull
    private String firstName;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    public SignInRequest(@NonNull String firstName, @NonNull String username, @NonNull String password, @NonNull String email) {
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public SignInRequest() {
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }
}
