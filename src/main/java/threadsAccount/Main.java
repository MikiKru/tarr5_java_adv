package threadsAccount;

public class Main {
    public static void main(String[] args) {
        // jeden rachunek i dwie karty
        Account a1 = new Account("0000-0000-0000-0000", 1000);
        Thread th1 = new Thread(new Client(a1));
        Thread th2 = new Thread(new Client(a1));
        Thread th3 = new Thread(new Client(a1));
        th1.start();
        th2.start();
        th3.start();
    }
}
