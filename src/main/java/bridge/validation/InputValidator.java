package bridge.validation;

public class InputValidator {

    public void validateBridgeSize(String readLine){
        checkBlank(readLine);
        checkDigit(readLine);
    }

    public void validateBridgeSizeRange(int bridgeSize){
        if(bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateMoving(String readLine){
        checkBlank(readLine);
        checkMovingWord(readLine);
    }

    public void validateGameCommand(String readLine){
        checkBlank(readLine);
        checkGameCommandWord(readLine);
    }

    private void checkBlank(String readLine){
        if(readLine.isBlank()){
            throw new IllegalArgumentException("[ERROR] 빈 값이 입력되었습니다.");
        }
    }

    private void checkDigit(String readLine){
        for(int i = 0; i < readLine.length(); i++){
            if(!Character.isDigit(readLine.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
            }
        }
    }

    private void checkMovingWord(String readLine){
        if(!readLine.equals("U") && !readLine.equals("D")){
            throw new IllegalArgumentException("[ERROR] 이동하기 위해서는 U 또는 D를 입력해야합니다.");
        }
    }

    private void checkGameCommandWord(String readLine){
        if(!readLine.equals("R") && !readLine.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야합니다.");
        }
    }
}
