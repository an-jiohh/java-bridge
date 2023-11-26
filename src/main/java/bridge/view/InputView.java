package bridge.view;

import bridge.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final InputValidator inputValidation;

    public InputView() {
        this.inputValidation = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String readLine = Console.readLine();
        inputValidation.validateBridgeSize(readLine);
        int bridgeSize = parserBridgeSize(readLine);
        inputValidation.validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String readLine = Console.readLine();
        inputValidation.validateMoving(readLine);
        return readLine;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String readLine = Console.readLine();
        inputValidation.validateGameCommand(readLine);
        return readLine;
    }

    private int parserBridgeSize(String readLine) {
        int bridgeSize = 0;
        try {
            bridgeSize = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수형 범위를 벗어났습니다.");
        }
        return bridgeSize;
    }
}
