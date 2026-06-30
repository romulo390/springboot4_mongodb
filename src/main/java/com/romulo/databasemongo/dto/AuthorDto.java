package com.romulo.databasemongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.romulo.databasemongo.domain.User;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto implements Serializable {

    private String id;
    private String nome;

    public AuthorDto(User userObj) {
        id = userObj.getId();
        nome = userObj.getUserName();
    }
}
