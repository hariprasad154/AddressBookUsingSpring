package com.bridgelabs.addressBook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDto {
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "The Name is notEmpty")
    private String name;
    @NotEmpty(message = "The address is not empty")
    private String address;
    @NotEmpty(message = "The city is not empty")
    private String city;
    @NotEmpty(message = "The state is not empty")
    private String state;
    @NotEmpty(message = "The Phone number is not empty")
    private String contactNumber;
    private int zip;
    @NotNull(message = "The email ")
    private String email;
}
