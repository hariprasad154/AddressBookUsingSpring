package com.bridgelabs.addressBook.service;

import com.bridgelabs.addressBook.dto.Validation;
import com.bridgelabs.addressBook.exception.CustomException;
import com.bridgelabs.addressBook.model.AddressBookData;
import com.bridgelabs.addressBook.repository.AddressbookRepository;
import com.bridgelabs.addressBook.util.EmailService;
import com.bridgelabs.addressBook.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PasswordResetImp implements PasswordReset {
    @Autowired
    private AddressbookRepository addressbookRepository;
    @Autowired
    private JWTToken jwtToken;
    @Autowired
    private EmailService emailService;

    @Override
    public String forgotPassword(String email) {
        return null;
    }

    @Override
    public String resetpassword(String email, String password) {
        return null;
    }

//    @Override
//    public String forgotPassword(String email) {
//        int id = addressbookRepository.findByEmail(email);
//        AddressBookData addressBookData = addressbookRepository.findById(id).orElseThrow(() -> new CustomException(" Employee Not found .. wih id: " + id));
//        Optional<AddressBookData> data = addressbookRepository.findById(id);
//        if (id <= 0) {
//            return "The mail is Not Registered.....";
//        } else {
//            long genarateOtp = (long) ((Math.random() * 9999) % 8998) + 1001;
////            addressBookData.setOtp(genarateOtp);
//            data.get().setOtp(genarateOtp);
//            data.get().setVarifyOtp(false);
//            addressbookRepository.save(data.get());
//            emailService.sendEmail(addressBookData.getEmail(), "The data added successfully ", "hi...." + addressBookData.getName() + "\n your data added succsessfully " + "\n your otp is  <- " + genarateOtp + " ->");
//            return "otp genarated sucsussfully -" + genarateOtp;
//        }
//    }

//    @Override
//    public String resetpassword(String email, String password) {
//        String mail = addressbookRepository.findEmail(email);
//        if (mail==null){
//            return "email is not present";
//            }
//        else{
//            int id =addressbookRepository.findByEmail(email);
//            /*
//            long otpDatabase=addressbookRepository.findOtp(email);
//            validating otp if otp
//            if (otp==otpDatabase){
//                }else{
//                    The Otp Entered Is wrong one please checkit once
//                }
//             */
//
//            Optional<AddressBookData> data = addressbookRepository.findById(id);
//            if ((data.isPresent() && (data.get().isVarifyOtp() == true))) {
//                data.get().setPassword(password);
//                addressbookRepository.save(data.get());
//    //        data.setPassword(password);
//    //        addressbookRepository.updatePassword(email,password);
//                return "The Password Reset Done";
//            } else {
//                    return "password validaton not done becoze The Otp varification Not done  ~_~ :) ";
//                }
//            }
//    }
}