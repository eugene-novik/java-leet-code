package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringAlgorithmsTest {

  private StringAlgorithms stringAlgorithms;

  @BeforeEach
  void setUp() {
    stringAlgorithms = new StringAlgorithms();
  }

  @Test
  public void firstNonRepeatedCharacterTest() {
    assertEquals('B', stringAlgorithms.findFirstNonRepeatedCharacter("ABCA"));
    assertNull(stringAlgorithms.findFirstNonRepeatedCharacter("BCABAC"));
    assertEquals('B', stringAlgorithms.findFirstNonRepeatedCharacter("BAC"));
    assertEquals('O', stringAlgorithms.findFirstNonRepeatedCharacter("GlovoOnGlovo"));
    assertEquals('W',
        stringAlgorithms
            .findFirstNonRepeatedCharacter("What is the first non-repeated character?"));

  }

}