package baseball;

import java.util.*;

public class UserNumber extends Number {
    int number = getUserNumberWithValidation();

    List<Integer> getUserNumber() {
        return splitDigitsToArray(number);
    }

    int scanUserInput() {
        System.out.print("숫자를 입력하세요 : ");
        Scanner userNumber = new Scanner(System.in);
        return userNumber.nextInt();
    }

    int getUserNumberWithValidation() {
        int userNumber = scanUserInput();
        try {
            if (!isValidNumber(userNumber)) {
                throw new IllegalArgumentException("잘못된 값을 입력하여 프로그램이 종료됩니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return userNumber;
    }

    boolean isValidNumber(int number) {
        return number >= NUMBER_MIN && number <= NUMBER_MAX;
    }
}
