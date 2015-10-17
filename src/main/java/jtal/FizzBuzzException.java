package jtal; /**
 * Created by user1 on 7/30/2015.
 */

/**
 * Purpose: provide an explicit exeption class.   As FizzBuzz project grows, this becomes more useful
 */
public class FizzBuzzException extends Exception {

    public FizzBuzzException(String message) {
        super(message);
    }
}
