package baseball;

import java.util.*;

abstract class Number {
    static final int NUMBER_MIN = 100;
    static final int NUMBER_MAX = 999;

    public List<Integer> splitDigitsToArray(int number) {
        List<Integer> digitsOfNumber = new ArrayList<>();
        while(number > 0) {
            digitsOfNumber.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(digitsOfNumber);
        return digitsOfNumber;
    }

}
