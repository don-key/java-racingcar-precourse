package racinggame.utils;

public class ValidationUtils {

    private static final String INVALID_NAME = "[ERROR] 값이 입력되지 않았습니다.";
    public static final String BLANK = "";

    public static void validateNullOrBlank(String str) {
        if (null == str || BLANK.equals(str)) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

}
