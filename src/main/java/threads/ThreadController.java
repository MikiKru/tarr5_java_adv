package threads;

import java.util.*;

public class ThreadController {
    Deque<Integer> numbers = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    // metoda implementująca wątek wypisujący wszystkie liczby
    public void printNumbers(){
        // utworzenie klasy anonimowej
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!numbers.isEmpty()) {
                    try {
                        Thread.currentThread().sleep(new Random().nextInt(6) * 1000);     // uśpienie wąktu thread na 1s
                        System.out.println("Wątek: " + Thread.currentThread().getName() +
                                " - wartość: " + numbers.removeFirst() +
                                " aktualna zawartość: " + numbers);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } } }
        });
        thread.start();         // uruchomienie wątku -> "wykonanie metody run()"
    }
    public static void main(String[] args) {
        ThreadController tc = new ThreadController();
        System.out.println("Wątek: " + Thread.currentThread().getName());
        tc.printNumbers();
        tc.printNumbers();
        tc.printNumbers();
        System.out.println("Wątek: " +Thread.currentThread().getName());

    }
}
