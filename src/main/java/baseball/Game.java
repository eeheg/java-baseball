package baseball;

import java.util.*;

//접근제한이 전혀없는 public 클래스
public class Game {
    // private static final : Game class 에서만 사용하는 상수 선언
    private static final int THREE_STRIKE_GAMEOVER = 3;
    private static final int ZERO_OCCURRENCE = 0;
    private static final int RESTART_OPTION = 1;
    private static final int GAMEOVER_OPTION = 2;
    // private 변수: Game class 에서만 사용하는 전역변수 선언
    private int strike;
    private int ball;

    // Application 클래스에서 Game 클래스 인스턴스를 생성하여 playGame(), gameStart() 사용하니까 default!
    void playGame() {
        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        scanUserNumberAndPrintResult(computerNumber);
        gameOverORRestart();
    }

    void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //나머지는 전부 Game 클래스 내에서만 사용하니까 private!
    private void gameOverORRestart() {
        System.out.println(THREE_STRIKE_GAMEOVER+"개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", RESTART_OPTION ,GAMEOVER_OPTION);
        Scanner scanUserRestartOption = new Scanner(System.in);
        switch (scanUserRestartOption.nextInt()) {
            case RESTART_OPTION :
                System.out.println();
                playGame();
                break;
            case GAMEOVER_OPTION :
                break;
        }

    }


    //userNumber 스캐너, 결과 출력 반복
    private void scanUserNumberAndPrintResult (List<Integer> computerNumber) {
        do {
            List<Integer> userNumber = new UserNumber().getUserNumber();
            ball = countBall(userNumber, computerNumber);
            strike = countStrike(userNumber, computerNumber);
            if (isNothing()) {
                System.out.println("낫싱");
                continue;
            }
            printBallAndStrike();
        } while (!isThreeStrike());
    }

    //볼,스트라이크 출력
    private void printBallAndStrike() {
        if (isNotBall()) {
            System.out.printf("%d볼 ", ball);
        }
        if (isNotStrike()) {
            System.out.printf("%d스트라이크", strike);
        }
        System.out.println();
    }

    //Strike(스트라이크) 카운팅
    private int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        strike = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (userNumber.get(index) == computerNumber.get(index)) {
                strike++;
            }
        }
        return strike;
    }

    //Ball(볼) 카운팅
    private int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
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

    private boolean isThreeStrike() {
        return strike == THREE_STRIKE_GAMEOVER;
    }

    private boolean isNothing() {
        return ball == ZERO_OCCURRENCE && strike == ZERO_OCCURRENCE;
    }

    private boolean isNotBall() {
        return ball != ZERO_OCCURRENCE;
    }

    private boolean isNotStrike() {
        return strike != ZERO_OCCURRENCE;
    }

}
