package oop;

import oop.controller.UserController;
import oop.controller.UserControllerTempl;
import oop.model.User;
import oop.model.enums.Gender;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Run {
    public static void main(String[] args) {
        // 1. Wywołanie obiektu klasy UserController
        UserController uc = new UserController();
        Scanner scanner = new Scanner(System.in);
        List<User> users = UserControllerTempl.users;
        while(true) {
            System.out.println("Co chcesz zrobic? \n1.Rejestracja \n2.Lista użytkowników \n3.Logowanie \n4.Zmień hasło \nQ.Wyjście");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("1")){
                System.out.println("Podaj imię:");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko:");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email:");
                String email = scanner.nextLine();
                //---
                String emailPattern = "^\\S{1,}[@]\\S{1,}$";    // \S - any non-whitespace character
                if(!Pattern.matches(emailPattern, email)){
                    System.out.println("Błędny adres e-mail");
                    continue;
                }
                //---
                System.out.println("Podaj hasło:");
                String password = scanner.nextLine();
                System.out.println("Podaj płeć (M/K):");
                String genderInput = scanner.nextLine().toUpperCase();
                //---
                String genderPattern = "^[MK]{1}$";
                if(!Pattern.matches(genderPattern,genderInput)){
                    System.out.println("Błędnie wprowadzona płeć");
                    continue;
                }
                //---
                Gender gender = genderInput.equals("M") ? Gender.MAN : Gender.WOMAN;
                System.out.println("Podaj telefon (000-000-000):");
                String phone = scanner.nextLine();
                //---
                String phonePattern = "^[0-9]{3}(-[0-9]{3}){2}$";
                if(!Pattern.matches(phonePattern, phone)){
                    System.out.println("Błędny numer telefonu!");
                    continue;
                }
                //---

                uc.registerUser(new User(name, lastName, email, password, phone, gender));
            } else if(choice.equals("2")) {
                uc.findAllUsers().forEach(user -> System.out.println(user));
            } else if (choice.equals("3")) {
                System.out.println("Podaj email:");
                String email = scanner.nextLine();
                System.out.println("Podaj hasło:");
                String password = scanner.nextLine();
                uc.loginUser(email, password);
            } else if (choice.equals("4")){
                try {
                    System.out.println("Podaj id:");
                    int userId = Integer.valueOf(scanner.nextLine());
                    System.out.println("Podaj nowe hasło:");
                    String newPassword = scanner.nextLine();
                    uc.updateUserPassword(userId, newPassword);
                } catch (InputMismatchException e){
                    System.out.println("Błędny id");
                    continue;
                }
            } else if (choice.equals("Q")){
                System.out.println("Wyjście");
                break;
            } else {
                System.out.println("Błędny wybór");
            }
        }
    }
}
