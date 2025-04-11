package katas;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class GreedTest {

    @Test
    public void test11() {
        assertEquals(200, Greed.greedy(new int[] {1,1}));
    }

    @Test
    public void test115() {
        assertEquals(250, Greed.greedy(new int[] {1,1,5}));
    }

    @Test
    public void test1515() {
        assertEquals(300, Greed.greedy(new int[] {1,5,1,5}));
    }

    @Test
    public void test111() {
        assertEquals(1000, Greed.greedy(new int[] {1,1,1}));
    }

    @Test
    public void test1115() {
        assertEquals(1050, Greed.greedy(new int[] {1,1,5,1}));
    }

    @Test
    public void test66611() {
        assertEquals(800, Greed.greedy(new int[] {1,6,1,6,6}));
    }

    @Test
    public void test33355() {
        assertEquals(400, Greed.greedy(new int[] {3,5,3,5,3}));
    }

    @Test
    public void test333553() {
        assertEquals(400, Greed.greedy(new int[] {3,5,3,5,3,3}));
    }

    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, Greed.greedy(new int[]{5,1,3,4,1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, Greed.greedy(new int[]{1,1,1,3,1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, Greed.greedy(new int[]{2,4,4,5,4}));
    }

}
