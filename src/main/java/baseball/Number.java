package baseball;

import java.util.*;

//같은 패키지 내에서만 접근 가능한 default class
class Number {
    //private 쓰면 상속에서 못받으니까 default로 상수 선언
    //final : 상수처리 + 오버라이딩 재정의 방지
    static final int NUMBER_MIN = 100;
    static final int NUMBER_MAX = 999;

    //같은 패키지 내에서만 접근 가능한 default 메서드 + 상속 부모클래스
    // => 인스턴스를 생성하지 않으면 같은 패키지 내의 자손만 사용 가능하다.
    List<Integer> splitDigitsToArray(int number) {
        List<Integer> digitsOfNumber = new ArrayList<>();
        while(number > 0) {
            digitsOfNumber.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(digitsOfNumber);
        return digitsOfNumber;
    }

    boolean isValidNumber(int number) {
        return number >= NUMBER_MIN && number <= NUMBER_MAX;
    }

}
