package lotto.domain;

import lotto.domain.Lotto.LottoGenerator;
import lotto.validator.LottoValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoGeneratorTest {
    private LottoValidator lottoValidator;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoValidator = new LottoValidator();
        lottoGenerator = new LottoGenerator(lottoValidator);
    }

    @Test
    void 로또번호_생성_기능_테스트() {
        List<Integer> randomNumbers = Arrays.asList(10, 5, 3, 6, 7, 8);
        List<Integer> expectedNumbers = Arrays.asList(3, 5, 6, 7, 8, 10);

        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers(randomNumbers);

        Assertions.assertThat(lottoNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void 로또번호_범위_예외_테스트() {
        List<Integer> randomNumbers = Arrays.asList(46, 5, 3, 6, 7, 8);

        Assertions.assertThatThrownBy(() -> lottoGenerator.generateLottoNumbers(randomNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR\\] 로또 번호는 1부터 45 사이의 정수여야 합니다. 잘못된 번호: 46");
    }

    @Test
    void 로또번호_중복_예외_테스트() {
        List<Integer> randomNumbers = Arrays.asList(4, 5, 3, 5, 7, 8);

        Assertions.assertThatThrownBy(() -> lottoGenerator.generateLottoNumbers(randomNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR\\] 로또 번호는 중복될 수 없습니다. 중복된 번호: 5");
    }
}
