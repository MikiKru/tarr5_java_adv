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
        int i = 30;
        while(i >= 0){      // pętla wykona się i razy
            try {
                Thread.sleep(new Random().nextInt(new Random().nextInt(1000)));
                int amount = new Random().nextInt((10) + 1) * 10;       // kwota wpłaty lub wypłaty z konta
                int decision = new Random().nextInt(2);            // zmienna decydująca o wpłacie lub wypłacie
                if(decision == 0) {
                    account.getOutcome(amount);                         // wypłata z konta
                } else {
                    account.addIncome(amount/2);                 // wpłata na konto
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i --;
        }
    }
}
