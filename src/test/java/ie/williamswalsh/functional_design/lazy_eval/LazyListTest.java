package ie.williamswalsh.functional_design.lazy_eval;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazyListTest {

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n+1));
    }

    @Test
    void testLazyListMethods() {
        LazyList<Integer> nums = from(2);
        assertEquals(2, nums.head());
        assertEquals(3, nums.tail().head());
        assertEquals(4, nums.tail().tail().head());
    }
}