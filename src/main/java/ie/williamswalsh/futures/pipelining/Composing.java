package ie.williamswalsh.futures.pipelining;

import ie.williamswalsh.futures.Shop;
import ie.williamswalsh.futures.pipelining.Discount;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Composing {
    private static List<Shop> shops = Arrays.asList(
            new Shop("Lidl"),
            new Shop("Aldi"),
            new Shop("Tesco"),
            new Shop("Supervalu"));

    public List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.
                stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
