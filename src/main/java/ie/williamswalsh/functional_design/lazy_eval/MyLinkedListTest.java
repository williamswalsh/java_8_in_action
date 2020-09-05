package ie.williamswalsh.functional_design.lazy_eval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyLinkedListTest {

    @Test
    public void testMyLinkedListConstructor() {
        MyList<Integer> sampleList = new MyLinkedList<>(5, new MyLinkedList<>(10,new Empty<>()));
        assertEquals(sampleList.head(), new Integer(5));
        assertNotEquals(sampleList.head(), new Integer(10));
    }

}
