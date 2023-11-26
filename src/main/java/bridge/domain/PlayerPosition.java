package bridge.domain;

import static bridge.constants.PlayerCondition.NONE_PASS;

import bridge.constants.PlayerCondition;
import java.util.ArrayList;
import java.util.List;

public class PlayerPosition {
    private final List<String> playerBridgePosition = new ArrayList<>();
    private final List<PlayerCondition> bridgePass = new ArrayList<>();

    public void addPosition(String position, PlayerCondition condition) {
        playerBridgePosition.add(position);
        bridgePass.add(condition);
    }

    public int getPositionSize() {
        return playerBridgePosition.size();
    }

    public boolean checkAllPass() {
        return !bridgePass.contains(NONE_PASS);
    }

    public List<String> getPlayerUpPosition() {
        List<String> upPosition = new ArrayList<>();
        for (int i = 0; i < playerBridgePosition.size(); i++) {
            String passWord = definePassWord(i, "U");
            upPosition.add(" " + passWord + " ");
        }
        return upPosition;
    }

    public List<String> getPlayerDownPosition() {
        List<String> downPosition = new ArrayList<>();
        for (int i = 0; i < playerBridgePosition.size(); i++) {
            String passWord = definePassWord(i, "D");
            downPosition.add(" " + passWord + " ");
        }
        return downPosition;
    }

    private String definePassWord(int index, String position) {
        if (playerBridgePosition.get(index).equals(position)) {
            return bridgePass.get(index).getPassWord();
        }
        return " ";
    }
}
