package com.epidata.miApp.service;

import java.util.List;

import com.epidata.miApp.model.ContactModel;

public interface ContactService {
    public abstract List<ContactModel> getContacts();

    public abstract ContactModel saveContact(ContactModel contactModel);

    public abstract boolean deleteContact(Long idContact);

    public abstract ContactModel getById(Long id);
    
}
