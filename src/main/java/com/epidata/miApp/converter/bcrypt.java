package com.epidata.miApp.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class bcrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        System.out.println(bcpe.encode("user"));
    }
}
