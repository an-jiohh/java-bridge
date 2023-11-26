package bridge;

import bridge.constants.PlayerCondition;
import bridge.domain.Bridge;
import bridge.domain.PlayerPosition;
import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private PlayerPosition playerPosition;
    private final Bridge bridge;
    private int retryCount;

    public BridgeGame(Bridge bridge) {
        this.inputView = new InputView();
        this.bridge = bridge;
        this.playerPosition = new PlayerPosition();
        this.retryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String movingPosition = readMovingPosition();
        int positionSize = playerPosition.getPositionSize();
        PlayerCondition playerCondition = bridge.checkCollectPosition(positionSize, movingPosition);
        playerPosition.addPosition(movingPosition, playerCondition);
    }

    public boolean checkGameEnd(){
        int size = playerPosition.getPositionSize();
        return bridge.checkEnd(size);
    }

    public boolean checkCollectBridge(){
        return playerPosition.checkAllPass();
    }

    private String readMovingPosition(){
        while(true){
            try{
                return inputView.readMoving();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public PlayerPosition getPlayerPosition(){
        return playerPosition;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playerPosition = new PlayerPosition();
        retryCount++;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
