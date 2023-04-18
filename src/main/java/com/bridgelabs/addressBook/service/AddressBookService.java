package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.ResponceDto;
import com.bridgelabs.addressBook.model.AddressBookData;

import java.util.List;

public interface AddressBookService {
    ResponceDto addData(AddressBookDto addressBookDto);
    AddressBookData getById(int id);


    AddressBookData UpdateEmployee(int id, AddressBookDto addressBookDto);

    void delete(int id);

    List<AddressBookData> getAllData();

    AddressBookData getdataByToken(String token);
}
