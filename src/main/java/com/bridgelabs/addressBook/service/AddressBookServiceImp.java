package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.ResponceDto;
import com.bridgelabs.addressBook.exception.CustomException;
import com.bridgelabs.addressBook.model.AddressBookData;
import com.bridgelabs.addressBook.repository.AddressbookRepository;
import com.bridgelabs.addressBook.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressBookServiceImp implements AddressBookService{
    List<AddressBookData> list=new ArrayList<>();
    @Autowired
    private AddressbookRepository addressbookRepository;
    @Autowired
    private JWTToken jwtToken;
    @Override
    public ResponceDto addData(AddressBookDto addressBookDto) {
        AddressBookData addressBookData=new AddressBookData(addressBookDto);
        addressbookRepository.save(addressBookData);
        String token=jwtToken.createToken(addressBookData.getId());
        list.add(addressBookData);
        ResponceDto responceDto=new ResponceDto(token,addressBookData);
        return responceDto;
    }

    @Override
    public AddressBookData getById(int id) {
        return addressbookRepository.findById(id).orElseThrow(() -> new CustomException(" Employee Not found .. wih id: "+ id));
    }

    @Override
    public AddressBookData UpdateEmployee(int id, AddressBookDto addressBookDto) {
        AddressBookData addressBookData =this.getById(id);
        addressBookData.updateData(addressBookDto);
        return addressbookRepository.save(addressBookData);
    }

    @Override
    public void delete(int id) {
        AddressBookData addressBookData =this.getById(id);
        addressbookRepository.delete(addressBookData);
    }

    @Override
    public List<AddressBookData> getAllData() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressBookData getdataByToken(String token) {
        int id= jwtToken.decodeToken(token);
        return addressbookRepository.findById(id).orElseThrow(() -> new CustomException("Employee Not found :- "+id));
    }


}
