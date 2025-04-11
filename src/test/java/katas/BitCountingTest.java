package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCountingTest {


    @Test
    public void checkIntToBits(){
        assertEquals(5,BitCounting.countBits(1234));
    }
}
