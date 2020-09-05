package ie.williamswalsh.quiz.five_three;

import static ie.williamswalsh.streams.restaurant.Restauraunt.menu;

public class Reducing {
    public static void main(String[] args) {
//        Count the number of dishes in a stream using only map & reduce
        System.out.println(menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum));
    }
}
