package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 주행_안함() {
        Car car = new Car();

        assertThat(car.getTotalMileage()).isEqualTo(0);
    }
    @Test
    void 전진() {
        Car car = new Car() {
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
        Car car = new Car() {
            @Override
            protected boolean isMoving() {
                return false;
            }
        };

        car.move();

        assertThat(car.getTotalMileage()).isEqualTo(0);
    }
}