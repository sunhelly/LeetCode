package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DistanceKNodes {
  private Map<TreeNode, TreeNode> parentsMap;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null || target == null || K < 0) {
      return result;
    }
    parentsMap = new HashMap<TreeNode, TreeNode>();
    findParent(root, null);
    Set<TreeNode> seen = new HashSet<TreeNode>();
    seen.add(target);
    Queue<TreeNode> levelNodes = new LinkedList<TreeNode>();
    levelNodes.offer(target);
    while (!levelNodes.isEmpty() && K > 0) {
      int size = levelNodes.size();
      while (size > 0) {
        TreeNode node = levelNodes.poll();
        TreeNode parent = parentsMap.get(node);
        if (parent != null && seen.add(parent)) {
          levelNodes.offer(parent);
        }
        if (node.left != null && seen.add(node.left)) {
          levelNodes.offer(node.left);
        }
        if (node.right != null && seen.add(node.right)) {
          levelNodes.offer(node.right);
        }
        size--;
      }
      K--;
    }
    while (!levelNodes.isEmpty()) {
      result.add(levelNodes.poll().val);
    }
    return result;

  }

  private void findParent(TreeNode child, TreeNode parent) {
    if (child == null) {
      return;
    }
    parentsMap.put(child, parent);
    findParent(child.left, child);
    findParent(child.right, child);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
