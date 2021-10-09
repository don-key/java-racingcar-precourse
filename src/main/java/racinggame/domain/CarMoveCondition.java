package racinggame.domain;

import nextstep.utils.Randoms;

public class CarMoveCondition {

    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;
    public static final int MOVE_CONDITION = 4;

    public CarMoveStatus isMoving() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MOVE_CONDITION
                ? CarMoveStatus.MOVE : CarMoveStatus.STOP;
    }

}
