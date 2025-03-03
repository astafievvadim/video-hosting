package com.astafievvadim.authservice.auth;

import jakarta.persistence.*;

@Entity
@Table(name = "custom_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole role;

    public Role() {

    }

    public Role(ERole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getRole() {
        return role;
    }

    public String getStringName() {
        return role.toString();
    }

    public void setRole(ERole role) {
        this.role = role;
    }


}
