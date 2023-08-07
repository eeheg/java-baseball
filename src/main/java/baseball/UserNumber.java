package baseball;

import java.util.*;

//같은 패키지 내에서만 접근 가능한 default class
class UserNumber extends Number {
    int number = getUserNumberWithValidation();

    //같은 패키지 내에서만 접근 가능한 default getter
    List<Integer> getUserNumber() {
        return splitDigitsToArray(number);
    }

    // UserNumber 클래스 내에서만 사용하는 메서드들은 private!
    private int scanUserInput() {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanUserNumber = new Scanner(System.in);
        return scanUserNumber.nextInt();
    }

    private int getUserNumberWithValidation() throws IllegalArgumentException {
        int userNumber = scanUserInput();
        if (!isValidNumber(userNumber)) {
//          [문제 요구사항] System.exit() 를 사용하지 않고 종료시킬 것.
//          => 현 메소드에서 던진 e를 Application.java 의 main 함수에서 받는다.
//          => main 함수가 종료된다.
            IllegalArgumentException e = new IllegalArgumentException("잘못된 값을 입력하여 프로그램이 종료됩니다.");
            System.out.println(e.getMessage());
            throw e;
        }
        return userNumber;
    }

}
