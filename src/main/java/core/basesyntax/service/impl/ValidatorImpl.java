package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int NUMBER_OF_PARAMETERS = 3;

    @Override
    public boolean validate(String line) {
        String[] oneLineData = line.split(",");
        if (oneLineData.length != NUMBER_OF_PARAMETERS) {
            return false;
        }
        try {
            Integer.parseInt(oneLineData[QUANTITY]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (oneLineData[OPERATION].matches("[bspr]")
                && oneLineData[FRUIT_NAME].matches("[A-Za-z]*")
                && !oneLineData[FRUIT_NAME].isEmpty()
                && Integer.parseInt(oneLineData[QUANTITY]) > 0) {
            return true;
        }
        return false;
    }
}