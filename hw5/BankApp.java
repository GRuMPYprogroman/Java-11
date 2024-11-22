import java.util.ArrayList;
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Logger logger = new Logger();
        bank.addObserver(logger);

        Client client1 = new Client(1, new ArrayList<>(List.of(1000.0,50.0,25.0)));
        Client client2 = new Client(2, new ArrayList<>(List.of(50000.0,150.0,725.0)));
        bank.addClient(client1);
        bank.addClient(client2);

        bank.exchangeCurrency(1, "USD", "EUR", 30);
        bank.transferFunds(2, 1, 50,"USD");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.turnOff();
        System.out.println("Спасибо, что пользуетесь нашим приложением!");
    }
}
