package com.romulo.databasemongo.dto;

import com.romulo.databasemongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private String id;
    private String name;
    private String email;


    public UserDto(User obj) {
        id = obj.getId();
        name = obj.getUserName();
        email = obj.getEmail();
    }

}
