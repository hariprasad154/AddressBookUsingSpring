package com.bridgelabs.addressBook.controller;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.ResponceDto;
import com.bridgelabs.addressBook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private AddressBookService addressBookService;
    @PostMapping("/add")
    public ResponceDto addData(@Valid @RequestBody AddressBookDto addressBookDto){
        return addressBookService.addData(addressBookDto);
    }
}
