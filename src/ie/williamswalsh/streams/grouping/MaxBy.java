package ie.williamswalsh.streams.grouping;

import ie.williamswalsh.quiz.five_five.Transaction;
import ie.williamswalsh.quiz.five_five.TransactionData;
import ie.williamswalsh.streams.restaurant.Dish;
import ie.williamswalsh.streams.restaurant.Restauraunt;

import java.util.Currency;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class MaxBy {

    public enum CaloricLevel { DIET, NORMAL, FAT }

    public static void main(String[] args) {

        // group transactions by currency then count the number of instances in that group
        Map<Currency, Long> map = TransactionData.transactions.stream()
                .collect(groupingBy(Transaction::getCurrency, counting()));
        System.out.println(map);

        // group transactions by currency then find the largest transaction in that group by comparing the Transaction value integer
        Map<Currency, Optional<Transaction>> map2 = TransactionData.transactions.stream()
                .collect(groupingBy(Transaction::getCurrency, maxBy(comparingInt(Transaction::getValue))));

        System.out.println(map2);

        // group transactions by currency then find the largest transaction in that group by comparing the Transaction value integer
        // then unwrap the Optional using .get()
        Map<Currency, Transaction> map3 = TransactionData
                .transactions.stream()
                .collect(groupingBy(Transaction::getCurrency, collectingAndThen(maxBy(comparingInt(Transaction::getValue)), Optional::get)));

        System.out.println(map3);


        Map<Dish.Type, Set<CaloricLevel>> map4 = Restauraunt.menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping(
                        dish -> {
                            if( dish.getCalories() < 200)
                                return CaloricLevel.DIET;
                            else if( dish.getCalories() < 500)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                },toSet() )));

        System.out.println(map4);


    }
}
