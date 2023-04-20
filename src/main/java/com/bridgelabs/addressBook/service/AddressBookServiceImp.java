package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import com.bridgelabs.addressBook.dto.Validation;
import com.bridgelabs.addressBook.exception.CustomException;
import com.bridgelabs.addressBook.model.AddressBookData;
import com.bridgelabs.addressBook.repository.AddressbookRepository;
import com.bridgelabs.addressBook.util.EmailService;
import com.bridgelabs.addressBook.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressBookServiceImp implements AddressBookService{
    List<AddressBookData> list=new ArrayList<>();
    List<AddressBookData> updatedList=new ArrayList<>();
    List<AddressBookData> deletedList=new ArrayList<>();
    @Autowired
    private AddressbookRepository addressbookRepository;
    @Autowired
    private JWTToken jwtToken;


    @Autowired
    private EmailService emailService;
//    String token;
//    @Override
//    public ResponceDto addData(AddressBookDto addressBookDto) {
//        AddressBookData addressBookData=new AddressBookData(addressBookDto);
//        addressBookData.setToken(token);
//        addressbookRepository.save(addressBookData);
//        addressBookData.setToken(token);
//
//        list.add(addressBookData);
//
//        ResponceDto responceDto=new ResponceDto(token,addressBookData);
//        return responceDto;
//    }

    @Override
    public String register(AddressBookDto addressBookDto) {
        AddressBookData addressBookData=new AddressBookData(addressBookDto);
        String token=jwtToken.createToken(addressBookData.getId());
        long genarateOtp= (long) ((Math.random() * 9999) % 8998)+1001;
        AddressBookData data=new AddressBookData(token,genarateOtp);
        addressBookData.setOtp(genarateOtp);
        addressBookData.setToken(token);
//        addressbookRepository.save(addressBookData);
        emailService.sendEmail(addressBookData.getEmail(),"The data added successfully ","hi  .."+addressBookData.getName()+"\n your data added succsessfully "+"\n your otp is  <- "+genarateOtp+" ->");
        return "otp genarated sucsussfully      - " +  token;

    }

    @Override
    public String validate(Validation validation) {
        String email=validation.getEmail();
        long otp=addressbookRepository.findByEmail(email);
        if(otp==validation.getOtp()){
            AddressBookData addressBookData =new AddressBookData();
            addressBookData.setVarifyOtp(true);
            addressbookRepository.save(addressBookData);

            return "validation done  "+validation.getEmail();
        }
        else {
            return "validation not done";
        }

    }

    @Override
    public AddressBookData getById(int id) {
        return addressbookRepository.findById(id).orElseThrow(() -> new CustomException(" Employee Not found .. wih id: "+ id));
    }

    @Override
    public AddressBookData UpdateEmployee(int id, AddressBookDto addressBookDto) {
        AddressBookData addressBookData =this.getById(id);
        updatedList.add(addressBookData);
        addressBookData.updateData(addressBookDto);
        return addressbookRepository.save(addressBookData);
    }


    @Override
    public void delete(int id) {
        AddressBookData addressBookData =this.getById(id);
        deletedList.add(addressBookData);
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

    @Override
    public List<AddressBookData> getdeletedData() {
        return deletedList;
//        List<> data=new ArrayList<>();
//        myRepo.findAll().forEach(datas -> data.add(datas));
//        return data;

    }

    @Override
    public List<AddressBookData> getoriginalData() {
        return updatedList;
    }




}
