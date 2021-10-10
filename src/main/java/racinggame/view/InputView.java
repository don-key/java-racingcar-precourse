package racinggame.view;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final int CAR_MIN_SIZE = 1;
    private static final String INVALID_NAME = "[ERROR] 자동차의 이름이 정상적으로 입력되지 않았습니다. 쉼표(,)를 확인해주세요.";

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        return splitCarNames(carNames);
    }

    protected List<String> splitCarNames(String carNames) {
        validateCarNamesSplitLength(carNames);
        validateInvalidCarNames(carNames);
        return Arrays.asList(carNames.split(","));
    }

    private void validateCarNamesSplitLength(String carNames) {
        if (carNames.split(",").length <= CAR_MIN_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

    private void validateInvalidCarNames(String carNames) {
        if (Arrays.asList(carNames.split(",")).contains("") || carNames.contains(",,")) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

}
