package eu.filip.notes.service;

import eu.filip.notes.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserRepository extends CrudRepository<User, Long> {
    ArrayList<User> findAll();
    User findByUsername(String username);
}
