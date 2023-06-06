package com.bridgelabs.addressBook.model;

import com.bridgelabs.addressBook.dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookData {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private String zip;


    public void updateData(AddressBookDto addressBookDto){
        this.lastName= addressBookDto.getLastName();
        this.firstName= addressBookDto.getFirstName();
        this.address=addressBookDto.getAddress();
        this.city=addressBookDto.getCity();
        this.state=addressBookDto.getState();
        this.phoneNumber=addressBookDto.getPhoneNumber();
        this.zip=addressBookDto.getZip();
    }

    public AddressBookData(AddressBookDto addressBookDto){
        this.updateData(addressBookDto);
    }
}
