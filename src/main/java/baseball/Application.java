package baseball;

import java.util.*;


public class Application {

    public static final int GAMEOVER_STRIKE = 3;
    public static final int NUMBER_LENGTH = 3;

    static int createRandomNumber() {
        // 100~999 숫자 랜덤출력
        int randomNumber = (int)(Math.random() * 900) + 100;
        System.out.println("컴퓨터 랜덤숫자 생성: " + randomNumber);
        return randomNumber;
    }

    static boolean isThreeDigits (int number) {
        return number > 99 && splitDigitsToArray(number).size() == NUMBER_LENGTH;
    }

    //scanner로 유저가 제안하는 숫자 받기
    static int ScanUserNumber() {
        int userNumber = 0;
        try {
            System.out.print("숫자를 입력하세요 : ");
            Scanner scanUserNumber = new Scanner(System.in);
            userNumber = scanUserNumber.nextInt();
            if (!isThreeDigits(userNumber)) {
                throw new IllegalArgumentException("잘못된 값을 입력하여 프로그램이 종료됩니다.");
            }
            return userNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
            return 0;   //?????
        }
    }

    //세자리 숫자의 각 자리수를 배열로 만들기
    static List<Integer> splitDigitsToArray (int number) {
        List<Integer> digitsOfNumber = new ArrayList<>();
        while(number > 0) {
            digitsOfNumber.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(digitsOfNumber);
        return digitsOfNumber;
    }

    //Strike(스트라이크) 카운팅
    static int countStrike(List<Integer> digitsOfUserNumber, List<Integer> digitsOfRandomNumber) {
        int strike = 0;
        for (int index = 0; index < digitsOfUserNumber.size(); index++) {
            if (digitsOfUserNumber.get(index) == digitsOfRandomNumber.get(index)) {
                strike++;
            }
        }
        return strike;
    }

    //Ball(볼) 카운팅
    static int countBall(List<Integer> digitsOfUserNumber, List<Integer> digitsOfRandomNumber) {
        int ball = 0;
        for (int index = 0; index < digitsOfUserNumber.size(); index++) {
            if (digitsOfUserNumber.get(index) == digitsOfRandomNumber.get(index)) {
                continue;
            }
            if (digitsOfRandomNumber.contains(digitsOfUserNumber.get(index))) {
                ball++;
            }
        }
        return ball;
    }

    //nothing(낫싱) 여부 true, false 확인
    static boolean isNothing (int ball, int strike) {
        return ball == 0 && strike == 0;
    }

    //3스트라이크 여부 true, false 확인
    static boolean isThreeStrike (int strike) {
        return strike == GAMEOVER_STRIKE;
    }

    static void playGame () {
        //컴퓨터가 랜덤 숫자를 만듦
        List<Integer> computerNumber = new ArrayList<>(splitDigitsToArray(createRandomNumber()));
        List<Integer> userNumber = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        //3스트라이크가 나올때까지 반복
        while (!isThreeStrike(strike)) {
            //scanner로 유저가 제안하는 숫자 받아서 각 자리수 배열로 만들기
            userNumber = splitDigitsToArray(ScanUserNumber());
            //
            strike = countStrike(userNumber, computerNumber);
            ball = countBall(userNumber, computerNumber);
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }

    }

    public static void main(String[] args) {
        playGame();
    }
}
