package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayAlgorithmsTest {

  private ArrayAlgorithms arrayAlgorithms;

  @BeforeEach
  void setUp() {
    this.arrayAlgorithms = new ArrayAlgorithms();
  }

  @Test
  public void testMaxSubarraySumTest() {
    // Example: [1,2,5,3,8,1,5] -> [1,2] [2,5] [5,3] [3,8] [8,1] [1,5] -> sum of sub arrays 3,7,8,11,9,6 -> result 11
    assertEquals(11, arrayAlgorithms.maxSubArraySum(new int[]{1, 2, 5, 3, 8, 1, 5}, 2));
    assertEquals(18, arrayAlgorithms.maxSubArraySum(new int[]{1, 2, 5, 3, 8, 1, 5}, 4));
    assertNull(arrayAlgorithms.maxSubArraySum(new int[]{}, 4));
    assertEquals(-3, arrayAlgorithms.maxSubArraySum(new int[]{-1, -2}, 2));
  }

  @Test
  public void testMaxSubarraySumTest2() {
    // Example: [1,2,5,3,8,1,5] -> [1,2] [2,5] [5,3] [3,8] [8,1] [1,5] -> sum of sub arrays 3,7,8,11,9,6 -> result 11
    assertEquals(11, arrayAlgorithms.maxSubArraySum2(new int[]{1, 2, 5, 3, 8, 1, 5}, 2));
    assertEquals(18, arrayAlgorithms.maxSubArraySum2(new int[]{1, 2, 5, 3, 8, 1, 5}, 4));
    assertNull(arrayAlgorithms.maxSubArraySum2(new int[]{}, 4));
    assertEquals(-3, arrayAlgorithms.maxSubArraySum2(new int[]{-1, -2}, 2));
    assertEquals(400, arrayAlgorithms.maxSubArraySum2(new int[]{100, 200, 0, 400}, 2));
  }
}