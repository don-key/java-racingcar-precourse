package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @Test
    void 주행_안함() {
        Car car = new Car("현대");

        assertThat(car.getTotalMileage()).isEqualTo(0);
    }

    @Test
    void 전진() {
        Car car = new Car("현대") {
            @Override
            protected boolean isMoving() {
                return true;
            }
        };

        car.move();

        assertThat(car.getTotalMileage()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car("현대") {
            @Override
            protected boolean isMoving() {
                return false;
            }
        };

        car.move();

        assertThat(car.getTotalMileage()).isEqualTo(0);
    }

    @Test
    void 자동차의_이름이_NULL_이거나_공백일때_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hyundai", "abcdefgfffff"})
    void 자동차의_이름_5글자_초과_시_에러(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name));
    }

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("현대");

        assertThat(car.getCarName()).isEqualTo("현대");
    }
}