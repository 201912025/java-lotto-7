package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputBuyLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String buyLottoMoney = Console.readLine();
        return buyLottoMoney;
    }

    public String inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();
        return winNumbers;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
