package com.bridgelabs.addressBook.controller;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.Login;
import com.bridgelabs.addressBook.dto.Validation;
import com.bridgelabs.addressBook.service.AddressBookService;
import com.bridgelabs.addressBook.service.RegistatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Registation {
    @Autowired
    private RegistatioService regstationService;

    @PostMapping("/register")
    public String register(@RequestBody AddressBookDto addressBookDto){
        return regstationService.register(addressBookDto);
    }
    @PutMapping("/validate")
    public String validation(@RequestBody Validation validation ){

        return regstationService.validate(validation) ;

    }
    @PostMapping("/login")
    public String login (@RequestBody Login login){
        return regstationService.login(login) ;
    }
//    @Mapping("/test")
//    public String test(@RequestParam String email){
//        return regstationService.test(email);
//    }

}
