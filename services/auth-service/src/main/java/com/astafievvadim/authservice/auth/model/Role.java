package com.astafievvadim.authservice.auth.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles_custom")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    //@Enumerated(EnumType.STRING)
    @Column(length = 20, name="role")
    private String role;

    public Role() {

    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public String getStringName() {
        return role.toString();
    }

    public void setRole(String role) {
        this.role = role;
    }


}
