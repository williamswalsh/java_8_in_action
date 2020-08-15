package ie.williamswalsh.testing;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsefulTestCode {

    public static void main(String[] args) {


    }
    @Test
    void myTest(){
        assertEquals(4, 2+2, "The output should sum to 4");
    }

    @Test
    void mySecondTest(){
        assertEquals(4, 2*2, "The output should multiply to 4");
    }

    // Can use assertEquals() with Lists of Objects with equals() methods defined
}

class Point{
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Creates a comparator which compares one aspect(X-axis) then another aspect(Y-axis)
    Comparator<Point> compareByXThenY = Comparator.comparing(Point::getX).thenComparing(Point::getY);
}