package com.bridgelabs.addressBook.controller;


import com.bridgelabs.addressBook.dto.Validation;
import com.bridgelabs.addressBook.service.RegistatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordResetController {
    @Autowired
    private com.bridgelabs.addressBook.service.PasswordReset passwordReset;
    @Autowired
    private RegistatioService regstationService;
    @PostMapping("forgot")
    public String forgetPassword(@RequestParam String email){
        return passwordReset.forgotPassword(email);
    }
    @PutMapping("/reset")
    public String resetPassword(@RequestParam String email,@RequestParam String password,@RequestParam long otp){
        return passwordReset.resetpassword(email,password,otp);
    }
    @PutMapping("/validate")
    public String validation(@RequestBody Validation validation ){
        return regstationService.validate(validation) ;
    }
}