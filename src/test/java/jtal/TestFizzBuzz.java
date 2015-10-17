package jtal;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;

import jtal.FizzBuzzService.Alert;

import org.junit.*;

/**
 * Purpose: test FizzBuzz
 */
public class TestFizzBuzz {

    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    public TestFizzBuzz() {
        fizzBuzzService.startUp();
    }

    @BeforeClass
    public static void beforeClass() throws FizzBuzzException {
        // Executed once before all tests (when this class is instantiatied)
    }

    @Before
    public void before() throws Exception {
        // Executed before each test
        fizzBuzzService.init();
    }

    @After
    public void after() throws Exception {
        // executed after a test run
        fizzBuzzService.done();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        // executed after all test run (JUnit determines this)
    }

    @Test
    public void testBasicFizzBuzz() throws Exception {
        // Try the service exactly as in requirements
        // Don't test the View
        System.out.println("STARTING FIZZBUZZ");
        FizzBuzzService fizzBuzzService = new FizzBuzzService(
                new BigInteger(String.valueOf("1")),
                new BigInteger(String.valueOf("100")),
                new BigInteger(String.valueOf("3")),
                new BigInteger(String.valueOf("5"))
        );

        List<Alert> alerts = fizzBuzzService.getAlerts();
        // use hashcode to do a rough test
        assertEquals(alerts.hashCode(),-915796294);
    }

    @Test
    public void testArrayListOverflow() throws Exception {
        // Test to ensure that a LinkedList is returned if the number of values that will be generated
        // is greater than Integer.MAX_VALUE
    }

    public static void main(String[] args) {
    }
}
