package com.waihon.luv2code.springbootlibrary.dao;

import com.waihon.luv2code.springbootlibrary.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}