import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    private final int id;
    private final ReentrantLock locker = new ReentrantLock();
    private volatile Map<String, Double> balance = new ConcurrentHashMap<>();
    private final List<String> currency = new ArrayList<>(List.of("RUB","USD","EUR"));

    public Client(int id, List<Double> toBalance){
        this.id = id;
        int i = 0;
        for (String curr:currency){
            balance.put(curr,toBalance.get(i));
            ++i;
        }
    }

    public double getBalanceValue(String currency){
        return this.balance.get(currency);
    }

    public void getAvailableCurrencies(){
        System.out.print("Available currencies: ");
        System.out.println(this.currency);
    }

    public void deposit(double amount, String curr){
        locker.lock();
        try{
            this.balance.put(curr,balance.get(curr) + amount);
        } finally{
            locker.unlock();
        }
    }

    public void withdraw(double amount,String curr) throws Exception {
        locker.lock();
        try {
            if (amount > this.balance.get(curr)) {
                throw new Exception("Недостаточно средств на счёте!");
            } else {
                this.balance.put(curr, balance.get(curr) - amount);
            }
        } finally {
            locker.unlock();
        }
    }

    public void setBalance(double amount, String curr){
            locker.lock();
            try{
                this.balance.put(curr,amount);
            }
            finally{
                locker.unlock();
            }
        }
    public int getId(){
        return this.id;
    }
}
