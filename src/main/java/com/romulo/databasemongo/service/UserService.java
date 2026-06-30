package com.romulo.databasemongo.service;

import com.romulo.databasemongo.common.exceptions.ObjectNotFoundException;
import com.romulo.databasemongo.dto.UserDto;
import com.romulo.databasemongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.romulo.databasemongo.domain.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> objUser = repo.findById(id);
        return objUser.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado para o ID: " + id));
    }

    public User insert(User user) {
        return repo.insert(user);
    }

    public User fromDto(UserDto userDto) {
        return new User(userDto.getId(),userDto.getName(),userDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User user) {
        User objUser = findById(user.getId());
        updateData(objUser,user);
        return repo.save(objUser);
    }

    private static void updateData(User newUser, User user) {
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
    }
}
