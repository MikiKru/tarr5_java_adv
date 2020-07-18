package threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadController {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(2,3,1,4,3,4,5,3));

    // metoda implementująca wątek wypisujący wszystkie liczby
    public void printNumbers(){
        Runnable target;
        // utworzenie klasy anonimowej
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer number : numbers) {
                    try {
                        Thread.currentThread().sleep(1000);     // uśpienie wąktu thread na 1s
                        System.out.println("Wątek: " + Thread.currentThread().getName());
                        System.out.println(number);
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
        System.out.println("Wątek: " +Thread.currentThread().getName());

    }
}
