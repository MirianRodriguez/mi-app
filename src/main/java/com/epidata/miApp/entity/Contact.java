package com.epidata.miApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contact")
@Getter
@Setter
public class Contact {
    @Id
    @Column(name="id_contact")
    @GeneratedValue(strategy = IDENTITY)
    private Long idContact;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String telephone;
    @Column
    private String city;

}
