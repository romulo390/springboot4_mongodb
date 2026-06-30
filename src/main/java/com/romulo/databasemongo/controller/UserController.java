package com.romulo.databasemongo.controller;

import java.net.URI;

import com.romulo.databasemongo.domain.Post;
import com.romulo.databasemongo.domain.User;
import com.romulo.databasemongo.dto.UserDto;
import com.romulo.databasemongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> findAll() {
            List<User> userList = userService.findAll();
            List<UserDto> userDtoList = userList.stream().map(UserDto::new).toList();
            return ResponseEntity.ok().body(userDtoList);
            //OU - return  new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto  userDto) {
        User user = userService.fromDto(userDto);
        user =  userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDto userDto, @PathVariable String id) {
        User objUser = userService.fromDto(userDto);
        objUser.setId(id);
        userService.update(objUser);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }


}
