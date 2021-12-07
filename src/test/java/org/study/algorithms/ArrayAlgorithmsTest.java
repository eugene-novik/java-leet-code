package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    assertEquals(2, arrayAlgorithms.removeDuplicates(new int[] {1,1,2}));
    assertEquals(6, arrayAlgorithms.removeDuplicates(new int[] {1,2,2,3,3,3,4,5,6}));
  }

}