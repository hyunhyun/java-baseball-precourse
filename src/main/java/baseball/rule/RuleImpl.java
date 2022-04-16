package baseball.rule;

import baseball.constant.BaseBallMessage;

public class RuleImpl implements Rule {
    @Override
    public boolean ruleResult(String numberString, String guess) {
        int ballCnt;
        int strikeCnt;
        boolean success = false;

        ballCnt = ball(numberString, guess);
        strikeCnt = strike(numberString, guess);

        printResultMsg(ballCnt, strikeCnt);

        if (strikeCnt == 3) {
            success = true;
        }
        return success;
    }

    @Override
    public int strike(String numberString, String guess) {
        int cnt = 0;
        for (int i = 0; i < numberString.length(); i++) {
            cnt += validateStrike(numberString, guess, i);
        }
        return cnt;
    }

    private int validateStrike(String numberString, String guess, int i) {
        if (numberString.charAt(i) == guess.charAt(i)) {
            return 1;
        }
        return 0;
    }

    @Override
    public int ball(String numberString, String guess) {
        int cnt = 0;
        for (int i = 0; i < numberString.length(); i++) {
            cnt += validateBall(numberString, guess, i);
        }
        return cnt;
    }

    private int validateBall(String numberString, String guess, int i) {
        if (validateStrike(numberString, guess, i) > 0) {
            return 0; //해당 문자는 strike임
        }
        boolean contains = guess.contains(numberString.substring(i, i + 1));
        if (contains) {
            return 1;
        }
        return 0;
    }

    private void printResultMsg(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.printf(BaseBallMessage.OUTPUT_MSG_BOTH, ball, strike);
        }
        if (ball > 0 && strike == 0) {
            System.out.printf(BaseBallMessage.OUTPUT_MSG_BALL, ball);
        }
        if (strike > 0 && ball == 0) {
            System.out.printf(BaseBallMessage.OUTPUT_MSG_STRIKE, strike);
        }
        if (strike == 0 && ball == 0) {
            System.out.print(BaseBallMessage.OUTPUT_MSG_NOTHING);
        }
        System.out.println();
    }
}
