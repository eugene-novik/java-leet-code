package org.study.algorithms;

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

}
