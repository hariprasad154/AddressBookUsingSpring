package com.bridgelabs.addressBook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;




@Data
public class AddressBookDto {


    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private String zip;

//    @NotEmpty
//    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "The Name is notEmpty")
//    private String name;
//    @NotNull(message = "The email ")
//    private String email;
//    private String password;
//    private String token;
//    private long otp;
//    private boolean varifyOtp;


}

