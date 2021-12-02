package org.study.algorithms;


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


}
