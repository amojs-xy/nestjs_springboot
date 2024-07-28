package com.example.nestjs.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseEntity<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseEntity() {
    }

    public ResponseEntity(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
