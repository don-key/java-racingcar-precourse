package racinggame.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }
}
