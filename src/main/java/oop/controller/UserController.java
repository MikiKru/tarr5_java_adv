package oop.controller;

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Role;

import java.util.List;
import java.util.Set;

// Klasa controllera - odpowiedzialna za obsługę i implementację logiki biznesowej aplikacji
public class UserController implements UserControllerTempl {
    @Override           // adnotacja - przysłniecie
    public void registerUser(User user) {
        users.add(user);
        System.out.println("Dodano nowego użytkownika: " + user.getEmail());
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
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public List<User> findAllUsersOrderByArg(UserField userField, boolean asc) {
        return null;
    }
}
