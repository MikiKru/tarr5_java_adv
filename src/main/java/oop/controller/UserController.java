package oop.controller;

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
                passwordHashTxt += String.format("%x",digit);
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
    public boolean loginUser(String email, String password) {
        for (User user : users){
            // porównanie e-maila i hashów haseł
            if(user.getEmail().equals(email) && user.getPassword().equals(passwordEncoder(password))){
                System.out.println("Zalogowano użytkownika: " + user.getEmail());
                return true;
            }
        }
        System.out.println("Błąd logowania");
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
    // ------------------------------------------------
    @Override
    public User findUserById(int userId) {
        for(User user : users){
            if(user.getUserId() == userId){
                System.out.println("Znaleziono użytkownika : " + user);
                return user;
            }
        }
        System.out.println("Nie znaleziono użytkownika o id=" + userId);
        return null;
    }
    @Override
    public void updateUserPassword(int userId, String newPassword) {
        // 1. pobranie użytkownika z listy na podstawie userId
        User user = findUserById(userId);
        // 2. Sprawdzenie czy użytkownik istnieje
        if(user != null) {
            // 3. zmiana hasła i zapisanie hash-u tego hasła
            user.setPassword(passwordEncoder(newPassword));
            System.out.println("Zmieniono hasło");
        } else {
            System.out.println("Nie zmieniono hasła");
        }
    }
    // ------------------------------------------------

    @Override
    public void deleteUserById(int userId) {
        if(findUserById(userId) == null){
            System.out.println("Nie ma użytkownika o id="+userId);
        } else {
            for (User user : users) {
                if (user.getUserId() == userId) {
                    users.remove(user);
                    System.out.println("Usunięto użytkownika: " + user.getEmail());
                    break;
                }
            }
        }
    }
    @Override
    public List<User> findAllUsersOrderByEmail(boolean asc) {
        if(asc) {       // sortowanie rosnące A-Z
            return users.stream()                                           // zamiana List<User> -> Stream<User>
                    .sorted(Comparator.comparing(User::getEmail))           // SortedStream<User>
                    .collect(Collectors.toList());                          // zamiana SortedStream<User> -> List<User>
        } else {        // sortowanie malejące Z-A
            return users.stream()                                                   // zamiana List<User> -> Stream<User>
                    .sorted(Comparator.comparing(User::getEmail).reversed())        // SortedStream<User>
                    .collect(Collectors.toList());
        }
        }

    // ZADANIE DOMOWE -------------------------------------------------------
    @Override
    public void updateRole(int userId, Set<Role> newRoles) {

    }
    // ----------------------------------------------------------------------

}
