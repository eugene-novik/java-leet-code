package org.study.algorithms;

import java.util.HashMap;
import java.util.Map;

public class ArrayAlgorithms {

  /**
   * Algorithm called maxSubarraySum which accepts an array of integers and an integer n, and
   * returns the maximum sum of any contiguous sequence of n elements in the array. Time Complexity:
   * O(n^2)
   *
   * @param array of number
   * @param sizeForSubArray size for sub array
   * @return the maxSize of sub array
   */
  public Integer maxSubArraySum(int[] array, int sizeForSubArray) {
    if (array.length < 1 || sizeForSubArray == 0) {
      return null;
    }

    Integer maxSumOfSubArray = null;

    for (int i = 0; i < array.length && array.length > sizeForSubArray - 1; i++) {
      int result = 0;

      for (int j = i; j < sizeForSubArray; j++) {
        result += array[j];
      }

      if (maxSumOfSubArray == null) {
        maxSumOfSubArray = result;
      } else if (result > maxSumOfSubArray) {
        maxSumOfSubArray = result;
      }

      sizeForSubArray++;
    }

    return maxSumOfSubArray;

  }

  /**
   * Algorithm called maxSubarraySum which accepts an array of integers and an integer n, and
   * returns the maximum sum of any contiguous sequence of n elements in the array. Time Complexity:
   * O(n)
   *
   * @param array of number
   * @param sizeForSubArray size for sub array
   * @return the maxSize of sub array
   */
  public Integer maxSubArraySum2(int[] array, int sizeForSubArray) {
    if (array.length < sizeForSubArray) {
      return null;
    }

    int maxSum = 0;
    int tempSum = 0;

    for (int i = 0; i < sizeForSubArray; i++) {
      maxSum += array[i];
    }

    tempSum = maxSum;

    for (int i = sizeForSubArray; i < array.length; i++) {
      tempSum = tempSum - array[i - sizeForSubArray] + array[i];
      if (tempSum > maxSum) {
        maxSum = tempSum;
      }
    }

    return maxSum;
  }

  /**
   * AGiven an array of integers nums and an integer target, return indices of the two numbers such
   * that they add up to target. You may assume that each input would have exactly one solution, and
   * you may not use the same element twice. You can return the answer in any order. Time
   * Complexity: O(n^n)
   *
   * @param array numbers
   * @param target number to compare sum of two elements
   * @return array with indexes
   * @see <a href="https://leetcode.com/problems/two-sum">LeetCode</a>
   */
  public int[] findTwoElementsWhereSumEqualsTargetBrutForce(int[] array, int target) {
    if (array == null || array.length < 1) {
      return null;
    }

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i != j && array[i] + array[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  /**
   * AGiven an array of integers nums and an integer target, return indices of the two numbers such
   * that they add up to target. You may assume that each input would have exactly one solution, and
   * you may not use the same element twice. You can return the answer in any order. Time
   * Complexity: O(n)
   *
   * @param array numbers
   * @param target number to compare sum of two elements
   * @return array with indexes
   * @see <a href="https://leetcode.com/problems/two-sum">LeetCode</a>
   */
  public int[] findTwoElementsWhereSumEqualsTargetByMap(int[] array, int target) {
    if (array == null || array.length < 1) {
      return null;
    }

    Map<Integer, Integer> valueMap = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      valueMap.put(array[i], i);
    }

    for (int i = 0; i < array.length; i++) {
      Integer secondIndex = valueMap.get(target - array[i]);
      if (secondIndex != null && secondIndex != i) {
        return new int[]{i, valueMap.get(target - array[i])};
      }
    }
    return null;
  }

  /**
   * AGiven an array of integers nums and an integer target, return indices of the two numbers such
   * that they add up to target. You may assume that each input would have exactly one solution, and
   * you may not use the same element twice. You can return the answer in any order. Time
   * Complexity: O(n)
   *
   * @param array numbers
   * @param target number to compare sum of two elements
   * @return array with indexes
   * @see <a href="https://leetcode.com/problems/two-sum">LeetCode</a>
   */
  public int[] findTwoElementsWhereSumEqualsTargetByAnotherMap(int[] array, int target) {
    if (array == null || array.length < 1) {
      return null;
    }

    Map<Integer, Integer> valueMap = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      int x = target - array[i];
      if (valueMap.containsKey(x)) {
        return new int[]{valueMap.get(target - array[i]), i};
      }
      valueMap.put(array[i], i);
    }
    return null;
  }

}
