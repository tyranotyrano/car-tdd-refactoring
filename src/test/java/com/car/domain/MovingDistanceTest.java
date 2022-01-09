package com.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.util.ReflectionTestUtils;

public class MovingDistanceTest {

    @DisplayName("자동차의 최초 이동거리는 0 이다.")
    @Test
    void create1() {
        // given
        MovingDistance movingDistance = new MovingDistance();

        // when & then
        assertThat(movingDistance).isEqualTo(new MovingDistance());
    }

    @DisplayName("자동차는 이동 시 1만큼 이동한다.")
    @Test
    void move2() {
        // given
        MovingDistance actual = new MovingDistance();

        // when
        actual.move();

        // then
        MovingDistance expected = new MovingDistance();
        ReflectionTestUtils.setField(expected, "distance", 1);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("자동차는 최대 10 까지만 이동할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 100})
    void move3(int moveCount) {
        // given
        MovingDistance actual = new MovingDistance();

        // when
        for (int i = 0; i < moveCount; i++) {
            actual.move();
        }

        // then
        MovingDistance expected = new MovingDistance();
        ReflectionTestUtils.setField(expected, "distance", 10);

        assertThat(actual).isEqualTo(expected);
    }
}
