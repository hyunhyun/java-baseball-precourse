package baseball.play;

import baseball.computer.Computer;
import baseball.computer.ComputerImpl;
import baseball.constant.BaseBallMessage;
import baseball.io.Input;
import baseball.rule.Rule;
import baseball.rule.RuleImpl;

public class PlayGame {
    public void gameRound() throws IllegalArgumentException {
        Computer computer = new ComputerImpl();
        Rule rule = new RuleImpl();
        String problem = computer.produceNumber();

        boolean success = false;

        while (!success) {   //정답 맞추면 자동 종료
            System.out.print(BaseBallMessage.GUIDE_MSG_INPUT);
            String input = Input.getInput();
            success = rule.ruleResult(problem, input);
        }
        System.out.println(BaseBallMessage.OUTPUT_MSG_SUCCESS);
    }

}
