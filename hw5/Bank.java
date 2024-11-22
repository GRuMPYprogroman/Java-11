import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Bank{
    private final Map<String, Double> exchangeRates = new ConcurrentHashMap<>();
    private final Queue<Runnable> transactionQueue = new LinkedBlockingQueue<>();
    private final List<Observer> observers = new ArrayList<>();
    private final Map<Integer,Client> clients = new ConcurrentHashMap<>();
    private final ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public Bank() {

        exchangeRates.put("USD",1.0);
        exchangeRates.put("EUR",1.05);
        exchangeRates.put("RUB",101.0);

        scheduler.scheduleAtFixedRate(() -> {
            for (String currency:exchangeRates.keySet()){
                    exchangeRates.put(currency,exchangeRates.get(currency) *(Math.random() * 0.4 + 0.8));
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers(String message) {
        for (Observer o: observers) {
            o.update(message);
        }
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
    }

    public void exchangeCurrency(int clientId, String fromCurrency, String toCurrency, double amount) {
        transactionQueue.add(() -> {
            try {
                Client curr_client = clients.get(clientId);
                if (curr_client.getBalanceValue(fromCurrency) >= amount) {
                    double rateFrom = exchangeRates.get(fromCurrency);
                    double rateTo = exchangeRates.get(toCurrency);
                    double convertedAmount = amount * rateFrom / rateTo;

                    curr_client.withdraw(amount, fromCurrency);
                    curr_client.deposit(convertedAmount, toCurrency);
                    notifyObservers("Обмен валют для клиента " + clientId + ": " + amount + " " + fromCurrency + " -> " + convertedAmount + " " + toCurrency);
                } else {
                    throw new Exception("Недостаточно средств для конвертации");
                }
            } catch (Exception e) {
                notifyObservers("Ошибка обмена валют: " + e.getMessage());
            }
        });
        executor.submit(new Cashier());

    }

    void transferFunds(int senderId, int receiverId, double amount, String sendingCurrency) {
        transactionQueue.add(() -> {
            try {
                if (senderId == receiverId) {
                    throw new Exception("Попытка отправить самому себе");
                }
                Client fromClient = clients.get(senderId);
                Client toClient = clients.get(receiverId);
                fromClient.withdraw(amount, sendingCurrency);
                toClient.deposit(amount, sendingCurrency);
                notifyObservers("Перевод средств: от " + senderId + " к " + receiverId + " сумма " + amount + " " + sendingCurrency);
            } catch (Exception e) {
                notifyObservers("Ошибка обмена валют: " + e.getMessage());
            }
        });
        executor.submit(new Cashier());
    }


    class Cashier implements Runnable {
        @Override
        public void run() {
            try {
                Runnable transaction = transactionQueue.poll();
                if (transaction != null) {
                    System.out.println("Транзакцию выполнит поток: " + Thread.currentThread().getName());
                    transaction.run();
                }
            } catch (Exception e) {
                notifyObservers("Ошибка обработки транзакции: " + e.getMessage());
            }
        }
    }
    public void turnOff()
    {
        scheduler.shutdown();
        executor.shutdown();
    }
}
