package katas;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ProdFibTest {

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }
    @Test
    public void test3() {
        long[] r = new long[] {21, 34, 1};
        assertArrayEquals(r, ProdFib.productFib(714));
    }
    @Test
    public void test4() {
        long[] r = new long[] {34, 55, 0};
        assertArrayEquals(r, ProdFib.productFib(800));
    }
}