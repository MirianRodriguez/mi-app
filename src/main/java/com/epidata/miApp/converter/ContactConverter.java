package com.epidata.miApp.converter;

import org.springframework.stereotype.Component;

import com.epidata.miApp.entity.Contact;
import com.epidata.miApp.model.ContactModel;

@Component("ContactConverter")
public class ContactConverter {
    
    public Contact toEntity(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setIdContact(contactModel.getId());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setCity(contactModel.getCity());
        return contact;
    }

    public ContactModel toModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getIdContact());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setCity(contact.getCity());
        return contactModel;
    }
}
