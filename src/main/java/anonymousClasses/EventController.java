package anonymousClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface EventController {
    // 1. pola klasowe -> publiczne, statyczne i finalne
    public static final String eventName = "Mój event";
    LocalDateTime eventDate = LocalDateTime.of(2020,02,02,20,12,10);
    // 2. metody abstrakcyjne -> publiczne
    public abstract void printEvent();
    // 3. metody statyczne -> publiczne
    public static void formattedEventDate(){
        System.out.printf("Data wydarzenia: %s w dniu: %s",
                eventName,
                eventDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
    }
    // 4. metody defaultowe -> od wersji java 8
}
