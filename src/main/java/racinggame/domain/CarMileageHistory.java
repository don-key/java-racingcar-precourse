package racinggame.domain;

import java.util.List;

public class CarMileageHistory {

    List<Car> cars;

    public CarMileageHistory(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
