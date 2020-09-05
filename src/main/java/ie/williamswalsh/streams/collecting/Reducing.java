package ie.williamswalsh.streams.collecting;

import ie.williamswalsh.quiz.five_five.Transaction;
import ie.williamswalsh.quiz.five_five.TransactionData;

import java.util.List;

public class Reducing {
    public static void main(String[] args) {

        // A
        // Note the Optional<T>.get() method at end -> single argument reduce returns an Optional<T>
        int sumOfValues = TransactionData.transactions.stream().map(Transaction::getValue).reduce(Integer::sum).get();
        System.out.println("Sum of Transaction Values: " + sumOfValues);

        // B
        // Using IntStream
        int sumOfValuesADiffWay = TransactionData.transactions.stream().mapToInt(Transaction::getValue).sum();  // Doesn't return Optional
        System.out.println("Sum of Transaction Values: " + sumOfValuesADiffWay);

        // Optional.get()
        //      .orElse()
        //      .orElseGet()



    }
}
