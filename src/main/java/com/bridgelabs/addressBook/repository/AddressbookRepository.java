package com.bridgelabs.addressBook.repository;

import com.bridgelabs.addressBook.model.AddressBookData;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends org.springframework.data.jpa.repository.JpaRepository<AddressBookData,Integer> {
}
