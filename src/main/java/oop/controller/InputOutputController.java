package oop.controller;

import oop.model.User;
import oop.model.enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class InputOutputController {
    // globalna ścieżka bezpośrednia do pliku
    private String usersFilePath = "C:\\Users\\PROXIMO\\Desktop\\TARR5\\tarr5_java_adv\\src\\main\\resources\\file\\users.csv";

    public void saveUsersToFile(){
        try {
            PrintWriter pw = new PrintWriter(new File(usersFilePath));
            for (User user : UserControllerTempl.users){
                pw.println(String.format(
                        "%d;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
                        user.getUserId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(),
                        user.getPhone(), user.getGender(), user.getRoles(), user.getRegistrationDateTime(), user.isStatus(),
                        user.isRemoved()
                        ));
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void readUsersFromFile(){
        try {
            Scanner scanner = new Scanner(new File(usersFilePath));
            // pętla odczytująca wartości do linijka po linijce
            while (scanner.hasNextLine()){
                // pobranie linijki tekstu z pliku
                String [] userLine = scanner.nextLine().split(";");
                UserControllerTempl.users.add(
                        new User(userLine[1], userLine[2], userLine[3], userLine[4],userLine[5],
                                userLine[6].equals("MAN") ? Gender.MAN : Gender.WOMAN));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
