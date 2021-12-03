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
   * Algorithm to convert roman format to integer
   *
   * @param input roman format
   * @return int number
   * @see <a href="https://leetcode.com/problems/roman-to-integer/">LeetCode</a>
   */
  public int romanToInt(String input) {
    Map<Character, Integer> characterToIntMap = new HashMap<>();
    characterToIntMap.put('I', 1);
    characterToIntMap.put('V', 5);
    characterToIntMap.put('X', 10);
    characterToIntMap.put('L', 50);
    characterToIntMap.put('C', 100);
    characterToIntMap.put('D', 500);
    characterToIntMap.put('M', 1000);

    char[] chars = input.toCharArray();
    int i = 0;
    int result = 0;
    while (i < chars.length) {
      if (i + 1 < chars.length) {
        Integer current = characterToIntMap.get(chars[i]);
        Integer next = characterToIntMap.get(chars[i + 1]);
        if (current < next) {
          result = result + next - current;
          i += 2;
          continue;
        }
      }
      result += characterToIntMap.get(chars[i]);
      i++;
    }

    return result;
  }


}
