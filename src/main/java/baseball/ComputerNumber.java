package baseball;

import java.util.*;

public class ComputerNumber extends Number {
    int number = (int)(Math.random() * (NUMBER_MAX - NUMBER_MIN)) + NUMBER_MIN;

    List<Integer> getComputerNumber() {
        System.out.println("( 컴퓨터 랜덤숫자 생성: " + number + " )");
        return splitDigitsToArray(number);
    }

}
