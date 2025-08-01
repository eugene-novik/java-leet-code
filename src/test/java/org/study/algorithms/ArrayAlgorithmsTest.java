package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
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

  @Test
  public void testFindTwoElementsWhereSumEqualsTargetBrutForce() {
    // Because nums[0] + nums[1] == 9, return [0, 1].
    assertArrayEquals(new int[]{0, 1},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetBrutForce(new int[]{2, 7, 11, 15}, 9));
    // Because nums[1] + nums[2] == 6 return [1,2]
    assertArrayEquals(new int[]{1, 2},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetBrutForce(new int[]{3, 2, 4}, 6));
    // Because nums[0] + nums[1] == 6 return [0,1]
    assertArrayEquals(new int[]{0, 1},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetBrutForce(new int[]{3, 3}, 6));
  }

  @Test
  public void testFindTwoElementsWhereSumEqualsTargetByMap() {
    // Because nums[0] + nums[1] == 9, return [0, 1].
    assertArrayEquals(new int[]{0, 1},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetByMap(new int[]{2, 7, 11, 15}, 9));
    // Because nums[1] + nums[2] == 6 return [1,2]
    assertArrayEquals(new int[]{1, 2},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetByMap(new int[]{3, 2, 4}, 6));
    // Because nums[0] + nums[1] == 6 return [0,1]
    assertArrayEquals(new int[]{0, 1},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetByMap(new int[]{3, 3}, 6));

    // Because nums[0] + nums[1] == 9, return [0, 1].
    assertArrayEquals(new int[]{0, 1},
        arrayAlgorithms
            .findTwoElementsWhereSumEqualsTargetByAnotherMap(new int[]{2, 7, 11, 15}, 9));
    // Because nums[1] + nums[2] == 6 return [1,2]
    assertArrayEquals(new int[]{1, 2},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetByAnotherMap(new int[]{3, 2, 4}, 6));
    // Because nums[0] + nums[1] == 6 return [0,1]
    assertArrayEquals(new int[]{0, 1},
        arrayAlgorithms.findTwoElementsWhereSumEqualsTargetByAnotherMap(new int[]{3, 3}, 6));

  }

  @Test
  public void testFindLongestCommonPrefix() {
    assertEquals("",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    assertEquals("fl",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    assertEquals("", arrayAlgorithms.findLongestCommonPrefix(new String[]{""}));
    assertEquals("dog",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"dog", "dog", "dog"}));
    assertEquals("",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"", "dog", "dog"}));

    assertEquals("12",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"123", "12", "12asd"}));

    assertEquals("a",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"a"}));
  }

  @Test
  public void testFindLongestCommonPrefixBinarySearch() {
    assertEquals("",
        arrayAlgorithms.findLongestCommonPrefixBinarySearch(new String[]{"dog", "racecar", "car"}));
    assertEquals("fl",
        arrayAlgorithms
            .findLongestCommonPrefixBinarySearch(new String[]{"flower", "flow", "flight"}));
    assertEquals("", arrayAlgorithms.findLongestCommonPrefixBinarySearch(new String[]{""}));
    assertEquals("dog",
        arrayAlgorithms.findLongestCommonPrefixBinarySearch(new String[]{"dog", "dog", "dog"}));
    assertEquals("",
        arrayAlgorithms.findLongestCommonPrefixBinarySearch(new String[]{"", "dog", "dog"}));

    assertEquals("12",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"123", "12", "12asd"}));

    assertEquals("a",
        arrayAlgorithms.findLongestCommonPrefix(new String[]{"a"}));


  }

  @Test
  public void testMergeTwoList() {
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(2);
    node1.next.next = new ListNode(4);

    ListNode node2 = new ListNode(1);
    node2.next = new ListNode(3);
    node2.next.next = new ListNode(4);

    arrayAlgorithms.mergeTwoLists(node1, node2);

    node1 = new ListNode(2);
    node2 = new ListNode(1);

    arrayAlgorithms.mergeTwoLists(node1, node2);

  }

  @Test
  public void testRemoveDuplicates() {
    assertEquals(2, arrayAlgorithms.removeDuplicates(new int[]{1, 1, 2}));
    assertEquals(6, arrayAlgorithms.removeDuplicates(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 6}));
  }

  @Test
  public void testRemoveElement() {
    assertEquals(5, arrayAlgorithms.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    assertEquals(1, arrayAlgorithms.removeElement(new int[]{2}, 3));
  }


  @Test
  public void testSearchInsert() {
    assertEquals(3, arrayAlgorithms.searchInsert(new int[]{1, 2, 3, 5, 6}, 5));
    assertEquals(7, arrayAlgorithms.searchInsert(new int[]{1, 3, 5, 6, 8, 9, 10, 15}, 15));
    assertEquals(2, arrayAlgorithms.searchInsert(new int[]{1, 3, 5, 6}, 5));

    assertEquals(1, arrayAlgorithms.searchInsert(new int[]{1, 3, 5, 6}, 2));
    assertEquals(4, arrayAlgorithms.searchInsert(new int[]{1, 3, 5, 6}, 7));
    assertEquals(0, arrayAlgorithms.searchInsert(new int[]{1, 3, 5, 6}, 0));
    assertEquals(0, arrayAlgorithms.searchInsert(new int[]{1}, 0));
    assertEquals(1, arrayAlgorithms.searchInsert(new int[]{5}, 10));
    assertEquals(0, arrayAlgorithms.searchInsert(new int[]{1, 3}, 0));
  }

  @Test
  public void testMaxSumOfSubArrayTest() {
    assertEquals(6, arrayAlgorithms.maxSumOfSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    assertEquals(3, arrayAlgorithms.maxSumOfSubArray(new int[]{1, 1, 1}));
    assertEquals(23, arrayAlgorithms.maxSumOfSubArray(new int[]{5, 4, -1, 7, 8}));
  }

  @Test
  public void plusOneTest() {
    assertArrayEquals(new int[]{8}, arrayAlgorithms.plusOne(new int[]{7}));
    assertArrayEquals(new int[]{1, 2, 4}, arrayAlgorithms.plusOne(new int[]{1, 2, 3}));
    assertArrayEquals(new int[]{4, 3, 2, 2}, arrayAlgorithms.plusOne(new int[]{4, 3, 2, 1}));
    assertArrayEquals(new int[]{1}, arrayAlgorithms.plusOne(new int[]{0}));
    assertArrayEquals(new int[]{1}, arrayAlgorithms.plusOne(new int[]{0}));
    assertArrayEquals(new int[]{1, 0}, arrayAlgorithms.plusOne(new int[]{9}));
    assertArrayEquals(new int[]{1, 0, 0, 0, 0}, arrayAlgorithms.plusOne(new int[]{9, 9, 9, 9}));
    assertArrayEquals(new int[]{1, 1, 0, 0, 0}, arrayAlgorithms.plusOne(new int[]{1, 0, 9, 9, 9}));
  }

  @Test
  public void runningSum() {
    assertArrayEquals(new int[]{1, 3, 6, 10}, arrayAlgorithms.runningSum(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{1, 2, 3, 4, 5},
        arrayAlgorithms.runningSum(new int[]{1, 1, 1, 1, 1}));
    assertArrayEquals(new int[]{3, 4, 6, 16, 17},
        arrayAlgorithms.runningSum(new int[]{3, 1, 2, 10, 1}));
  }

  @Test
  void middleNodeOne() {
    ListNode five = new ListNode(5);
    ListNode four = new ListNode(4, five);
    ListNode three = new ListNode(3, four);
    ListNode two = new ListNode(2, three);
    ListNode one = new ListNode(1, two);

    arrayAlgorithms.middleNode(one);
  }

  @Test
  void middleNodeTwo() {
//    ListNode six = new ListNode(6);
    ListNode five = new ListNode(5);
    ListNode four = new ListNode(4, five);
    ListNode three = new ListNode(3, four);
    ListNode two = new ListNode(2, three);
    ListNode one = new ListNode(1, two);

//    arrayAlgorithms.middleNode(one);
    arrayAlgorithms.deleteNextElementAfterMiddleAndReturnOriginal(one);
  }

  @Test
  void twoSumAndTwoSumSorted() {
    int[] expectedPositionOfElements = {0, 1};
    assertArrayEquals(expectedPositionOfElements,
        arrayAlgorithms.twoSum(new int[]{1, 5, 6, 7}, 6));
    assertArrayEquals(expectedPositionOfElements,
        arrayAlgorithms.twoSumSorted(new int[]{1, 5, 6, 7}, 6));
  }

  @Test
  void moveZeros() {
    int[] expected = new int[]{1, 3, 12, 0, 0};
    assertArrayEquals(expected, arrayAlgorithms.moveZeros(new int[]{0, 1, 0, 3, 12}));
  }

  @Test
  void maxArea() {
    assertEquals(49, arrayAlgorithms.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, arrayAlgorithms.maxArea(new int[]{1, 1}));
    assertEquals(16, arrayAlgorithms.maxArea(new int[]{4, 3, 2, 1, 4}));
    assertEquals(2, arrayAlgorithms.maxArea(new int[]{1, 2, 1}));
    assertEquals(20, arrayAlgorithms.maxArea(new int[]{15, 5, 5, 5, 5}));
    assertEquals(6, arrayAlgorithms.maxArea(new int[]{1, 2, 3, 4, 5}));
    assertEquals(6, arrayAlgorithms.maxArea(new int[]{5, 4, 3, 2, 1}));
  }

  @Test
  void intersectFirstAndSecond() {
    assertArrayEquals(new int[]{4, 9},
        arrayAlgorithms.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    assertArrayEquals(new int[]{2, 2},
        arrayAlgorithms.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    assertArrayEquals(new int[]{2, 2},
        arrayAlgorithms.intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
  }

  @Test
  void mergeIntervals() {

    int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = arrayAlgorithms.mergeIntervals(input);

    for (int[] i : result) {
      System.out.println(Arrays.toString(i));
    }

    int[][] input2 = new int[][]{{1, 4}, {4, 5}};
    int[][] result2 = arrayAlgorithms.mergeIntervals(input2);

    for (int[] i : result2) {
      System.out.println(Arrays.toString(i));
    }
  }

  @Test
  void findPositionByBinarySearch() {
    int[] array = new int[]{5, 8, 12, 15, 29, 40};

    assertEquals(0, arrayAlgorithms.findPositionByBinarySearch(array, 5));
    assertEquals(1, arrayAlgorithms.findPositionByBinarySearch(array, 8));
    assertEquals(2, arrayAlgorithms.findPositionByBinarySearch(array, 12));
    assertEquals(3, arrayAlgorithms.findPositionByBinarySearch(array, 15));
    assertEquals(4, arrayAlgorithms.findPositionByBinarySearch(array, 29));
    assertEquals(5, arrayAlgorithms.findPositionByBinarySearch(array, 40));
    assertEquals(-1, arrayAlgorithms.findPositionByBinarySearch(array, 100));

  }

  @Test
  void insertionSortList() {
    ListNode third = new ListNode(2);
    ListNode second = new ListNode(4, third);
    ListNode root = new ListNode(10, second);

    arrayAlgorithms.insertionSortList(root);

    int[] expectedOrder = new int[]{2, 4, 10};

    int i = 0;
    ListNode result = root;
    while (result != null) {
      assertEquals(expectedOrder[i], result.val);

      i++;
      result = result.next;
    }

  }

  @Test
  void sortByHeap() {
    int[] input = {10, 14, 18, 3, 2};
    int[] expected = {2, 3, 10, 14, 18};

    arrayAlgorithms.sortByPriorityQueue(input);

    assertArrayEquals(expected, input);
  }

  @Test
  void findKthLargest() {
    int[] input = {10, 14, 18, 2, 1, 7, 0};
    int expected = 10;

    assertEquals(expected, arrayAlgorithms.findKthLargest(input, 3));
  }

  @Test
  void countingSort() {
    int[] input = {10, 14, 18, 2, 1, 7, 0};
    int[] expected = {0, 1, 2, 7, 10, 14, 18};

    arrayAlgorithms.countingSort(input);

    assertArrayEquals(expected, input);
  }

  @Test
  void testNullInput() {
    assertNull(arrayAlgorithms.mergeRectanglesToSmallestRectangle(null));
  }

  @Test
  void testSingleRectangle() {
    Rectangle r = new Rectangle(1, 2, 3, 4);
    Rectangle result = arrayAlgorithms.mergeRectanglesToSmallestRectangle(List.of(r));
    assertEquals(r, result);
  }

  @Test
  void testTwoNonOverlappingRectangles() {
    Rectangle r1 = new Rectangle(0, 0, 10, 10);
    Rectangle r2 = new Rectangle(20, 20, 5, 5);
    Rectangle expected = new Rectangle(0, 0, 25, 25);
    Rectangle result = arrayAlgorithms.mergeRectanglesToSmallestRectangle(List.of(r1, r2));
    assertEquals(expected, result);
  }

  @Test
  void testOverlappingRectangles() {
    Rectangle r1 = new Rectangle(0, 0, 10, 10);
    Rectangle r2 = new Rectangle(5, 5, 10, 10);
    Rectangle expected = new Rectangle(0, 0, 15, 15);
    Rectangle result = arrayAlgorithms.mergeRectanglesToSmallestRectangle(List.of(r1, r2));
    assertEquals(expected, result);
  }

  @Test
  void testNegativeCoordinates() {
    Rectangle r1 = new Rectangle(-10, -10, 5, 5);
    Rectangle r2 = new Rectangle(0, 0, 5, 5);
    Rectangle expected = new Rectangle(-10, -10, 15, 15);
    Rectangle result = arrayAlgorithms.mergeRectanglesToSmallestRectangle(List.of(r1, r2));
    assertEquals(expected, result);
  }

  @Test
  void testMultipleRectangles() {
    Rectangle r1 = new Rectangle(4, 0, 12, 6);
    Rectangle r2 = new Rectangle(18, 7, 12, 6);
    Rectangle r3 = new Rectangle(0, 12, 12, 6);
    Rectangle expected = new Rectangle(0, 0, 30, 18);
    Rectangle result = arrayAlgorithms.mergeRectanglesToSmallestRectangle(List.of(r1, r2, r3));
    assertEquals(expected, result);
  }

  @Test
  void largestRectangleArea() {
    int[] input = {4, 2, 0, 3, 2, 4, 3, 4};
    int[] input2 = {2, 1, 5, 6, 2, 3};
    int expected = 10;

    assertEquals(expected, arrayAlgorithms.largestRectangleArea(input));
    assertEquals(expected, arrayAlgorithms.largestRectangleArea(input2));
  }

}