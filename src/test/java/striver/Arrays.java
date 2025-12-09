package striver;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Arrays {

    @Test
    void find(){
        Assertions.assertArrayEquals(new int[] {2,5}, striversA2Z.Arrays.findSecondSmallestAndLargest(new int[] {1, 2, 4, 7, 7, 5}));
        assertEquals(true, striversA2Z.Arrays.isSorted(new int[] {1,2,3,4,5}));
        assertEquals(false, striversA2Z.Arrays.isSorted(new int[] {5,4,6,7,8}));
    }
}
