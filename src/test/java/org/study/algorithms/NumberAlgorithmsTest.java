package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberAlgorithmsTest {
  
  private NumberAlgorithms numberAlgorithms;

  @BeforeEach
  void setUp() {
    numberAlgorithms = new NumberAlgorithms();
  }

  @Test
  void isPalindromeByString() {
    assertTrue(numberAlgorithms.isPalindromeByString(121));
    assertTrue(numberAlgorithms.isPalindromeByString(77277));
    assertTrue(numberAlgorithms.isPalindromeByString(1441));
    
    assertFalse(numberAlgorithms.isPalindromeByString(123));
    assertFalse(numberAlgorithms.isPalindromeByString(5546140));
    assertFalse(numberAlgorithms.isPalindromeByString(-121));
    
  }

  @Test
  void isPalindrome() {
    assertTrue(numberAlgorithms.isPalindrome(121));
    assertTrue(numberAlgorithms.isPalindrome(77277));
    assertTrue(numberAlgorithms.isPalindrome(1441));

    assertFalse(numberAlgorithms.isPalindrome(123));
    assertFalse(numberAlgorithms.isPalindrome(5546140));
    assertFalse(numberAlgorithms.isPalindrome(-121));

  }

  @Test
  void numberOfSteps() {
    assertEquals(6, numberAlgorithms.numberOfSteps(14));
    assertEquals(4, numberAlgorithms.numberOfSteps(8));
    assertEquals(12, numberAlgorithms.numberOfSteps(123));
  }
}