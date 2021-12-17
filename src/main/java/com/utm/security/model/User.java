package com.utm.security.model;

import com.bol.secure.Encrypted;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String id;
    @Encrypted
    private String name;
    @Encrypted
    private String password;
    @Encrypted
    private String email;

    public User(String name, String password, String email) {
        this.id = null;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof User && equals((User) other);
    }

    private boolean equals(User other) {
        return name.equals(other.name)
                && password.equals(other.password)
                && email.equals(other.email);
    }
}
