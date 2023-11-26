package bridge.domain;

import static bridge.constants.PlayerCondition.NONE_PASS;
import static bridge.constants.PlayerCondition.PASS;

import bridge.constants.PlayerCondition;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean checkEnd(int size){
        return bridge.size() <= size;
    }

    public PlayerCondition checkCollectPosition(int index, String targetPosition){
        String bridgePosition = bridge.get(index);
        if(checkSamePosition(bridgePosition, targetPosition)){
            return PASS;
        }
        return NONE_PASS;
    }

    private boolean checkSamePosition(String bridgePosition, String playerPosition){
        return bridgePosition.equals(playerPosition);
    }
}