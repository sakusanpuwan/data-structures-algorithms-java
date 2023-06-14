package Test;

import Katas.BitCounting;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class BitCountingTest {


    @Test
    public void checkIntToBits(){
        assertEquals(5,BitCounting.countBits(1234));
    }
}
