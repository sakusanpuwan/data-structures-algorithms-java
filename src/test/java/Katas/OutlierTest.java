package Katas;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class OutlierTest {

    @Test
    public void testOddArray(){
        assertEquals(160, FindOutlier.find(new int[] {160, 3, 1719, 19, 11, 13, -21}));
    }

    @Test
    public void testExample() {
        int[] exampleTest1 = {2,6,8,-10,3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, FindOutlier.find(exampleTest1));
        assertEquals(206847684, FindOutlier.find(exampleTest2));
        assertEquals(0, FindOutlier.find(exampleTest3));
    }
}
