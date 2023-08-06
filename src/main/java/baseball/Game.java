package baseball;

import java.util.*;

public class Game {
    static final int GAMEOVER_STRIKE = 3;
    static final int ZERO_OCCURRENCE = 0;
    int strike, ball;

    List<Integer> computerNumber = new ComputerNumber().getComputerNumber();

    void playGame () {
        System.out.println("숫자 야구 게임을 시작합니다.");
        //3스트라이크가 나올때까지 반복
        do {
            List<Integer> userNumber = new UserNumber().getUserNumber();
            int ball = countBall(userNumber, computerNumber);
            int strike = countStrike(userNumber, computerNumber);
            System.out.printf("%d, %d \n", ball, strike);
            if (isNothing()) {
                System.out.println("낫싱");
                continue;
            }
            printBallAndStrike();
            System.out.println();
        } while (!isThreeStrike());
        System.out.println("[{"+GAMEOVER_STRIKE+"}스트라이크]\n"+GAMEOVER_STRIKE+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void printBallAndStrike() {
        if (isNotBall()) {
            System.out.printf("%d볼 ", ball);
        }
        if (isNotStrike()) {
            System.out.printf("%d스트라이크", strike);
        }
    }

    //Strike(스트라이크) 카운팅
    int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        strike = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (userNumber.get(index) == computerNumber.get(index)) {
                strike++;
            }
        }
        return strike;
    }

    //Ball(볼) 카운팅
    int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        ball = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (userNumber.get(index) == computerNumber.get(index)) {
                continue;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                ball++;
            }
        }
        return ball;
    }

    boolean isThreeStrike() {
        return strike == GAMEOVER_STRIKE;
    }

    boolean isNothing() {
        return ball == ZERO_OCCURRENCE && strike == ZERO_OCCURRENCE;
    }

    boolean isNotBall() {
        return ball != ZERO_OCCURRENCE;
    }

    boolean isNotStrike() {
        return strike != ZERO_OCCURRENCE;
    }

}
