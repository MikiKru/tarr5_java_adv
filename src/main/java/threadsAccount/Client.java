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
                Thread.sleep(new Random().nextInt(new Random().nextInt(1000)));
                int amount = new Random().nextInt((10) + 1) * 10;
                account.getOutcome(amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
