package ie.williamswalsh.futures.pipelining;

public class Quote {
    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * This method takes a Quote String as an argument it then constructs and returns a Quote Object to the caller.
     *
     * Quote String:
     * format: "<SHOP_NAME>:<PRICE>:<DISCOUNT_CODE>"
     * sample: "Patagonia  :245.99 : PLATINUM      "
     *
     * @param quoteStr A String which needs to be parsed to construct a Quote object
     * @return A Quote object with the name, price and code of the parsed Quote String
     */
    public static Quote parse(String quoteStr) {
        String[] parts = quoteStr.split(":");

        String shopName = parts[0];
        double price = Double.parseDouble(parts[1]);
        Discount.Code code = Discount.Code.valueOf(parts[2]);
        return new Quote(shopName, price, code);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
