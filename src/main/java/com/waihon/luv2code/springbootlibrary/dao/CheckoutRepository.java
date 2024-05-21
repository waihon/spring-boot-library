package com.waihon.luv2code.springbootlibrary.dao;

import com.waihon.luv2code.springbootlibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findBooksByUserEmail(String userEmail);

    @Modifying
    // https://www.udemy.com/course/full-stack-react-and-java-spring-boot-the-developer-guide/learn/lecture/34852172#questions/21088422
    @Query("delete from Checkout where bookId in :bookId")
    void deleteAllByBookId(@Param("bookId") Long bookId);
}
