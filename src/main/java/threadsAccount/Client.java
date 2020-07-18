package threadsAccount;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Client implements Runnable {
    private Account account;
    @Override
    public void run() {
        while(account.getAccountSaldo() > 0){
            try {
                Thread.sleep(new Random().nextInt(500));
                int amount = new Random().nextInt(100) + 1;
                System.out.println("Wątek: " + Thread.currentThread().getName());
                System.out.printf("Wypłacam z rachunku %s kwotę: %.2fzł\n",
                        account.getAccountNumber(),
                        Double.valueOf(amount));
                Thread.sleep(new Random().nextInt(500));
                account.getOutcome(amount);
                System.out.printf("Aktualne saldo dla rachunku %s : %.2fzł\n",
                        account.getAccountNumber(),
                        Double.valueOf(account.getAccountSaldo()));

                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
