package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 자동차_생성_안함() {
        List<String> carNames = new ArrayList<>();

        Cars cars = new Cars(carNames);

        assertThat(cars.getNumberOfCars()).isEqualTo(0);
    }

    @Test
    void 자동차_2대_생성() {
        List<String> carNames = new ArrayList<>();
        carNames.add("현대");
        carNames.add("기아");

        Cars cars = new Cars(carNames);

        assertThat(cars.getNumberOfCars()).isEqualTo(2);
    }

}