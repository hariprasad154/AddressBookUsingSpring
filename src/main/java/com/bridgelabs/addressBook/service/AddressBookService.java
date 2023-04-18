package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.ResponceDto;
import com.bridgelabs.addressBook.model.AddressBookData;

public interface AddressBookService {
    ResponceDto addData(AddressBookDto addressBookDto);
    AddressBookData getEmployeeById(int id);


    AddressBookData UpdateEmployee(int id, AddressBookDto addressBookDto);

    void delete(int id);
}
