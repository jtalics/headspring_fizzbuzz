package jtal;

import jtal.FizzBuzzService.Alert;

import java.math.BigInteger;
import java.util.List;
/**
 * Purpose: use the FizzBuzz service to satizfy the exact requirements:
 * Print out the numbers from 1 to 100. If the number is divisible by 3, print "Fizz"
 * instead.if by 5, print "Buzz." If by both, print "FizzBuzz."
 */
public class FizzBuzz {

    private static final int start = 1;
    private static final int stop = 100;
    private static final int fizz = 3;
    private static final int buzz = 5;

    public FizzBuzz() {
    }


    private void viewAlerts(List<Alert> alerts) {
        System.out.println("FIZZ BUZZ REPORT");
        System.out.println(this.toString());
        int i=start;
        for (Alert alert : alerts) {
            System.out.println((i++)+":"+alert.name());
        }
        System.out.println("E N D  O F  R E P O R T");
    }

    public static void main(String[] args) throws FizzBuzzException {

        System.out.println("STARTING FIZZBUZZ");
        FizzBuzzService fizzBuzzService = new FizzBuzzService(
                new BigInteger(String.valueOf(start)),
                new BigInteger(String.valueOf(stop)),
                new BigInteger(String.valueOf(fizz)),
                new BigInteger(String.valueOf(buzz))
        );

        List<Alert> alerts = fizzBuzzService.getAlerts();
        new FizzBuzz().viewAlerts(alerts);

    }

    @Override
    public String toString() {
        return "[start="+start+";stop="+stop+";fizz="+fizz+";buzz="+buzz+"]";

    }

}
