package racinggame.domain;

public class Mileage {

    private int mileage;

    public Mileage() {
        this.mileage = 0;
    }

    public Mileage(int mileage) {
        this.mileage = mileage;
    }

    public void addMileage() {
        this.mileage += 1;
    }

    public int getMileage() {
        return mileage;
    }

}
