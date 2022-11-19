package ui;

public class Validator {
    static public String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static public String MOVING_INPUT_ERROR = "[ERROR] U(위 칸) 와 D(아래 칸) 문자만 사용이 가능합니다.";

    public int validateBridgeSizeInput(String userInput) throws IllegalArgumentException {
        String digitUserInput = validateUserInputIsDigit(userInput);
        int bridgeSize = validateUserInputInRangeFrom3To20(digitUserInput);
        return bridgeSize;
    }

    private int validateUserInputInRangeFrom3To20(String digitUserInput) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(digitUserInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
        }

        if (bridgeSize < 3 || 20 < bridgeSize) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
        }
        return bridgeSize;
    }

    private String validateUserInputIsDigit(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
            }
        }

        return userInput;
    }
}
