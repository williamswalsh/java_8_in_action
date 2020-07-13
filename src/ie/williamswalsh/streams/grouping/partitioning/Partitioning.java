package ie.williamswalsh.streams.grouping.partitioning;

import ie.williamswalsh.quiz.five_five.Transaction;
import ie.williamswalsh.quiz.five_five.TransactionData;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class Partitioning {
    public static void main(String[] args) {
        // Partitioning is a special type of grouping where there is a predicate
        // which separates the elements into 2 groups (true/false)
        Map<Boolean, List<Transaction>> transPartitionedByValue =  TransactionData
                .transactions
                .stream()
                .collect(partitioningBy((t)-> t.getValue() < 400));

        List<Transaction> biggerTransactions = transPartitionedByValue.get(false);
        for (Transaction t: biggerTransactions) {
            System.out.println(t.getValue());
        }

    }
}
