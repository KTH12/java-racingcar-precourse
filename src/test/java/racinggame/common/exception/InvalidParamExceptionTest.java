package racinggame.common.exception;

import org.junit.jupiter.api.Test;
import racinggame.common.response.ErrorCode;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InvalidParamExceptionTest {

    @Test
    void InvalidParamException_CAR_NAME_SIZE_OVER_테스트() {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            throw new InvalidParamException(ErrorCode.CAR_NAME_SIZE_OVER);
        }).withMessage(ErrorCode.CAR_NAME_SIZE_OVER.getErrorMsg());
    }

    @Test
    void InvalidParamException_테스트() {
        assertThatExceptionOfType(InvalidParamException.class).isThrownBy(() -> {
            throw new InvalidParamException();
        }).withMessage(ErrorCode.COMMON_INVALID_PARAMETER.getErrorMsg());
    }
}