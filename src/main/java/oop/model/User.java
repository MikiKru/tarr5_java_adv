package oop.model;
// wzorzec JavaBeans
// 1. prywatne pole klasowe

import oop.model.enums.Gender;

import java.time.LocalDateTime;

// Klasa modelu -> klasa determiująca strukturę danych
public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    // płeć jest typem wyliczeniowym
    private Gender gender;
    // zbiór ról
    
    private LocalDateTime registrationDateTime;
    private boolean status;
    private boolean removed;



}
