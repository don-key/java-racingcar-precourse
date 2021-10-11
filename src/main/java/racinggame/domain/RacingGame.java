package racinggame.domain;

import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    InputView inputView;
    OutputView outputView;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Cars cars = inputCarNames();
        int tryCount = inputTryCount();
        play(cars, tryCount);
    }

    private void play(Cars cars, int tryCount) {
        List<CarMileageHistory> mileageHistories = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            mileageHistories.add(new CarMileageHistory(cars.getCloneCars()));
        }
        printGameResult(cars, mileageHistories);
    }

    private Cars inputCarNames() {
        try {
            outputView.printInputCarNames();
            return new Cars(inputView.inputCarNames());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputCarNames();
        }
    }

    private int inputTryCount() {
        try {
            outputView.printInputTryCount();
            return inputView.inputTryCount();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputTryCount();
        }
    }

    private void printGameResult(Cars cars, List<CarMileageHistory> mileageHistories) {
        outputView.printMileageHistories(mileageHistories);
        outputView.printGameWinner(cars);
    }

}
