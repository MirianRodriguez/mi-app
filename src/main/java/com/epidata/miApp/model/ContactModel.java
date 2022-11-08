package com.epidata.miApp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactModel {
    private Long id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String city;
}
