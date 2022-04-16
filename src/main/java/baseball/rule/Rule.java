package baseball.rule;

public interface Rule {
    boolean ruleResult(String numberString, String guess);

    int strike(String numberString, String guess);

    int ball(String numberString, String guess);
}
