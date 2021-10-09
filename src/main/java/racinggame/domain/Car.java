package racinggame.domain;

public class Car {

    private final Mileage mileage;
    private final CarMoveCondition carMoveCondition;

    public Car() {
        mileage = new Mileage();
        carMoveCondition = new CarMoveCondition();
    }

    public void move() {
        if (isMoving()) {
            mileage.addMileage();
        }
    }

    protected boolean isMoving() {
        return carMoveCondition.isMoving() == CarMoveStatus.MOVE;
    }

    public int getTotalMileage() {
        return mileage.getMileage();
    }
}
