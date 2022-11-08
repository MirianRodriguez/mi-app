package com.epidata.miApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epidata.miApp.entity.Contact;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
