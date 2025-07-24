package org.study.algorithms;

import java.util.ArrayList;
import java.util.List;

public class TreeAlgorithms {

  /**
   * @param root - root of the tree
   * @param val  - value to find
   * @return sub node of the finding value, if nothing found then null
   */
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (root.val == val) {
      return root;
    }

    if (root.val > val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }

  /**
   * 230. Kth Smallest Element in a BST
   *
   * @param root - root of tree
   * @param k    - number of min element
   * @return
   */
  public int kthSmallestByList(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();

    fillMinValues(root, list);

    return list.get(k - 1);
  }

  private void fillMinValues(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }

    fillMinValues(node.left, list);
    list.add(node.val);
    fillMinValues(node.right, list);
  }

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();

    fillMinValuesByLimit(root, list, k);

    return list.get(k - 1);
  }

  private void fillMinValuesByLimit(TreeNode node, List<Integer> list, int k) {
    if (node == null || list.size() == k) {
      return;
    }

    fillMinValuesByLimit(node.left, list, k);
    list.add(node.val);
    fillMinValuesByLimit(node.right, list, k);
  }

  public int test(TreeNode node, int k) {
    int[] count = new int[]{0};
    int[] result = new int[]{-1};

    findMinValue(node, count, result, k);

    return result[0];
  }

  public void findMinValue(TreeNode node, int[] count, int[] result, int k) {
    if (node == null || count[0] == k) {
      return;
    }

    findMinValue(node.left, count, result, k);
    count[0] = count[0] + 1;
    if (count[0] == k) {
      result[0] = node.val;
    }
    findMinValue(node.right, count, result, k);
  }

}
