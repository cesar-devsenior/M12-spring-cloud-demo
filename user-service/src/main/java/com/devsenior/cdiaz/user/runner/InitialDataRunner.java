package com.devsenior.cdiaz.user.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devsenior.cdiaz.user.model.entity.UserEntity;
import com.devsenior.cdiaz.user.repository.UserRepository;

@Component
public class InitialDataRunner implements CommandLineRunner {

    private Logger log;
    private final UserRepository userRepository;
    
    public InitialDataRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
        log = LoggerFactory.getLogger(InitialDataRunner.class);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(List.of(
            new UserEntity(null, "Carlos", "carlos@email.com"),
            new UserEntity(null, "Ana", "ana@email.com")
        ));
        log.info("Usuarios insertados en la base de datos H2");
    }
    
}
