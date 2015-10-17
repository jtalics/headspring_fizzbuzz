package jtal;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;

import jtal.FizzBuzzService.Alert;

import org.junit.*;

/**
 * Purpose: test FizzBuzz
 */
public class TestFizzBuzzService {

    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    public TestFizzBuzzService() {
        fizzBuzzService.startUp();
    }

    public static void main(String[] args) {
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
    public void testBiggerStress() throws Exception {
        fizzBuzzService.setStart(new BigInteger("1"));
        fizzBuzzService.setStop(new BigInteger("10000")); // BigNumber does not allow underscores yet
        fizzBuzzService.setFizz(new BigInteger("31"));
        fizzBuzzService.setBuzz(new BigInteger("33"));
        List<Alert> alerts = fizzBuzzService.getAlerts();
        assertEquals(alerts.hashCode(),665122447);
    }

    @Test
    public void testValidation() throws Exception {
        fizzBuzzService.setStart(new BigInteger("10"));
        fizzBuzzService.setStop(new BigInteger("1"));
        fizzBuzzService.validateParamValues(); // throws exception since stop < start
    }

    @Test
    public void testArrayListOverflow() throws Exception {
        // Test to ensure that a LinkedList is returned if the number of values that will be generated
        // is greater than Integer.MAX_VALUE
    }
}
