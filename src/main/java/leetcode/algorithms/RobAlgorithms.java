package leetcode.algorithms;

public class RobAlgorithms {

  // rob binary tree
  // 每个node计算偷不偷两种结果，偷：孩子不偷+自己，不偷：左偷或不偷最大值+右偷或不偷的最大值
  public int rob(TreeNode root) {
    int[] result = robNode(root);
    return Math.max(result[0], result[1]);
  }

  private int[] robNode(TreeNode node) {
    int[] result = new int[2];
    if (node == null) {
      return result;
    }
    int[] robLeft = robNode(node.left);
    int[] robRight = robNode(node.right);

    //这句表示自己不偷的时候，孩子可以选择偷或不偷
    result[0] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
    //这句就表明自己偷了孩子就不可以偷
    result[1] = robLeft[0] + robRight[0] + node.val;
    return result;
  }

  //----------------------
  public int rob1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max((i >= 2 ? dp[i - 2] : 0) + nums[i], dp[i - 1]);
    }
    return dp[nums.length - 1];
  }

  //--------
  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
  }

  private int robRange(int[] nums, int start, int end) {
    if (start >= nums.length) {
      return 0;
    }
    if (end <= start) {
      return nums[start];
    }
    int[] dp = new int[nums.length];
    dp[start] = nums[start];
    for (int i = start + 1; i <= end; i++) {
      dp[i] = Math.max((i >= 2 ? dp[i - 2] : 0) + nums[i], dp[i - 1]);
    }
    return dp[end];
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
