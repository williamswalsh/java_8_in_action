package ie.williamswalsh.quiz.five_five;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class Domain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, Currency.getInstance("EUR")),
                new Transaction(raoul, 2012, 1000, Currency.getInstance("EUR")),
                new Transaction(raoul, 2011, 400, Currency.getInstance("EUR")),
                new Transaction(mario, 2012, 710, Currency.getInstance("EUR")),
                new Transaction(mario, 2012, 700, Currency.getInstance("EUR")),
                new Transaction(alan, 2012, 950, Currency.getInstance("EUR"))
        );

        // All 2011 transactions, sorted by value
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        // Unique cities where traders work
        transactions.stream()
                .map(Transaction::getTrader)                        // transaction -> transaction.getTrader().getCity()
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        // Find all traders from cambridge and sort by name
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()                                         // N.B. -> Many to one relationship -> Transaction-Trader
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);

        // Return a string of all traders names sorted alphabetically
        transactions.stream()
                .map(Transaction::getTrader)                        // Stream<Transaction> -> Stream<Trader>
                .map(Trader::getName)                               // Stream<Trader> -> Stream<String>
                .distinct()
                .sorted()
                .reduce(String::concat)                             // Stream<String> -> Optional<String>
                .ifPresent(System.out::println);

        // OR
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce(String::concat)                             // Stream<String> -> Optional<String>
                .ifPresent(System.out::println);

        // Are any traders from milan?
        System.out.println("Are any traders from milan? " +
                transactions.stream()
                        .map(Transaction::getTrader)
                        .anyMatch(t -> t.getCity().equalsIgnoreCase("Milan")));

        // OR
        System.out.println("Are any traders from milan? " +
                transactions.stream()
                        .anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan")));

        // Print all transactions values from traders living in Cambridge
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // Highest value of all transactions
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        // A)
        if(max.isPresent()){
            System.out.println(max.get());
        }

        // OR better yet
        // B)
        max.ifPresent(System.out::println);

        // find the transaction with the smallest value
        Optional<Transaction> minValueTransaction = transactions.stream()
                .reduce((a,b) -> a.getValue()<b.getValue()?a:b);

        minValueTransaction.ifPresent(System.out::println);
    }
}
