package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = addCars(carNames);
    }

    private List<Car> addCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void moveCars() {
        for (Car car : getCarsList()) {
            car.move();
        }
    }

    public List<Car> getCloneCars() {
        List<Car> cloneCars = new ArrayList<>();
        for (Car car : getCarsList()) {
            cloneCars.add(car.getCloneCar());
        }
        return cloneCars;
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCarsList() {
        return cars;
    }

    public List<Car> getGameWinner() {
        int mileageMax = getMileageMax();
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : getCarsList()) {
            addWinnerCars(mileageMax, winnerCars, car);
        }
        return winnerCars;
    }

    private int getMileageMax() {
        List<Integer> mileageList = new ArrayList<>();
        for (Car car : getCarsList()) {
            mileageList.add(car.getTotalMileage());
        }
        return Collections.max(mileageList);
    }

    private void addWinnerCars(int mileageMax, List<Car> winnerCars, Car car) {
        if (mileageMax == car.getTotalMileage()) {
            winnerCars.add(car);
        }
    }

}
