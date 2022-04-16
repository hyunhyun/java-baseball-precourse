package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerImpl implements Computer {
    @Override
    public String produceNumber() {
        String numberString = "";
        for (int i = 0; i < 3; i++) {
            numberString += produceNonDuplicateNumber(numberString);
        }
        return numberString;
    }

    public String produceNonDuplicateNumber(String number) {
        String s = "";
        while (s.isEmpty() || number.contains(s)) {
            s = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }
        return s;
    }
}
