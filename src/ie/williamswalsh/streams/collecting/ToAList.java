package ie.williamswalsh.streams.collecting;

import ie.williamswalsh.quiz.five_five.Transaction;
import ie.williamswalsh.quiz.five_five.TransactionData;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ToAList {
    public static void main(String[] args) {

        // Collect the transactions into a list
        List<Transaction> transactionList = TransactionData.transactions.stream().collect(Collectors.toList());

        // Counting
        long noOfTransactions  = TransactionData.transactions.stream().collect(Collectors.counting());
        long noOfTransactions2 = TransactionData.transactions.stream().count();

        // sum the ints
        TransactionData.transactions.stream().collect(summingInt(Transaction::getValue));

        // avg the ints
        TransactionData.transactions.stream().collect(averagingInt(Transaction::getValue));

        // Gets stats on stream
        // avg, max, min, count & sum
        TransactionData.transactions.stream().collect(summarizingInt(Transaction::getValue));

        //
//        String values = TransactionData.transactions.stream().map(Transaction::).collect(joining());

    }
}
