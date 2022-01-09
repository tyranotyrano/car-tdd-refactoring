package com.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @DisplayName("자동차 이름은 1~5자 를 갖는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void create1(String name) {
        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName).isEqualTo(new CarName(name));
    }

    @DisplayName("자동차는 null 또는 빈문자열로 이름을 가질 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void create2(String name) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }

    @DisplayName("자동차는 5자를 초과하는 이름을 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "jafiwjfwiafjwjwfj[wf"})
    void create3(String name) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }
}
