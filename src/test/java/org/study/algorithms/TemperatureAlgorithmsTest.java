package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureAlgorithmsTest {

  private TemperatureAlgorithm algorithm;

  @BeforeEach
  void setUp() {
    algorithm = new TemperatureAlgorithm();
  }

  @Test
  void testBruteForce() {
    assertArrayEquals(new int[]{2, 1, 4, 2, 1, 1, 0}, algorithm.temperaturesByBruteForce(new int[]{13, 12, 15, 11, 9, 12, 16}));
    assertArrayEquals(new int[]{2, 1, 1, 1, 1, 1, 0}, algorithm.temperaturesByBruteForce(new int[]{-1, -5, 0, 1, 2, 3, 4}));
  }

  @Test
  void testStack() {
    assertArrayEquals(new int[]{2, 1, 4, 2, 1, 1, 0}, algorithm.temperaturesByStack(new int[]{13, 12, 15, 11, 9, 12, 16}));
    assertArrayEquals(new int[]{2, 1, 1, 1, 1, 1, 0}, algorithm.temperaturesByStack(new int[]{-1, -5, 0, 1, 2, 3, 4}));
  }
}