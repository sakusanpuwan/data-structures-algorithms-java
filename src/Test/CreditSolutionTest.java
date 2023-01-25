package Test;
import Katas.Maskify;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class CreditSolutionTest {
    @Test
    public void testSolution() {
        assertEquals("############5616", Maskify.maskify("4556364607935616"));
        assertEquals("#######5616",      Maskify.maskify(     "64607935616"));
        assertEquals("1",                Maskify.maskify(               "1"));
        assertEquals("",                 Maskify.maskify(                ""));

        // "What was the name of your first pet?"
        assertEquals("##ippy",                                    Maskify.maskify("Skippy")                                  );
        assertEquals("####################################man!",  Maskify.maskify("Nananananananananananananananana Batman!"));
    }
}
