package baseball;

import baseball.constant.BaseBallMessage;
import baseball.play.PlayGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayGame playGame = new PlayGame();

        int retryGame = 1;
        while (retryGame == 1) {
            playGame.gameRound(); //한문제로 게임 1round 진행
            System.out.println(BaseBallMessage.GUIDE_MSG_REGAME);
            retryGame = Integer.parseInt(Console.readLine());
            if(retryGame == 2){
                break;
            }
        }
    }
}
