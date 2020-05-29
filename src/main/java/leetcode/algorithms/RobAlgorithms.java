package leetcode.algorithms;

public class RobAlgorithms {

  public int rob1(int[] nums) {
    if(nums==null||nums.length==0){
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for(int i=1;i<nums.length;i++){
      dp[i] = Math.max((i>=2?dp[i-2]:0) + nums[i],dp[i-1]);
    }
    return dp[nums.length-1];
  }
  //--------
  public int rob2(int[] nums) {
    if(nums==null||nums.length==0){
      return 0;
    }
    return Math.max(robRange(nums,0,nums.length-2), robRange(nums,1,nums.length-1));
  }
  private int robRange(int[] nums, int start, int end){
    if(start>=nums.length){
      return 0;
    }
    if(end<=start){
      return nums[start];
    }
    int[] dp = new int[nums.length];
    dp[start] = nums[start];
    for(int i=start+1;i<=end;i++){
      dp[i]=Math.max((i>=2?dp[i-2]:0)+nums[i], dp[i-1]);
    }
    return dp[end];
  }

}
