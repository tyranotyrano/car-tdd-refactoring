package com.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.util.ReflectionTestUtils;

// 단축키 : Shift + F10
public class CarTest {

    @DisplayName("자동차는 1~5자 이름을 갖는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void create1(String name) {
        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(new CarName(name));
    }

    @DisplayName("자동차는 null 또는 빈문자열로 이름을 가질 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void create2(String name) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name));
    }

    @DisplayName("자동차는 5자를 초과하는 이름을 가질 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "jafiwjfwiafjwjwfj[wf"})
    void create3(String name) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name));
    }

    @DisplayName("자동차의 최초 이동거리는 0 이다.")
    @Test
    void move1() {
        // given
        Car car = new Car("자동차");

        // when & then
        MovingDistance expected = new MovingDistance();
        ReflectionTestUtils.setField(expected, "distance", 0);

        assertThat(car.getMovingDistance()).isEqualTo(expected);
    }

    @DisplayName("자동차는 이동 시 1만큼 이동한다.")
    @Test
    void move2() {
        // given
        Car car = new Car("자동차");

        // when
        car.move();

        // then
        MovingDistance expected = new MovingDistance();
        ReflectionTestUtils.setField(expected, "distance", 1);

        assertThat(car.getMovingDistance()).isEqualTo(expected);
    }

    @DisplayName("자동차는 최대 10 까지만 이동할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 100})
    void move3(int moveCount) {
        // given
        Car car = new Car("자동차");

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        MovingDistance expected = new MovingDistance();
        ReflectionTestUtils.setField(expected, "distance", 10);

        assertThat(car.getMovingDistance()).isEqualTo(expected);
    }
}
