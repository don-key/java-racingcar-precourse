package racinggame.domain;

public class CarName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String INVALID_NAME = "[ERROR] 자동차의 이름이 입력되지 않았습니다.";
    private static final String INVALID_NAME_LENGTH = "[ERROR] 자동차의 이름은 5자 이하만 가능합니다.";
    private final String name;

    public CarName(String name) {
        validateNullOrBlank(name);
        validateNameSize(name);
        this.name = name.trim();
    }

    private void validateNullOrBlank(String name) {
        if (null == name || "".equals(name)) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

    private void validateNameSize(String name) {
        if (!(name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
