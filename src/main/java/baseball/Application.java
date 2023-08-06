package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.gameStart();
            game.playGame();
        } catch (IllegalArgumentException e) {
            return;
    /* [문제 요구사항]
    * 1. 프로그램 종료 시 System.exit()를 호출하지 않는다.
    * 2. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    *
    *  getUserNumberWithValidation() throws IllegalArgumentException 에서 예외가 발생한다.
    *  => IllegalArgumentException e (예외)를 던진다.
    *  => main 함수에서 e를 받고 return 시키면 main 함수가 종료된다.
    *  => Application.java 가 종료된다.
    */
        }
    }
}
