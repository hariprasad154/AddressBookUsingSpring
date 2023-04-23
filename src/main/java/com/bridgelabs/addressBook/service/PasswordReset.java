package com.bridgelabs.addressBook.service;

public interface PasswordReset {
    String forgotPassword(String email);


    String resetpassword(String email,String password);
}
