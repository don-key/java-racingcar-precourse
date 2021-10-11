package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.CarMileageHistory;
import racinggame.domain.Cars;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String PRINT_DASH = "-";
    private static final String PRINT_COLON = " : ";
    private static final String DELIMITER_COMMA = ",";
    private static final String PRINT_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String PRINT_GAME_WINNER = "최종 우승자는 %s 입니다.";

    public void printInputCarNames() {
        System.out.println(PRINT_INPUT_CAR_NAMES);
    }

    public void printInputTryCount() {
        System.out.println(PRINT_INPUT_TRY_COUNT);
    }

    public void printMileageHistories(List<CarMileageHistory> mileageHistories) {
        for (CarMileageHistory mileageHistory : mileageHistories) {
            printMileageHistory(mileageHistory.getCars());
        }
    }

    public void printGameWinner(Cars cars) {
        StringJoiner sj = new StringJoiner(DELIMITER_COMMA);
        List<Car> gameWinner = cars.getGameWinner();
        for (Car car : gameWinner) {
            sj.add(car.getCarName());
        }
        System.out.printf(PRINT_GAME_WINNER, sj);
    }

    private void printMileageHistory(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + makeColonDash(car.getTotalMileage()));
        }
        System.out.println();
    }

    private String makeColonDash(int totalMileage) {
        StringBuilder sb = new StringBuilder();
        sb.append(PRINT_COLON);
        for (int i = 0; i < totalMileage; i++) {
            sb.append(PRINT_DASH);
        }
        return sb.toString();
    }


}
