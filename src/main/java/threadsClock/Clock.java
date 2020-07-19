package threadsClock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    // ZEGAREK CYFROWY HH:mm:ss
    // napisz program wypisujący na konoli aktualny czas i odświeżający go co sekundę
    private static String editString(int stringLength) {
        StringBuilder builder = new StringBuilder();        // string edytowalny
        for (int i = 0; i < stringLength; i++)
            builder.append("\b");
        return builder.toString();
    }
    public void printTime() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
//                       String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                        String currentTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now());
                        System.out.printf(currentTime);
                        Thread.currentThread().sleep(1000);
                        System.out.printf("%s", editString(currentTime.length()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } } }
        });
        thread.start();
    }

    public static void main(String[] args) {
        new Clock().printTime();
    }
}
