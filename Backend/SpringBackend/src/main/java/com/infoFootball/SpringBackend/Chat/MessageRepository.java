package com.infoFootball.SpringBackend.Chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {

    Message findById(int Id);

    void deleteById(int Id);
}
