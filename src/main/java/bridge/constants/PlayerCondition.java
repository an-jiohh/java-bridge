package bridge.constants;

public enum PlayerCondition {
    PASS("O"),
    NONE_PASS("X");

    private final String passWord;

    PlayerCondition(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }
}
