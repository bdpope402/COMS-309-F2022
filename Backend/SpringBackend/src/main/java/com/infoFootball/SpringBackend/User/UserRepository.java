package com.infoFootball.SpringBackend.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findById(int id);

    User deleteById(int id);

    User searchForId(String username);
}
