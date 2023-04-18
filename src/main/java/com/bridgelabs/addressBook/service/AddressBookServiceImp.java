package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.ResponceDto;
import com.bridgelabs.addressBook.model.AddressBookData;
import com.bridgelabs.addressBook.repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressBookServiceImp implements AddressBookService{
    List<AddressBookData> list=new ArrayList<>();
    @Autowired
    private AddressbookRepository addressbookRepository;

    @Override
    public ResponceDto addData(AddressBookDto addressBookDto) {
        AddressBookData addressBookData=new AddressBookData(addressBookDto);
        addressbookRepository.save(addressBookData);
        list.add(addressBookData);
        ResponceDto responceDto=new ResponceDto("The Data added",addressBookData);
        return responceDto;
    }
}
