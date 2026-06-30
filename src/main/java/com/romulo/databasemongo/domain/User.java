package com.romulo.databasemongo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection="user")
public class User implements Serializable {

    @Id
    private String id;
    private String userName;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email) {
        super();
        this.id = id;
        this.userName = name;
        this.email = email;
    }
}
