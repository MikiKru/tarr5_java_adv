package exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyException extends Exception {
    public MyException() {
        System.out.println("Jestem w kontruktorze: MyException");
        System.out.println(getExceptionDateTime());
    }
    @Override
    public void printStackTrace() {
        super.printStackTrace();    // wywołanie metody z nadklasy Exception
        System.out.println("Moja obsługa wyjątku"); // własna obsługa
    }
    public String getExceptionDateTime(){
        return DateTimeFormatter.ofPattern("dd.MM.yyyy'r.' '('HH:mm:ss')'").format(LocalDateTime.now());
    }
}
