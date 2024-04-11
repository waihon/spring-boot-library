package com.waihon.luv2code.springbootlibrary.dao;

import com.waihon.luv2code.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
