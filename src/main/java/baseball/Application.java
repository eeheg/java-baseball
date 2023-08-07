package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.printGameStartMessage();
            game.playGame();
        } catch (IllegalArgumentException e) {
    /* [문제 요구사항]
    * 1. 프로그램 종료 시 System.exit()를 호출하지 않는다.
    * 2. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    *
    *  getUserNumberWithValidation() throws IllegalArgumentException 에서 예외가 발생한다.
    *  => IllegalArgumentException e (예외)를 던진다.
    *  => e를 Application.java 에서 예외처리하여 main 함수를 종료시킨다.
    *  => 애플리케이션이 종료한다.
    */
        }
    }
}
