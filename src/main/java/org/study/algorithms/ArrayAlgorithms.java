package org.study.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

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

  /**
   * 876. Middle of the Linked List. Given the head of a singly linked list, return the middle node
   * of the linked list.
   * <p>
   * If there are two middle nodes, return the second middle node.
   *
   * @param head original list not
   * @return middle of the Linked List
   */
  public ListNode middleNode(ListNode head) {
    ListNode middleNode = head;
    ListNode end = head;

    while (end != null && end.next != null) {
      middleNode = middleNode.next;
      end = end.next.next;
    }

    return middleNode;
  }

  public ListNode deleteNextElementAfterMiddleAndReturnOriginal(ListNode head) {
    ListNode previousNode = null;
    ListNode middleNode = head;
    ListNode end = head;

    while (end != null && end.next != null) {
      previousNode = middleNode;
      middleNode = middleNode.next;
      end = end.next.next;
    }

    //deleteNextElementAfterMiddle
    previousNode.next = middleNode.next;

    return head;
  }

  /**
   * Two Sum (LeetCode #1)
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> numsMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (numsMap.containsKey(complement)) {
        return new int[]{numsMap.get(complement), i};
      }

      numsMap.put(nums[i], i);

    }

    return null;
  }

  public int[] twoSumSorted(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    int left = 0, right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        return new int[]{left, right};
      }

      if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return null;
  }

  /**
   * Move Zeroes (LeetCode #283)
   *
   * @param original
   * @return
   */
  public int[] moveZeros(int[] original) {
    if (original.length < 2) {
      return original;
    }

    int first = 0, second = 1;

    while (second < original.length) {
      if (original[first] == 0 && original[second] != 0) {
        swapValue(original, first, second);
        first++;
        second++;
      } else if (original[first] != 0) {
        first++;
        second++;
      } else if (original[second] == 0) {
        second++;
      }
    }

    return original;
  }

  private void swapValue(int[] array, int i, int j) {
    int element = array[i];
    array[i] = array[j];
    array[j] = element;
  }

  /**
   * Container With Most Water (LeetCode #11)
   *
   * @param input
   * @return
   */
  public int maxArea(int[] input) {
    if (input == null || input.length < 2) {
      return 0;
    }

    int left = 0, right = input.length - 1;

    int maxArea = 0;
    while (left != right) {
      int height = Math.min(input[left], input[right]);
      int width = right - left;
      int newArea = height * width;

      if (newArea > maxArea) {
        maxArea = newArea;
      }

      if (input[left] <= input[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxArea;
  }

  /**
   * Intersection of Two Arrays II (LeetCode #350)
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int pointer1 = 0, pointer2 = 0;
    int end1 = nums1.length - 1, end2 = nums2.length - 1;

    List<Integer> result = new ArrayList<>();
    while (pointer1 <= end1 && pointer2 <= end2) {

      int value1 = nums1[pointer1];
      int value2 = nums2[pointer2];

      if (value1 == value2) {
        result.add(value1);
        pointer1++;
        pointer2++;
      } else if (value1 < value2) {
        pointer1++;
      } else {
        pointer2++;
      }

    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  public int[] intersect2(int[] nums1, int[] nums2) {
    Map<Integer, Integer> numberCountMap = toNumberCountMap(nums1);

    List<Integer> result = new ArrayList<>();

    for (int i : nums2) {
      Integer count = numberCountMap.getOrDefault(i, 0);

      if (count > 0) {
        result.add(i);
        numberCountMap.put(i, count - 1);
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private Map<Integer, Integer> toNumberCountMap(int[] nums1) {
    Map<Integer, Integer> result = new HashMap<>();

    for (int i : nums1) {
      Integer count = result.getOrDefault(i, 0);
      result.put(i, count + 1);
    }

    return result;
  }

  /**
   * Merge Intervals (LeetCode #56)
   *
   * @param intervals
   * @return
   */
  public int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    List<int[]> result = new ArrayList<>();

    int start = intervals[0][0];
    int end = intervals[0][1];

    // [1,4] [3,6] [8,10] [12,14]

    for (int i = 1; i < intervals.length; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];

      if (currentStart <= end) {
        end = Math.max(end, currentEnd);
      } else {
        result.add(new int[]{start, end});
        start = currentStart;
        end = currentEnd;
      }
    }

    result.add(new int[]{start, end});

    return result.toArray(new int[0][]);

  }

  public int findPositionByBinarySearch(int[] array, int element) {
    if (array == null) {
      return -1;
    }

    int left = 0, right = array.length - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (array[middle] == element) {
        return middle;
      }

      if (array[middle] > element) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }

  /**
   * 147. Insertion Sort List
   *
   * @param head - single linked list
   * @return - sorted single linked list
   */
  public ListNode insertionSortList(ListNode head) {
    ListNode next = head.next;
    ListNode root = head;

    while (next != null) {
      while (root != next) {
        if (root.val > next.val) {
          swapValue(root, next);
        }
        root = root.next;
      }

      next = next.next;
      root = head;
    }

    return head;
  }

  private void swapValue(ListNode one, ListNode second) {
    int value = one.val;

    one.val = second.val;
    second.val = value;
  }


  public void sortByPriorityQueue(int[] array) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int i : array) {
      heap.add(i);
    }

    Integer min = heap.poll();
    int i = 0;

    while (min != null) {
      array[i] = min;
      min = heap.poll();
      i++;
    }
  }

  /**
   * 912. Sort an Array
   *
   * @param array
   */
  public void sortByHip(int[] array) {
    for (int index = (array.length - 2) / 2; index >= 0; index--) {
      heapifyAtIndex(array, array.length, index);
    }

    for (int index = array.length - 1; index > 0; index--) {
      int temp = array[index];
      array[index] = array[0];
      array[0] = temp;
      heapifyAtIndex(array, index, 0);
    }
  }

  private void heapifyAtIndex(int[] array, int heapSize, int index) {
    int left = index * 2 + 1;
    int right = index * 2 + 2;

    int largest = index;

    if (left < heapSize && array[left] > array[largest]) {
      largest = left;
    }

    if (right < heapSize && array[right] > array[largest]) {
      largest = right;
    }

    if (largest != index) {
      int temp = array[index];
      array[index] = array[largest];
      array[largest] = temp;
      heapifyAtIndex(array, heapSize, largest);
    }
  }

  /**
   * 215. Kth Largest Element in an Array
   *
   * @param nums - original array
   * @param k    - number of max element
   * @return - Kth Largest Element
   */
  public int findKthLargest(int[] nums, int k) {
    if (k > nums.length) {
      return -1;
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    for (int x : nums) {
      priorityQueue.add(x);
      if (priorityQueue.size() > k) {
        priorityQueue.remove();
      }
    }

    return priorityQueue.peek();
  }

  /**
   * Sort Colors
   *
   * @param array
   */
  public void countingSort(int[] array) {
    if (array.length < 1) {
      return;
    }

    int min = array[0];
    int max = array[0];

    for (int i : array) {
      if (i > max) {
        max = i;
      }
      if (i < min) {
        min = i;
      }
    }

    int range = max - min + 1;
    int[] count = new int[range];

    for (int i : array) {
      count[i - min]++;
    }

    int index = 0;
    for (int i = 0; i < range; i++) {
      int times = count[i];

      while (times > 0) {
        array[index] = i + min;
        index++;
        times--;
      }
    }
  }

  /**
   * from real interview Merge an array of rectangles in the format { x, y, width, height } into a
   * single rectangle, i.e. return the smallest rectangle that includes all the rectangles in the
   * array.
   *
   * @param rectangles - list of rectangle
   * @return the smallest rectangle that contains all rectangles inside
   */
  public Rectangle mergeRectanglesToSmallestRectangle(List<Rectangle> rectangles) {
    if (rectangles == null || rectangles.isEmpty()) {
      return null;
    }

    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    int maxWidth = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;

    for (Rectangle rectangle : rectangles) {
      if (minX > rectangle.getX()) {
        minX = rectangle.getX();
      }
      if (minY > rectangle.getY()) {
        minY = rectangle.getY();
      }

      int nextMaxWidth = rectangle.getX() + rectangle.getWidth();
      int nextMaxHeight = rectangle.getY() + rectangle.getHeight();

      if (maxWidth < nextMaxWidth) {
        maxWidth = nextMaxWidth;
      }
      if (maxHeight < nextMaxHeight) {
        maxHeight = nextMaxHeight;
      }
    }

    return new Rectangle(minX, minY, maxWidth - minX, maxHeight - minY);
  }

  /**
   * 84 Largest Rectangle in Histogram
   * Given an array of integers heights representing the histogram's bar height
   * where the width of each bar is 1, return the area of the largest rectangle in the histogram.
   *
   * @param heights array of numbers
   * @return the largest rectangle area
   */
  public int largestRectangleArea(int[] heights) {
    if (heights.length == 1) {
      return heights[0];
    }

    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;

    for (int i = 0; i < heights.length; i++) {
      int currentHeight = heights[i];

      while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
        int topIndex = stack.pop();
        int height = heights[topIndex];

        int leftIndex = stack.isEmpty() ? -1 : stack.peek();
        int width = i - leftIndex - 1;

        int area = height * width;
        maxArea = Math.max(maxArea, area);
      }

      stack.push(i);
    }

    while (!stack.isEmpty()) {
      int topIndex = stack.pop();
      int height = heights[topIndex];
      int leftIndex = stack.isEmpty() ? -1 : stack.peek();
      int width = heights.length - leftIndex - 1;
      int area = height * width;
      maxArea = Math.max(maxArea, area);
    }

    return maxArea;
  }



}



