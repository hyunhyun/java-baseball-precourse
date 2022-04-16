package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //요구사항 1
    @Test
    @DisplayName("set size 확인")
    void sizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    //요구사항 2
    @DisplayName("parameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setContainsTest(int input){
        assertThat(numbers).contains(input);
    }

    //요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true","4,false","5,false"})
    void test(int input, boolean expected){
        boolean actual = numbers.contains(input);
        assertEquals(expected, actual);
    }

}
