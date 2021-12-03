package org.study.algorithms;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class StringAlgorithms {

  /**
   * Algorithm that returns the first non-repeated character in a string. Time Complexity: O(n). As
   * the string need to be traversed at-least once. Auxiliary Space: O(n). Space is occupied by the
   * use of count_array/hash_map to keep track of frequency.
   *
   * @param inputLine original string
   * @return first non-repeated character
   */
  public Character findFirstNonRepeatedCharacter(String inputLine) {
    Map<Character, Integer> map = new LinkedHashMap<>();

    for (char symbol : inputLine.toCharArray()) {
      if (map.containsKey(symbol)) {
        Integer integer = map.get(symbol);
        map.put(symbol, integer + 1);
      } else {
        map.put(symbol, 1);
      }
    }

    Optional<Character> first = map.entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .map(Entry::getKey)
        .findFirst();

    return first.orElse(null);
  }

  /**
   * Algorithm to convert roman format to integer Best Auxiliary Space: O(1) for III, XX, IV, L, C,
   * Bad Auxiliary Space: O(N) 
   *
   * @param input roman format
   * @return int number
   * @see <a href="https://leetcode.com/problems/roman-to-integer/">LeetCode</a>
   */
  public int romanToInt(String input) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    char[] chars = input.toCharArray();
    int i = 0, result = 0, charsLength = chars.length;
    while (i < charsLength) {
      // maximum repeated symbols can be 3 for roman, in this case it skips 3 iteration. Example III - 3
      if (i + 2 < charsLength) {
        Integer first = map.get(chars[i]);
        Integer second = map.get(chars[i + 1]);
        Integer third = map.get(chars[i + 2]);
        if (first.equals(second) && first.equals(third)) {
          result += first * 3;
          i += 3;
          continue;
        }
      }
      // skip 2 iteration for case II,XX,IX,IV
      if (i + 1 < chars.length) {
        Integer first = map.get(chars[i]);
        Integer second = map.get(chars[i + 1]);
        if (first < second) {
          result += second - first;
          i += 2;
          continue;
        } else if (first.equals(second)) {
          result += first * 2;
          i += 2;
          continue;
        }
      }

      result += map.get(chars[i]);
      i++;
    }

    return result;
  }


}
