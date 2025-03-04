package com.astafievvadim.authservice.auth.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_custom")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    @Column(name="username")
    private String username;
    @JsonIgnore
    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "custom_roles")
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(Long id, String username, String password, String email, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public void settId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return this.roles;
    }


}