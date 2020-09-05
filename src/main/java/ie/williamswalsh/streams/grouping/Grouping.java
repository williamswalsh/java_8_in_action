package ie.williamswalsh.streams.grouping;

import ie.williamswalsh.quiz.five_five.Trader;
import ie.williamswalsh.quiz.five_five.Transaction;
import ie.williamswalsh.quiz.five_five.TransactionData;
import ie.williamswalsh.streams.restaurant.Dish;
import ie.williamswalsh.streams.restaurant.Restauraunt;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

// Not working as expected
// Printout doesn't group 2 raoul transactions ??
public class Grouping {
    public enum TransactionGroup { SMALL, MEDIUM, LARGE }
    public enum CaloricLevel { DIET, NORMAL, FAT }
    public static void main(String[] args) {
        Map<Trader, Map<TransactionGroup, List<Transaction>>> traderTransLevelMap = TransactionData.transactions.stream()
                .collect(groupingBy(Transaction::getTrader,
                         groupingBy(t -> {
                             if (t.getValue() < 200)
                                 return TransactionGroup.SMALL;
                             else if (t.getValue() < 1000)
                                 return TransactionGroup.MEDIUM;
                             else
                                 return TransactionGroup.LARGE;
                         })));
        System.out.println(traderTransLevelMap);


        // Example in book
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Restauraunt.menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() < 200)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() < 1000)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        })));

        System.out.println(dishesByTypeCaloricLevel);
    }
}
