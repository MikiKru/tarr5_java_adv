package lombok;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // test konstruktorów
        User userNoArgs = new User();
        User userAllArgs = new User(1, "test@test.pl", "test", LocalDateTime.now(), true, false);
        // test toString
        System.out.println(userNoArgs);
        System.out.println(userAllArgs);
        // test getterów i setterów
        userNoArgs.setPassword("nowe hasło");
        userNoArgs.setRegistrationDateTime(LocalDateTime.of(2000, 2, 4, 10, 5,5));
        userAllArgs.setStatus(false);
        System.out.println("nowe hasło użytkownika to: " + userNoArgs.getPassword());
        System.out.println("nowy status użytkownika to: " + userAllArgs.isStatus());
        System.out.println("nowa data rejestracji to: " + userNoArgs.getRegistrationDateTime());
        // szablon formatowania daty
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy'r.' '('HH:mm')'");
        System.out.println("sformatowana  data rejestracji to: " + dtf.format(userNoArgs.getRegistrationDateTime()));
        System.out.println("TASKI");
        Task task = new Task();
        Task task1 = new Task("nauka Javy", "programowanie obiektowe", false, userAllArgs);
        System.out.println(task);
        System.out.println(task1);

    }
}
