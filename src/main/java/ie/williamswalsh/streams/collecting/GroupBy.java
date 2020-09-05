package ie.williamswalsh.streams.collecting;

import ie.williamswalsh.quiz.five_five.Trader;
import ie.williamswalsh.quiz.five_five.Transaction;


import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupBy {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300, Currency.getInstance("AUD")),
                new Transaction(raoul, 2012, 1000, Currency.getInstance("EUR")),
                new Transaction(raoul, 2011, 400, Currency.getInstance("JPY")),
                new Transaction(mario, 2012, 710, Currency.getInstance("AUD")),
                new Transaction(mario, 2012, 700, Currency.getInstance("EUR")),
                new Transaction(alan, 2012, 950, Currency.getInstance("USD")));

        Map<Currency, List<Transaction>> transactionsByCurrencies = transactionList.stream().collect(groupingBy(Transaction::getCurrency));
    }
}
