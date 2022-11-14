package com.infoFootball.SpringBackend.Chat;

import com.infoFootball.SpringBackend.User.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

    @Id
    int messageId;
    String messageContents;
    long timeSent;

    @ManyToOne
    @JoinColumn(name = "sent_by_username")
    User sentBy;

    public User getSentBy() {
        return sentBy;
    }

}
