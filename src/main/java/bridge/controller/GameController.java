package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> strings = bridgeMaker.makeBridge(getBridgeSize());
        Bridge bridge = new Bridge(strings);
        play(bridge);
    }

    private void play(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!bridgeGame.checkGameEnd()) {
            bridgeGame.move();
            outputView.printMap(bridgeGame.getPlayerPosition());
            if (bridgeGame.checkCollectBridge()) {
                continue;
            }
            if (checkGameEndCommand()) {
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame);
    }

    private boolean checkGameEndCommand() {
        String gameCommand = getGameCommand();
        return gameCommand.equals("Q");
    }

    private String getGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
