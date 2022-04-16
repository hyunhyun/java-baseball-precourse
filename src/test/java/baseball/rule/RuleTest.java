package baseball.rule;

import java.awt.TextComponent;
import java.io.ByteArrayOutputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RuleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @ParameterizedTest
    @CsvSource(value = {"123,827,0", "123, 278,1", "456,555,3"})
    @DisplayName("ball 개수 확인")
    void ball(String number, String guess, int expected){
        Rule rule = new RuleImpl();
        int ball = rule.ball(number, guess);
        Assertions.assertThat(ball).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123,827,1", "123, 278,0", "456,555,1"})
    @DisplayName("strike 개수 확인")
    void strike(String number, String guess, int expected) {
        Rule rule = new RuleImpl();
        int strike = rule.strike(number, guess);
        Assertions.assertThat(strike).isEqualTo(expected);

    }

}
