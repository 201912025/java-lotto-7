package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.Lotto.LottoManager;
import lotto.domain.Lotto.LottoNumbersGenerator;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoCalculate;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController createLottoController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoValidator lottoValidator = new LottoValidator();
        WinningLottoCounter winningLottoCounter = new WinningLottoCounter();
        LottoFormatter lottoFormatter = new LottoFormatter(winningLottoCounter);
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(lottoValidator);
        LottoManager lottoManager = new LottoManager(lottoNumbersGenerator);
        WinningLottoCalculate winningLottoCalculate = new WinningLottoCalculate(winningLottoCounter, lottoFormatter);
        LottoService lottoService = new LottoService(lottoNumbersGenerator, lottoManager, lottoFormatter, winningLottoCounter, winningLottoCalculate);
        return new LottoController(inputView, outputView, lottoService);
    }
}
