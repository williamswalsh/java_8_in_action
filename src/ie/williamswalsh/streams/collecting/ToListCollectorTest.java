package ie.williamswalsh.streams.collecting;

import ie.williamswalsh.quiz.five_five.Transaction;
import ie.williamswalsh.quiz.five_five.TransactionData;

import java.util.Currency;
import java.util.List;

public class ToListCollectorTest {
    public static void main(String[] args) {
        List<Transaction> transactionsInEuro = TransactionData.transactions
                .stream()
                .filter(t -> t.getCurrency() == Currency.getInstance("EUR"))
                .collect(new ToListCollector<Transaction>());

        for (Transaction t :transactionsInEuro) {
            System.out.println(t);
        }
    }
}
