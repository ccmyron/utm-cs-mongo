package com.utm.security.job;

import java.util.List;

import com.utm.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.utm.security.model.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
@RequiredArgsConstructor
public class DatabaseBootstrapper implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Started populating database");

        var users = buildUsers();
        users.forEach(user -> ensureEntityExists(user, userRepository));
        log.info("Inserted {} users", users.size());

        log.info("Finished populating database");
    }

    private List<User> buildUsers() {
        return List.of(
                new User("Montana Millar", "?9K.V5UGb_", "Montana@email.com"),
                new User("Nikki Bloggs", "x3/uFs!VS4", "Nikki@email.com"),
                new User("Victoria Fry", "z*7k7*Hp&K", "Victoria@email.com"),
                new User("Chelsie Clay", "QW4bM6v)\"[", "Chelsie@email.com"),
                new User("Mandy Hartley", "LH3rY#.ZvN", "Mandy@email.com")
        );
    }

    private <T> void ensureEntityExists(T entity, MongoRepository<T, String> repository) {
        for (T object : repository.findAll()) {
            if (object.equals(entity)) {
                return;
            }
        }

        repository.save(entity);
    }
}
