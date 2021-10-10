package racinggame.domain;

import nextstep.utils.Randoms;

public class CarMoveCondition {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    public Boolean isMoving() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MOVE_CONDITION;
    }

}
