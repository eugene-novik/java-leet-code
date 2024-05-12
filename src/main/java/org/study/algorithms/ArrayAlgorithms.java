package org.study.algorithms;

import java.util.HashMap;
import java.util.Map;

public class ArrayAlgorithms {

  /**
   * Algorithm called maxSubarraySum which accepts an array of integers and an integer n, and
   * returns the maximum sum of any contiguous sequence of n elements in the array. Time Complexity:
   * O(n^2)
   *
   * @param array           of number
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
   * @param array           of number
   * @param sizeForSubArray size for sub array
   * @return the maxSize of sub array
   */
  public Integer maxSubArraySum2(int[] array, int sizeForSubArray) {
    if (array.length < sizeForSubArray) {
      return null;
    }

    int maxSum = 0;

    for (int i = 0; i < sizeForSubArray; i++) {
      maxSum += array[i];
    }

    int tempSum = maxSum;

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
   * @param array  numbers
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
   * @param array  numbers
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
   * @param array  numbers
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

  /**
   * Algorithm to find the longest common prefix string amongst an array of strings. Complexity:
   * O(S*N) where N length of array, S length of first word
   *
   * @param array input values
   * @return the long prefix for whole words
   * @see <a href="https://leetcode.com/problems/longest-common-prefix/">LeetCode</a>
   */
  public String findLongestCommonPrefix(String[] array) {
    if (array == null || array.length == 0 || array[0].toCharArray().length == 0) {
      return "";
    }

    char[] firstWord = array[0].toCharArray();
    boolean valid = true;
    String result = "";
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < firstWord.length && valid; i++) {
      builder.append(firstWord[i]);
      for (int j = 1; j < array.length; j++) {
        String nextWord = array[j];
        if (!nextWord.startsWith(builder.toString())) {
          valid = false;
          break;
        }
      }
      if (valid) {
        result = builder.toString();
      }
    }
    return result;
  }

  /**
   * Algorithm to find the longest common prefix string amongst an array of strings. Complexity: O(S
   * * log(N)) where N length of array, S length of first word
   *
   * @param array input values
   * @return the long prefix for whole words
   * @see <a href="https://leetcode.com/problems/longest-common-prefix/">LeetCode</a>
   */
  public String findLongestCommonPrefixBinarySearch(String[] array) {
    if (array == null || array.length == 0) {
      return "";
    }

    int minLengthOfWord = Integer.MAX_VALUE;

    for (String word : array) {
      minLengthOfWord = Math.min(minLengthOfWord, word.length());
    }

    int left = 1;
    int right = minLengthOfWord;

    while (left <= right) {
      int mid = (right + left) / 2;
      if (isTheSamePrefix(array, mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return array[0].substring(0, (left + right) / 2);
  }


  private boolean isTheSamePrefix(String[] array, int position) {
    String prefix = array[0].substring(0, position);
    for (String word : array) {
      if (!word.startsWith(prefix)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Algorithm to merge two list. Complexity: O(M + N) where N length of list1, M length of list2
   *
   * @param list1 first list
   * @param list2 second list
   * @return the long prefix for whole words
   * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">LeetCode</a>
   */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    ListNode p1 = list1, p2 = list2, p3 = new ListNode();
    ListNode result = p3;

    while (p1 != null || p2 != null) {
      Integer x = null;
      Integer y = null;
      Integer val = null;

      if (p1 != null) {
        x = p1.val;
      }

      if (p2 != null) {
        y = p2.val;
      }

      if (x != null && y != null && x <= y) {
        p1 = p1.next;
        val = x;
      } else if (x != null && y == null) {
        p1 = p1.next;
        val = x;
      } else {
        p2 = p2.next;
        val = y;
      }

      p3.val = val;
      if (p1 != null || p2 != null) {
        p3.next = new ListNode();
        p3 = p3.next;
      }
    }

    return result;
  }

  /**
   * Remove Duplicates from Sorted Array. Complexity: O(N)
   *
   * @param nums array
   * @return number
   * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">LeetCode</a>
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    int position = 0;
    int uniqValue = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > uniqValue) {
        int val = nums[i];
        nums[position + 1] = val;
        uniqValue = val;
        position++;
      }
    }

    return position + 1;
  }

  /**
   * Complexity: O(N)
   *
   * @param nums original array
   * @param val  to remove
   * @return count
   * @see <a href="https://leetcode.com/problems/remove-element/">LeetCode</a>
   */
  public int removeElement(int[] nums, int val) {
    if (nums == null) {
      return 0;
    }
    int position = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val && position == -1) {
        position = i;
      } else if (position > -1 && position < nums.length && nums[i] != val) {
        nums[position] = nums[i];
        position++;
      }
    }
    return position == -1 ? nums.length : position;
  }

  /**
   * Algorithm to find search insert position. Complexity: O(log(N))
   *
   * @param nums   array of distinct integers
   * @param target target value
   * @return the index if the target is found. If not, return the index where it would be if it were
   * inserted in order.
   * @see <a href="https://leetcode.com/problems/remove-element/">LeetCode</a>
   */
  public int searchInsert(int[] nums, int target) {
    if (nums == null) {
      return -1;
    } else if (nums.length == 1) {
      if (target <= nums[0]) {
        return 0;
      }
      return 1;
    }

    int left = 1;
    int right = nums.length;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid - 1] < target && target <= nums[mid]) {
        return mid;
      } else if (mid + 1 == nums.length && target > nums[mid]) {
        return nums.length;
      } else if (mid - 1 == 0 && target < nums[mid]) {
        return 0;
      }

      if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return (left + right) / 2;
  }

  /**
   * Find max sum of contiguous  subarray. Complexity O(N) Space Complexity O(1)
   *
   * @param nums original array
   * @return max sum of subarray
   */
  public int maxSumOfSubArray(int[] nums) {
    if (nums == null) {
      return 0;
    }
    int maxSum = nums[0];
    int currentSum = maxSum;
    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i] + currentSum, nums[i]);
      maxSum = Math.max(currentSum, maxSum);
    }
    return maxSum;
  }

  /**
   * Increment large integer represented as an integer array digits
   *
   * @param digits input array with number
   * @return new array
   * @see <a href="https://leetcode.com/problems/remove-element/">LeetCode</a>
   */
  public int[] plusOne(int[] digits) {
    if (digits == null) {
      return null;
    }
    int count = 0;
    int digitsLength = digits.length;
    for (int i = digitsLength - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        break;
      }
      count++;
    }

    if (count == 0) {
      digits[digitsLength - 1] = digits[digitsLength - 1] + 1;
      return digits;
    }

    int index = digitsLength - count;
    if (index == 0) {
      digits = new int[digitsLength + 1];
      digits[0] = 1;
    } else {
      digits[index - 1] = digits[index - 1] + 1;
      for (int i = index; i < digitsLength; i++) {
        digits[i] = 0;
      }
    }
    return digits;
  }

  /**
   * Running Sum of 1d Array
   *
   * @param digits input array with number
   * @return new array of result
   * @see <a href="https://leetcode.com/problems/running-sum-of-1d-array">LeetCode</a>
   */

  public int[] runningSum(int[] digits) {

    if (digits == null || digits.length < 1) {
      return null;
    }

    if (digits.length == 1) {
      return digits;
    }

    int previousSum = digits[0];
    int[] newArray = new int[digits.length];
    newArray[0] = digits[0];

    for (int i = 1; i < digits.length; i++) {
      previousSum += digits[i];
      newArray[i] = previousSum;
    }

    return newArray;
  }

}
