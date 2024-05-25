package org.study.algorithms;

public class NumberAlgorithms {

  /**
   * An integer is a palindrome when it reads the same backward as forward. For example, 121 is
   * palindrome while 123 is not.
   *
   * @param x number
   * @return true if the number is polindrome
   */
  public boolean isPalindromeByString(int x) {
    String value = String.valueOf(x);
    StringBuilder builder = new StringBuilder(value);
    builder.reverse();
    String reverseValue = builder.toString();
    return value.equals(reverseValue);
  }

  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int revertedNumber = 0, originNumber = x;

    while (x != 0) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x = x / 10;
    }

    return originNumber == revertedNumber;
  }

  /**
   * Number of Steps to Reduce a Number to Zero. Given an integer num, return the number of steps to
   * reduce it to zero.
   * <p>
   * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to
   * subtract 1 from it.
   *
   * @param number original number
   * @return number of space
   */
  public int numberOfSteps(int number) {
    int steps = 0;

    while (number > 0) {
      if (number % 2 == 0) {
        number /= 2;
      } else {
        number --;
      }

      steps++;
    }

    return steps;
  }

}
