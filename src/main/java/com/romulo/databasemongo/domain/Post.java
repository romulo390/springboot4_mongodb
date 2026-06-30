package com.romulo.databasemongo.domain;

import com.romulo.databasemongo.dto.AuthorDto;
import com.romulo.databasemongo.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    private List<CommentDto> comments =  new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDto author) {
        super();
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
