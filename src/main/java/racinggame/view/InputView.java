package racinggame.view;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final int CAR_MIN_SIZE = 1;
    private static final int TRY_COUNT_MIN = 1;
    private static final String REGEX_NUMBER = "[0-9]+";
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_TWO_COMMA = ",,";
    private static final String INVALID_TRY_COUNT = "[ERROR] 시도 횟수가 정상적으로 입력되지 않았습니다. 숫자만 입력해주세요.";
    private static final String INVALID_CAR_NAME = "[ERROR] 자동차의 이름이 정상적으로 입력되지 않았습니다. 쉼표(,)를 확인해주세요.";


    public List<String> inputCarNames() {
        return splitCarNames(Console.readLine());
    }

    public int inputTryCount() {
        return checkTryCount(Console.readLine());
    }

    protected List<String> splitCarNames(String carNames) {
        validateCarNamesSplitLength(carNames);
        validateInvalidCarNames(carNames);
        return Arrays.asList(carNames.split(SEPARATOR_COMMA));
    }

    protected int checkTryCount(String tryCount) {
        validateNullOrBlank(tryCount);
        validateTryCountIsNumber(tryCount);
        validateInvalidTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void validateCarNamesSplitLength(String carNames) {
        if (carNames.split(SEPARATOR_COMMA).length <= CAR_MIN_SIZE) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }

    private void validateInvalidCarNames(String carNames) {
        if (Arrays.asList(carNames.split(SEPARATOR_COMMA)).contains("") || carNames.contains(SEPARATOR_TWO_COMMA)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }

    private void validateNullOrBlank(String tryCount) {
        if (null == tryCount || "".equals(tryCount)) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }
    }

    private void validateInvalidTryCount(String tryCount) {
        if (Integer.parseInt(tryCount) < TRY_COUNT_MIN) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }
    }

    private void validateTryCountIsNumber(String tryCount) {
        if (!tryCount.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

}
