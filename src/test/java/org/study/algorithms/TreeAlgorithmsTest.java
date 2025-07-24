package org.study.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeAlgorithmsTest {

  TreeAlgorithms algorithms = new TreeAlgorithms();

  @Test
  void searchBST() {
//    [4,2,7,1,3], 2
    TreeNode one = new TreeNode(1, null, null);
    TreeNode three = new TreeNode(3, null, null);
    TreeNode two = new TreeNode(2, one, three);
    TreeNode seven = new TreeNode(7, null, null);
    TreeNode root = new TreeNode(4, two, seven);

    TreeNode result = algorithms.searchBST(root, 2);
    assertEquals(two, result);

    result = algorithms.searchBST(root, 5);

    assertNull(result);

    result = algorithms.searchBST(root, 7);

    assertEquals(seven, result);
  }

  @Test
  void searchBSTBigTree() {
    TreeNode three = new TreeNode(3);
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7, six, null);
    TreeNode five = new TreeNode(5, three, seven);
    TreeNode fifteen = new TreeNode(15);

    TreeNode root = new TreeNode(10, five, fifteen);

    assertEquals(six, algorithms.searchBST(root, 6));

  }

  @Test
  void kthSmallest() {
    TreeNode three = new TreeNode(3);
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7, six, null);
    TreeNode five = new TreeNode(5, three, seven);
    TreeNode fifteen = new TreeNode(15);

    TreeNode root = new TreeNode(10, five, fifteen);

    assertEquals(6, algorithms.kthSmallestByList(root, 3));
    assertEquals(6, algorithms.kthSmallest(root, 3));
  }

  @Test
  void kthSmallestMin() {
    TreeNode root = new TreeNode(1);
    assertEquals(1, algorithms.kthSmallestByList(root, 1));
    assertEquals(1, algorithms.kthSmallest(root, 1));
  }

  @Test
  void kthSmallestOnlyLeftChild() {
    TreeNode root = new TreeNode(2, new TreeNode(1), null);
    assertEquals(1, algorithms.kthSmallestByList(root, 1));
    assertEquals(2, algorithms.kthSmallestByList(root, 2));

    assertEquals(1, algorithms.kthSmallest(root, 1));
    assertEquals(2, algorithms.kthSmallest(root, 2));
  }

  @Test
  void kthSmallestOnlyRightChild() {
    TreeNode root = new TreeNode(2, null, new TreeNode(3));
    assertEquals(2, algorithms.kthSmallestByList(root, 1));
    assertEquals(3, algorithms.kthSmallestByList(root, 2));

    assertEquals(2, algorithms.kthSmallest(root, 1));
    assertEquals(3, algorithms.kthSmallest(root, 2));
  }

  @Test
  void kthSmallestNotBalanced() {

    TreeNode root = new TreeNode(5,
        new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
        new TreeNode(6)
    );

    assertEquals(1, algorithms.kthSmallestByList(root, 1));
    assertEquals(3, algorithms.kthSmallestByList(root, 3));
    assertEquals(6, algorithms.kthSmallestByList(root, 6));

    assertEquals(1, algorithms.kthSmallest(root, 1));
    assertEquals(3, algorithms.kthSmallest(root, 3));
    assertEquals(6, algorithms.kthSmallest(root, 6));
  }

  @Test
  void test() {
    TreeNode three = new TreeNode(3);
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7, six, null);
    TreeNode five = new TreeNode(5, three, seven);
    TreeNode fifteen = new TreeNode(15);

    TreeNode root = new TreeNode(10, five, fifteen);

    assertEquals(6, algorithms.test(root, 3));
  }
}