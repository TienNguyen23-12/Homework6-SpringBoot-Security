package vn.iotstar.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.iotstar.entity.Role;
import vn.iotstar.repository.RoleRepository;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(RoleRepository roles) {
        return args -> {
            if (roles.findByName("ROLE_USER").isEmpty()) roles.save(Role.builder().name("ROLE_USER").build());
            if (roles.findByName("ROLE_ADMIN").isEmpty()) roles.save(Role.builder().name("ROLE_ADMIN").build());
        };
    }
}
