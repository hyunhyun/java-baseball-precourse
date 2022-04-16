package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

    //요구사항 1
    @Test
    @DisplayName("\"1,2\" , 로 split 시 contains 확인")
    void splitContainTest() {
        //given
        String str = "1,2";
        //when
        String[] strArr = str.split(",");
        //then
        assertThat(strArr).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 시 1만 포함하는 배열")
    void splitNonRegexTest() {
        //given
        String str = "1";
        //when
        String[] splitArr = str.split(",");
        //then
        assertThat(splitArr).containsExactly("1");
    }

    //요구사항 2
    @Test
    @DisplayName("subString으로 () 지우기")
    void subStringTest() {
        //given
        String str = "(1,2)";
        //when
        String substr = str.substring(1, str.length() - 1);
        //then
        assertThat(substr).isEqualTo("1,2");
    }

    //요구사항 3
    @Test
    @DisplayName("charAt 테스트")
    void charAtTest() {
        //given
        String str = "abc";
        //when
        char c = str.charAt(0);
        //then
        assertThat(c).isEqualTo("a");
    }

    @Test
    @DisplayName("charAt범위 벗어나는 경우 StringIndexOutOfBoundException 발생 확인")
    void charAtExceptionThrownByTest() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(str.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("charAt범위 벗어나는 경우 StringIndexOutOfBoundException 발생 확인")
    void charAtExceptionOfTypeTest() {
        String str = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(str.length()))
                .withMessageContaining("index out of range");
    }

}
