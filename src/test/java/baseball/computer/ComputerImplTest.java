package baseball.computer;

import baseball.io.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComputerImplTest {
    ComputerImpl computer = new ComputerImpl();

    @Test
    @DisplayName("숫자 생성 3자리 숫자 확인")
    void produceNumberValidation() {
        for (int i = 0; i < 10; i++) {
            String s = computer.produceNumber();
            System.out.println("s = " + s);
            Input.validateInput(s);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"123", "567", "872", "346"})
    void produceNumber(String number) {
        String num = computer.produceNonDuplicateNumber(number);
        Assertions.assertThat(number).doesNotContain(num);
    }
}
