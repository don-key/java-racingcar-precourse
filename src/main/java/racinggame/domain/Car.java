package racinggame.domain;

public class Car {

    private final CarName name;
    private final Mileage mileage;
    private final CarMoveCondition carMoveCondition;

    public Car(String name) {
        this.name = new CarName(name);
        this.mileage = new Mileage();
        this.carMoveCondition = new CarMoveCondition();
    }

    private Car(CarName name, Mileage mileage, CarMoveCondition carMoveCondition) {
        this.name = new CarName(name.getName());
        this.mileage = new Mileage(mileage.getMileage());
        this.carMoveCondition = carMoveCondition;
    }

    public void move() {
        if (isMoving()) {
            mileage.addMileage();
        }
    }

    protected boolean isMoving() {
        return carMoveCondition.isMoving();
    }

    public String getCarName() {
        return name.getName();
    }

    public int getTotalMileage() {
        return mileage.getMileage();
    }

    public Car getCloneCar() {
        return new Car(name, mileage, carMoveCondition);
    }

}
