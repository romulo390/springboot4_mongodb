package com.romulo.databasemongo.controller;

import com.romulo.databasemongo.Util.Util;
import com.romulo.databasemongo.domain.Post;
import com.romulo.databasemongo.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = Util.decodeParam(text);
        List<Post> postList = postService.findByTitle(text);
        return ResponseEntity.ok().body(postList);
    }

    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) {
        text = Util.decodeParam(text);
        Date min = Util.convertStringToDate(minDate, new Date(0L));
        Date max = Util.convertStringToDate(maxDate, new Date());
        System.out.println("MxDate: "+ max);
        List<Post> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }


}
