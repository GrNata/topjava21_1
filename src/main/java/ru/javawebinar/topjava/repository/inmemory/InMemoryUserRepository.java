package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository extends InMemoryBaseRepository<User> implements UserRepository {
    static final int USER_ID = 1;
    static final int ADMIN_ID = 2;
//
//    private final Map<Integer, User> userMap = new ConcurrentHashMap<>();
//    private final AtomicInteger counter = new AtomicInteger(0);

//    @Override
//    public boolean delete(int id) {
//        return userMap.remove(id) != null;
//    }
//
//    @Override
//    public User save(User user) {
//            if (user.isNew()) {
//                user.setId(counter.incrementAndGet());
//                userMap.put(user.getId(), user);
//                return user;
//            }
//        return userMap.computeIfPresent(user.getId(), (id, oldUser) -> user);
//    }
//
//    @Override
//    public User get(int id) {
//        return userMap.get(id);
//    }

    @Override
    public List<User> getAll() {
        return getCollection().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        return getCollection().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }
}
