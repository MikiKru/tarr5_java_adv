package oop;

import oop.controller.UserController;
import oop.controller.UserControllerTempl;
import oop.model.User;
import oop.model.enums.Gender;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        // 1. Wywołanie obiektu klasy UserController
        UserController uc = new UserController();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Co chcesz zrobic? \n1.Rejestracja \n2.Logowanie \nQ. Wyjście");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("1")){
                System.out.println("Podaj imię:");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko:");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email:");
                String email = scanner.nextLine();
                System.out.println("Podaj hasło:");
                String password = scanner.nextLine();
                System.out.println("Podaj płeć (M/K):");
                String genderInput = scanner.nextLine();
                Gender gender = genderInput.equals("M") ? Gender.MAN : Gender.WOMAN;
                System.out.println("Podaj telefon (000-000-000):");
                String phone = scanner.nextLine();
                uc.registerUser(new User(name, lastName, email, password, phone, gender));
            } else if(choice.equals("2")){

            } else if (choice.equals("Q")){
                System.out.println("Wyjście");
                break;
            } else {
                System.out.println("Błędny wybór");
            }
        }
    }
}
