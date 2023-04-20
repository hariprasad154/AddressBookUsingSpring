package com.bridgelabs.addressBook.repository;

import com.bridgelabs.addressBook.model.AddressBookData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends org.springframework.data.jpa.repository.JpaRepository<AddressBookData,Integer> {
    @Query(value = "select otp from address_book_data where email= :email",nativeQuery = true)
    long findByEmail(String email);

}
