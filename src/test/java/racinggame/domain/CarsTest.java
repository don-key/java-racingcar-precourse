package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 자동차_생성_안함() {
        List<Car> inputCar = new ArrayList<>();

        Cars cars = new Cars(inputCar);

        assertThat(cars.getNumberOfCars()).isEqualTo(0);
    }

    @Test
    void 자동차_2대_생성() {
        List<Car> inputCar = new ArrayList<>();
        inputCar.add(new Car());
        inputCar.add(new Car());

        Cars cars = new Cars(inputCar);

        assertThat(cars.getNumberOfCars()).isEqualTo(2);
    }

}