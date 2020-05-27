package leetcode.algorithms;

public class DistributeTreeCoins {

  private int steps;

  public int distributeCoins(TreeNode root) {
    steps = 0;
    dfs(root);
    return steps;
  }

  //返回节点富余coin值
  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    //富余的都要移走
    //需要移动到它中或需要从它移动到它的父亲中的金币数量为 过载量 = Math.abs(num_coins - 1)
    steps += Math.abs(left) + Math.abs(right);
    //自己有的，加上孩子富余的，减去自己用一个
    return root.val + left + right - 1;
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
