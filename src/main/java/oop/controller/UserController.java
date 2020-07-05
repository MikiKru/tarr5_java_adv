package oop.controller;

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

// Klasa controllera - odpowiedzialna za obsługę i implementację logiki biznesowej aplikacji
public class UserController implements UserControllerTempl {
    private String passwordEncoder(String password){
        try {
            // Obiekt do szyfrowania hasła algorytmem MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Operacja szyfrowania zwraca tablicę liczb naturalnych
            byte [] passwordHash = md.digest(password.getBytes());
            // Zapisanie tablicy liczb w typie String
            String passwordHashTxt = "";
            for (byte digit : passwordHash){
                passwordHashTxt += digit;
            }
            return passwordHashTxt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override           // adnotacja - przysłniecie
    public void registerUser(User user) {
            // Aktualizacja hasła w modelu user
            user.setPassword(passwordEncoder(user.getPassword()));
            users.add(user);
            System.out.println("Dodano nowego użytkownika: " + user.getEmail());
    }
    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public boolean loginUser(String email, String password) {
        return false;
    }

    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    public void updateUserPassword(int userId, String newPassword) {

    }

    @Override
    public void deleteUserById(int userId) {

    }

    @Override
    public void updateRole(int userId, Set<Role> newRoles) {

    }



    @Override
    public List<User> findAllUsersOrderByArg(UserField userField, boolean asc) {
        return null;
    }
}
