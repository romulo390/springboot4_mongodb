package com.romulo.databasemongo.controller;

import com.romulo.databasemongo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
            User romulo = new User("1","Romulo","romulo@tipo.com");
            User ilza = new User("2","ilza","ilza@tipo.com");
            List<User> userList = new ArrayList<>();
            userList.addAll(Arrays.asList(romulo,ilza));
            return ResponseEntity.ok().body(userList);
            //OU - return  new ResponseEntity<>(userList, HttpStatus.OK);

    }
}
