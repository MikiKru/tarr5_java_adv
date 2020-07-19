package threadsCoordination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ZADANIE
// 1. Utwórz dwa wątki o nazwach producer 1 i producer 2
// 2. Producer 1 wypisuje ne ekran zawartość List<String>
// 3. Producer 2 wypisuje na ekran zawartość Array<Integer>
// --------------------------------------------------------
// 4. Producer 2 może wypisywać na ekran dopiero gdy Producer 1 skończy działanie
// 5. Po zakończeniu pracy obu wątków wątek główny programu -main- niech wypisze na ekranie KONIEC

public class ThreadsController {
    List<String> names = new ArrayList<>(Arrays.asList("Adam","Jan","Anna", "Ola", "Iga"));
    int [] numbers = {22,12,34,54,3,2,1,1,1,1,0,0,1};
    Thread thread1;
    Thread thread2;

    public void printNames(){
        thread1 = new Thread(
                () -> {                                                             // implementacja metody run()
                    for (String name : names) {
                        System.out.println(Thread.currentThread().getName() + " : " +name);
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace(); }
                    }
                }, "Producer 1");
        thread1.start();
    }
    public void printNumbers(){
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();                     // czeka na zakończenie pracy wątka 1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int number : numbers) {
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace(); } } } }, "Producer 2");
        thread2.start();
    }
    public static void main(String[] args) {
        ThreadsController tc = new ThreadsController();
        tc.printNames();
        tc.printNumbers();
        try {
            tc.thread1.join();
            tc.thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("KONIEC");
    }
}
