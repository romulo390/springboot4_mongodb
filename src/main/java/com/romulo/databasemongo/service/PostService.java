package com.romulo.databasemongo.service;

import com.romulo.databasemongo.common.exceptions.ObjectNotFoundException;
import com.romulo.databasemongo.domain.Post;
import com.romulo.databasemongo.domain.User;
import com.romulo.databasemongo.repository.PostRepository;
import com.romulo.databasemongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> objPost = postRepository.findById(id);
        return objPost.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado para o ID: " + id));
    }

//    public List<Post> findByTitle(String text) {
//        return postRepository.findByTitleContainingIgnoreCase(text);
//    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
