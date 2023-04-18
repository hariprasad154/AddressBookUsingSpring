package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.ResponceDto;

public interface AddressBookService {
    ResponceDto addData(AddressBookDto addressBookDto);
}
