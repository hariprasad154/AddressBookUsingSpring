package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.Login;
import com.bridgelabs.addressBook.dto.Validation;

public interface RegistatioService {
    String register(AddressBookDto addressBookDto);

    String validate(Validation validation);
    String login(Login login);

}
