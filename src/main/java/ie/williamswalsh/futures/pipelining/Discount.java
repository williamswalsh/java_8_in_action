package ie.williamswalsh.futures.pipelining;

import java.util.Random;

public class Discount {

    public static void main(String[] args) {
        System.out.println(new Discount().getPrice("GameBoy"));
    }


    Random random = new Random();
    public enum Code {
        NONE(0),
        BRONZE(10),
        SILVER(20),
        GOLD(30),
        PLATINUM(40);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is: " + Discount.apply(quote.getPrice(), quote.getDiscountCode());

    }

    private static double apply(double price, Code code) {
        return (price * code.percentage) / 100;
    }

    private String getPrice(String product) {
        double price = calculatePrice("PS5");
        Discount.Code code = Code.values()[random.nextInt(Code.values().length)];
        return String.format("%s:%.2f:%s",product, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return 2344.8706 * 234.00;
    }

    private void delay() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
