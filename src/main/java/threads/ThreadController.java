package threads;

import java.sql.Time;
import java.util.*;

public class ThreadController {
    Deque<Integer> numbers = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    // metoda implementująca wątek wypisujący wszystkie liczby
    public void printNumbers(Thread thread){
        // utworzenie klasy anonimowej
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long timeStart = System.currentTimeMillis();
                while(!numbers.isEmpty()) {
                    try {
//                        Thread.currentThread().sleep(new Random().nextInt(6) * 1000);     // uśpienie wąktu thread na 1s
                        Thread.currentThread().sleep(1000);
                        synchronized (numbers) {            // synchronizacja - sekcja krytyczna
                            System.out.println("Wątek: " + Thread.currentThread().getName() +
                                    " - wartość: " + numbers.removeFirst() +
                                    " aktualna zawartość: " + numbers);
//                            Thread.currentThread().sleep(new Random().nextInt(10) * 100);
                            Thread.currentThread().sleep(1000);
                            System.out.println("Jeszcze coś robię");
//                            Thread.currentThread().sleep(new Random().nextInt(10) * 100);
                            Thread.currentThread().sleep(1000);
                            System.out.println("i jeszcze");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (NoSuchElementException e){
                        break;
                    }
                }
                System.out.println("Czas [s]: " + ((System.currentTimeMillis() / 1000) - (timeStart / 1000)));
            }
        });
        thread.start();         // uruchomienie wątku -> "wykonanie metody run()"
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadController tc = new ThreadController();
        long timeStart = System.currentTimeMillis();
        Thread th1 = null, th2 = null, th3 = null;
        System.out.println("Wątek: " + Thread.currentThread().getName());
        tc.printNumbers(th1);
        tc.printNumbers(th2);
        tc.printNumbers(th3);
        System.out.println("Wątek: " +Thread.currentThread().getName());

    }
}
