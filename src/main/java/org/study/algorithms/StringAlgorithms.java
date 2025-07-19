package org.study.algorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Stack;
import java.util.TreeMap;

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


  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
   * the input string is valid. Auxiliary Space: O(N)
   *
   * @param input original string
   * @return true if Parentheses valid
   * @see <a href="https://leetcode.com/problems/valid-parentheses/">LeetCode</a>
   */
  public boolean isValidParentheses(String input) {
    if ("".equals(input) || input == null) {
      return false;
    }

    Map<Character, Character> parentheses = new HashMap<>();
    parentheses.put('{', '}');
    parentheses.put('(', ')');
    parentheses.put('[', ']');

    Stack<Character> stack = new Stack<>();

    char[] chars = input.toCharArray();

    for (char next : chars) {
      if (!stack.isEmpty()) {
        if (parentheses.containsKey(next)) {
          stack.push(next);
          continue;
        }
        Character key = stack.peek();
        Character value = parentheses.get(key);
        if (value != null && value.equals(next)) {
          stack.pop();
        } else {
          break;
        }
      } else {
        stack.push(next);
      }
    }

    return stack.isEmpty();
  }

  /**
   * Write own strStar or indexOf
   *
   * @param haystack original string
   * @param needle   element to find
   * @return first position of needle
   * @see <a href="https://leetcode.com/problems/implement-strstr/">LeetCode</a>
   */
  public int strStr(String haystack, String needle) {
    if (needle == null || "".equals(needle)) {
      return 0;
    }
    int start = 0;
    int end = needle.length();
    while (end <= haystack.length()) {
      if (needle.equals(haystack.substring(start, end))) {
        return start;
      }
      start++;
      end++;
    }

    return -1;
  }

  public int lengthOfLastWord(String s) {
    if (s == null) {
      return -1;
    }
    if ("".equals(s)) {
      return 0;
    }

    char[] chars = s.toCharArray();

    int start = -1, end = -1;
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] != ' ' && end == -1) {
        end = i;
      }
      if (chars[i] == ' ' && end != -1) {
        start = i;
      }
      if (end > start && start > -1) {
        break;
      }
    }

    if (end == -1) {
      return chars.length;
    } else {
      return end - start;
    }
  }

  /**
   * @param s        string without space
   * @param wordDict a dictionary of strings
   * @return all such possible sentences depends on the dictionary
   * @see <a href="https://leetcode.com/problems/word-break-ii/description/">LeetCode</a>
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    //todo: implement latter when will learn more :)
    return null;
  }

  /**
   * 383. Ransom Note. Given two strings ransomNote and magazine, return true if ransomNote can be
   * constructed by using the letters from magazine and false otherwise.
   * <p>
   * Each letter in magazine can only be used once in ransomNote.
   *
   * @param ransomNote - word to build by magazine chars
   * @param magazine   - magazine with chars
   * @return true if it is possible, false it is not;
   * @see <a href="https://leetcode.com/problems/ransom-note/">LeetCode</a>
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> charCounts = new HashMap<>();

    for (int i = 0; i < magazine.length(); i++) {
      char charAt = magazine.charAt(i);
      int currentCount = charCounts.getOrDefault(charAt, 0);
      charCounts.put(charAt, currentCount + 1);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char charAt = ransomNote.charAt(i);

      int currentCount = charCounts.getOrDefault(charAt, 0);

      if (currentCount == 0) {
        return false;
      }

      charCounts.put(charAt, currentCount - 1);
    }

    return true;
  }

  /**
   * Reverse String (LeetCode #344)
   * @param s
   */
  public void reverseString(char[] s) {
    if (s == null || s.length < 2) {
      return;
    }

    int left = 0, right = s.length - 1;

    while (left < right) {
      char swap = s[left];
      s[left] = s[right];
      s[right] = swap;
      left++;
      right--;
    }

  }

  /**
   * Valid Anagram (LeetCode #242)
   *
   * @param s
   * @param t
   * @return
   */
  public  boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> characterCountOriginal = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char element = s.charAt(i);
      Integer count = characterCountOriginal.getOrDefault(element, 0);

      characterCountOriginal.put(element, count + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      char element = t.charAt(i);
      Integer numberCheck = characterCountOriginal.getOrDefault(element, 0);

      if (numberCheck > 0) {
        characterCountOriginal.put(element, numberCheck - 1);
      } else {
        return false;
      }
    }

    return true;
  }


}
