package com.epidata.miApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epidata.miApp.converter.ContactConverter;
import com.epidata.miApp.entity.Contact;
import com.epidata.miApp.model.ContactModel;
import com.epidata.miApp.repository.ContactRepository;
import com.epidata.miApp.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactConverter contactConverter;

    @Override
    public List<ContactModel> getContacts() {
        List<Contact> contactsEntity = contactRepository.findAll();
        List<ContactModel> contactsModel = new ArrayList<>();
        for (Contact contactEntity : contactsEntity) {
            contactsModel.add(contactConverter.toModel(contactEntity));
        }
        return contactsModel;
    }

    @Override
    public ContactModel saveContact(ContactModel contact) {
        Contact contactEntity = contactConverter.toEntity(contact);
        return contactConverter.toModel(contactRepository.save(contactEntity));
    }

    @Override
    public boolean deleteContact(Long idContact) {
        Optional<Contact> contact = contactRepository.findById(idContact);
        if(contact.isPresent()){
            contactRepository.delete(contact.get());
            return true;
        }return false;
    }

    @Override
    public ContactModel getById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()){ 
            return contactConverter.toModel(contact.get());
        }
        return new ContactModel();
    }

}
