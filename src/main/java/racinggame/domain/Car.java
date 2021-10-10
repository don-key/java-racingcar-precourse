package racinggame.domain;

public class Car {

    private CarName name;
    private final Mileage mileage;
    private final CarMoveCondition carMoveCondition;

    public Car(String name) {
        this.name = new CarName(name);
        this.mileage = new Mileage();
        this.carMoveCondition = new CarMoveCondition();
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
}
