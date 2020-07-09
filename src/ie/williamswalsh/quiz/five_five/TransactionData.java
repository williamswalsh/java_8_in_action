package ie.williamswalsh.quiz.five_five;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class TransactionData {
    public static Trader raoul;
    public static Trader mario;
    public static Trader alan;
    public static Trader brian;
    public static List<Transaction> transactions;

    static {
        raoul = new Trader("Raoul", "Cambridge");
        mario = new Trader("Mario", "Milan");
        alan = new Trader("Alan", "Cambridge");
        brian = new Trader("Brian", "Cambridge");
        transactions=Arrays.asList(
            new Transaction(brian, 2011, 300, Currency.getInstance("EUR")),
            new Transaction(raoul, 2012, 1000, Currency.getInstance("EUR")),
            new Transaction(raoul, 2011, 400, Currency.getInstance("EUR")),
            new Transaction(mario, 2012, 710, Currency.getInstance("EUR")),
            new Transaction(mario, 2012, 700, Currency.getInstance("EUR")),
            new Transaction(alan, 2012, 950, Currency.getInstance("EUR")));
    }
}
