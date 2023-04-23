package com.bridgelabs.addressBook.repository;

import com.bridgelabs.addressBook.model.AddressBookData;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressbookRepository extends org.springframework.data.jpa.repository.JpaRepository<AddressBookData,Integer> {

    @Query(value = "select id from address_book_data where email= :email",nativeQuery = true)
    int findByEmail(String email);

    //    @Query(value = "select otp from address_book_data where email= :email",nativeQuery = true)
//    long findOtpByEmail(String email);
//    @Query(value = "update address_book_data set varify_otp=true where email= :email",nativeQuery = true)
//    void update(String email);
    @Query(value = "select password from address_book_data where email= :email",nativeQuery = true)
    String getPassword(String email);
    @Query(value = "select email from address_book_data where email= :email",nativeQuery = true)
    String findEmail(String email);


//    @Modifying(flushAutomatically = true)
//    @SQLUpdate(sql = "update address_book_data set password=:password where email= :email")


}
