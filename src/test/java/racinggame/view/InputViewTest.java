package racinggame.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,", "abab", ",aaaa", ",a,,bb,,ccc", "aaa,ccc,,"})
    void 유효하지않은_자동차_이름_입력(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputView.splitCarNames(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "pobi,crong,honux,dh:4"}, delimiter = ':')
    void 유효한_자동차_이름_입력_시_자동차의_이름_수가_정상(String input, int expected) {
        List<String> carsName = inputView.splitCarNames(input);

        assertThat(carsName.size()).isEqualTo(expected);
    }
}