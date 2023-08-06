package baseball;

import java.util.*;

//같은 패키지 내에서만 접근 가능한 default class
class ComputerNumber extends Number {
    //한 게임당 하나로 지정되는 computerNumber 는 private final 로 상수처리하여 재정의를 방지한다.
    private final int number = (int)(Math.random() * (NUMBER_MAX - NUMBER_MIN)) + NUMBER_MIN;

    //같은 패키지 내에서만 접근 가능한 default getter
    List<Integer> getComputerNumber() {
        System.out.println("( 컴퓨터 랜덤숫자 생성: " + number + " )\n");
        return splitDigitsToArray(number);
    }

}
