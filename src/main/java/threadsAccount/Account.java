package threadsAccount;

import lombok.AllArgsConstructor;
import lombok.Data;

// klasa modelu
@Data
@AllArgsConstructor
public class Account {
    private String accountNumber;
    private double accountSaldo;

    public void addIncome(double amount){
        this.accountSaldo += amount;
    }
    public void getOutcome(double amount){
        if(amount <= accountSaldo) {
            System.out.println(Thread.currentThread().getName() + " wypłata: " + amount + " zł");
            this.accountSaldo -= amount;
        } else {
            System.out.println("Operacja niemożliwa do zrealizowania:");
        }
        System.out.println(Thread.currentThread().getName() + " aktualne saldo: " + accountSaldo);
    }
}