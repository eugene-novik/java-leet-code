package org.study.algorithms;

import java.util.Stack;

public class TemperatureAlgorithm {

  /**
   * Given an array of integers temperatures represents the daily temperatures, return an array
   * answer such that answer[i] is the number of days you have to wait after the ith day to get a
   * warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0
   * instead. Time Complexity: O(n^2)
   *
   * @param days array with temperature
   * @return result array
   * @see <a href="https://leetcode.com/problems/daily-temperatures/">LeetCode</a>
   */
  public int[] temperaturesByBruteForce(int[] days) {
    if (days == null || days.length < 1) {
      return null;
    }
    int[] result = new int[days.length];
    for (int i = 0; i < days.length; i++) {
      for (int j = i + 1; j < result.length; j++) {
        if (days[j] > days[i]) {
          result[i] = j - i;
          break;
        }

      }
    }
    return result;
  }

  /**
   * Given an array of integers temperatures represents the daily temperatures, return an array
   * answer such that answer[i] is the number of days you have to wait after the ith day to get a
   * warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0
   * instead. Time Complexity: O(n)
   *
   * @param days array with temperature
   * @return result array
   * @see <a href="https://leetcode.com/problems/daily-temperatures/">LeetCode</a>
   */
  public int[] temperaturesByStack(int[] days) {
    if (days == null || days.length < 1) {
      return null;
    }
    Stack<Pointer> stack = new Stack<>();
    int[] result = new int[days.length];
    for (int i = days.length - 1; i >= 0; i--) {
      int temperature = days[i];
      while (!stack.isEmpty() && stack.peek().getTemperature() <= temperature) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        result[i] = stack.peek().getIndex() - i;
      }
      stack.push(new Pointer(i, temperature));
    }
    return result;
  }

  private class Pointer {

    private int index;
    private int temperature;

    public Pointer(int index, int temperature) {
      this.index = index;
      this.temperature = temperature;
    }

    public int getIndex() {
      return index;
    }

    public int getTemperature() {
      return temperature;
    }
  }
}
