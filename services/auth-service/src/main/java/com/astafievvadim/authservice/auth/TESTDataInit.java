package com.astafievvadim.authservice.auth;

import com.astafievvadim.authservice.auth.model.Role;
import com.astafievvadim.authservice.auth.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TESTDataInit implements ApplicationRunner {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role a = new Role("ROLE_USER");
        Role b = new Role("ROLE_ADMIN");

        roleRepo.save(a);
        roleRepo.save(b);

    }
}
