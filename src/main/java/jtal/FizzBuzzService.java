package jtal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Purpose: provide a generic service to find all integers in a range that is divisible by a specified integer
 * We make this architecture general to accomodate the customer broadening requiremetns later
 */
public class FizzBuzzService {

    // TODO: put in a logging service like SLF or log4j

    public static enum Alert {
        None,  // divisible by neither fizz nor buzz (e.g. prime number)
        Fizz,  // divisible by fizz
        Buzz,  // divisible by buzz
        FizzBuzz; // divisible by both fizz and buzz
    }

    // TODO: in the future we might want to make this class generic, i.e. jtal.FizzBuzzService<T>
    // so that it would handle Integer or Short if that is al it needed to do, thus making performant
    private BigInteger start = new BigInteger("0");
    private BigInteger stop = new BigInteger("0");
    private BigInteger fizz = new BigInteger("0");
    private BigInteger buzz = new BigInteger("0");
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger ZERO = new BigInteger("0");
    private static final BigInteger INT_MAX_VALUE = new BigInteger(String.valueOf(Integer.MAX_VALUE));

    public FizzBuzzService() {

    }

    public FizzBuzzService(BigInteger start, BigInteger stop, BigInteger fizz, BigInteger buzz) {

        this.start = start;
        this.stop = stop;
        this.fizz = fizz;
        this.buzz = buzz;
    }

    public List<Alert> getAlerts () throws FizzBuzzException {

        validateParamValues();

        // NOTE: future versions might utilize multithreading, especially if there are many cheap CPU's available.

        // Now, select best type of list to use.
        // ArrayList can only hold a finite number of values while
        // Linked list can hold infinite, bounded only by memory
        // If the range is larger than Integer.MAX_VALUE, Array list will fail
        final List<Alert> list;
        BigInteger rangeSize = stop.subtract(start);
        if (rangeSize.compareTo(INT_MAX_VALUE) <= 0) {
            list = new ArrayList<Alert>(rangeSize.intValue()) {
                @Override
                public boolean equals(Object o) {
                    // TODO: increase ability to discriminate here
                    return super.equals(o);
                }

                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
        }
        else {
            list = new LinkedList<Alert>(){
                @Override
                public boolean equals(Object o) {
                    // TODO: increase ability to discriminate here
                    return super.equals(o);
                }

                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
        }
        for (BigInteger i = start; i.compareTo(stop) != 1; i=i.add(ONE) ) {
            Alert alert;
            // NOTE: many math concepts could be applied.  For example, it might be faster to
            // find the first divisible integer above startUp and continue adding fizz and or buzz until greater than
            // stop.  This might be a little faster than a for-loop, need to experiment.  But for now Keep It Simple
            if (i.mod(fizz).compareTo(ZERO) == 0) {
                if (i.mod(buzz).compareTo(ZERO) == 0) {
                    list.add(Alert.FizzBuzz);
                }
                else {
                    list.add(Alert.Fizz);
                }
            }
            else if (i.mod(buzz).compareTo(ZERO) == 0) {
                if (i.mod(fizz).compareTo(ZERO) == 0) {
                    list.add(Alert.FizzBuzz);
                } else {
                    list.add(Alert.Buzz);
                }
            }
            else {
                list.add(Alert.None);
            }
        }
        return list;
    }


    public void validateParamValues() throws FizzBuzzException {
        // Check for bad input values
        if (start.compareTo(stop) == 1) {
            throw new FizzBuzzException("startUp >= stop");
        }
        if (fizz.compareTo(ZERO) == 0) {
            throw new FizzBuzzException("fizz is zero");
        }
        if (buzz.compareTo(ZERO) == 0) {
            throw new FizzBuzzException("buzz is zero");
        }

    }

    public BigInteger getStart() {
        return start;
    }

    public void setStart(BigInteger start) {
        this.start = start;
    }

    public BigInteger getStop() {
        return stop;
    }

    public void setStop(BigInteger stop) {
        this.stop = stop;
    }

    public BigInteger getFizz() {
        return fizz;
    }

    public void setFizz(BigInteger fizz) {
        this.fizz = fizz;
    }

    public BigInteger getBuzz() {
        return buzz;
    }

    public void setBuzz(BigInteger buzz) {
        this.buzz = buzz;
    }

    public void startUp() {
        // put in a hook to write to log for audits or to "warm up" DB connections, etc
        System.out.println("Starting up jtal.FizzBuzzService");
    }

    public void init() {
        System.out.println("Initializing FizzBuzz for test");
    }

    public void done() {
        System.out.println("Done with FizzBuzz for test");
    }

    public void shutdown() {
        // put in a hook to write to log for audits or hint System.gc() or the like
        System.out.println("Shutting down jtal.FizzBuzzService");
    }

    public static void main(String[] args) {
    }
}
