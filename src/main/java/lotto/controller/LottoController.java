package lotto.controller;

import lotto.dto.WinningLottoResultDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int buyLottoMoney = getBuyLottoMoney();
        int buyLottoCount = lottoService.getCalculateBuyLottoCount(buyLottoMoney);

        lottoService.callCreateLottos(buyLottoCount);
        outputView.printBuyLottoCount(buyLottoCount);

        printLottos();

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber();

        processWinningNumbers(winningNumbers, bonusNumber);

        printWinningStatistics(buyLottoMoney);
    }

    private int getBuyLottoMoney() {
        while (true) {
            try {
                return Integer.parseInt(inputView.inputBuyLottoMoney());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();
            }
        }
    }

    private String getWinningNumbers() {
        while (true) {
            try {
                return inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();
            }
        }
    }

    private String getBonusNumber() {
        while (true) {
            try {
                return inputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();
            }
        }
    }

    private void printLottos() {
        List<String> formattedLottoNumbers = lottoService.formatBuyLottoNumbersResult();
        for (String formattedLottoNumber : formattedLottoNumbers) {
            outputView.printLottoNumbers(formattedLottoNumber);
        }
        outputView.printWhiteSpace();
    }

    private void processWinningNumbers(String winningNumbers, String bonusNumber) {
        lottoService.recordWinningLotto(winningNumbers, bonusNumber);
    }

    private void printWinningStatistics(int buyLottoMoney) {
        List<WinningLottoResultDTO> formatWinningLottoResults = lottoService.formatWinningLottoResults();

        outputView.printWhiteSpace();
        outputView.printBeforeWinningLottoInfo();
        for (WinningLottoResultDTO winningLottoResultDTO : formatWinningLottoResults) {
            outputView.printWinningLottoInfo(
                    winningLottoResultDTO.getMatchedCount(),
                    winningLottoResultDTO.getPrize(),
                    winningLottoResultDTO.getCount()
            );
        }

        double lottoRateOfReturn = lottoService.callCalculateLottoRateOfReturn(buyLottoMoney);
        outputView.printRateOfReturn(lottoRateOfReturn);
    }
}

