package com.epi;

import com.epi.BinarySearchTreePrototypeTemplate.BSTNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BSTSortedOrder {
  private static List<Integer> result = new ArrayList<>();

  // @include
  public static void printBSTInSortedOrder(BSTNode<Integer> tree) {
    Stack<BSTNode<Integer>> s = new Stack<>();
    BSTNode<Integer> curr = tree;

    while (!s.isEmpty() || curr != null) {
      if (curr != null) {
        s.push(curr);
        // Going left.
        curr = curr.getLeft();
      } else {
        // Going up.
        curr = s.pop();
        System.out.println(curr.getData());
        // @exclude
        result.add(curr.getData());
        // @include
        // Going right.
        curr = curr.getRight();
      }
    }
  }
  // @exclude

  public static void main(String[] args) {
    //        43
    //    23     47
    //      37      53
    //    29  41
    //     31
    BSTNode<Integer> tree = new BSTNode<>(43);
    tree.setLeft(new BSTNode<>(23));
    tree.getLeft().setRight(new BSTNode<>(37));
    tree.getLeft().getRight().setLeft(new BSTNode<>(29));
    tree.getLeft().getRight().getLeft().setRight(new BSTNode<>(31));
    tree.getLeft().getRight().setRight(new BSTNode<>(41));
    tree.setRight(new BSTNode<>(47));
    tree.getRight().setRight(new BSTNode<>(53));
    printBSTInSortedOrder(tree);
    List<Integer> goldenResult = Arrays.asList(23, 29, 31, 37, 41, 43, 47, 53);
    assert (result.equals(goldenResult));
  }
}
