package com.romulo.databasemongo.common.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ErroResponse implements Serializable {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


    public ErroResponse(Long timestamp, Integer status, String error, String message, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
