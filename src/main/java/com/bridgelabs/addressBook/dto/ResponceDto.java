package com.bridgelabs.addressBook.dto;

import lombok.ToString;

@ToString
public class ResponceDto {
    public Object data;
    public String message;

    public ResponceDto(String message,Object data) {
        this.data = data;
        this.message = message;
    }
}
