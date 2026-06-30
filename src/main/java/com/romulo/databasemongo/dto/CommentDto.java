package com.romulo.databasemongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto implements Serializable {

    private String texto;
    private Date date;
    private AuthorDto author;
}
