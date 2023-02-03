package Test;
import static org.junit.Assert.*;

import Katas.Printer;
import org.junit.Test;


public class PrinterTest {
    @Test
    public void test1() {
        assertEquals("3/56", Printer.printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
    }

    @Test
    public void test2() {
        assertEquals( "8/22", Printer.printerError("aaaxbbbbyyhwawiwjjjwwm"));
    }

}