package br.dev.felipeassis.springsecurity.config;

import br.dev.felipeassis.springsecurity.entities.Role;
import br.dev.felipeassis.springsecurity.entities.User;
import br.dev.felipeassis.springsecurity.repositories.RoleRepository;
import br.dev.felipeassis.springsecurity.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminConfig implements CommandLineRunner {

    private static final String DEFAULT_ADMIN = "admin";
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminConfig(RoleRepository roleRepository,
                       UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        var userAdmin = userRepository.findByUsername(DEFAULT_ADMIN);
        userAdmin.ifPresentOrElse(
                user -> System.out.println("admin já existe"),
                () -> {
                    var user = new User();
                    user.setUsername(DEFAULT_ADMIN);
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                }
            );
    }
}
