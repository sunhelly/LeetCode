package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestSequence {
  //128
  public int longestConsecutive(int[] nums) {
    if(nums==null||nums.length==0){
      return 0;
    }
    Set<Integer> numsSet = new HashSet<>();
    for(int i=0;i<nums.length;i++){
      numsSet.add(nums[i]);
    }

    int longest = 0;
    for(int i=0;i<nums.length;i++){
      if(!numsSet.contains(nums[i]-1)){
        int startNum = nums[i];
        int len = 1;
        while(numsSet.contains(startNum+1)){
          len++;
          startNum++;
        }
        longest=Math.max(longest, len);
      }
    }
    return longest;
  }

  //298
  //1. 定义全局变量max
  //2. 递归时传递的是父亲节点的值
  //3. 递归时可以直接传递父亲节点
  //4. 可以不定义全局变量，用返回值传递max
  class Solution1 {
    private int max =0;
    public int longestConsecutive(TreeNode root) {
      if(root==null){
        return 0;
      }
      dfsLongest(root,root.val, 0);
      return max;
    }
    private void dfsLongest(TreeNode root, int expect, int currentLen){
      if(root==null){
        return;
      }
      if(root.val == expect){
        currentLen = currentLen +1;
      }else{
        currentLen =1;
      }
      max = Math.max(max, currentLen);
      dfsLongest(root.left, root.val+1, currentLen);
      dfsLongest(root.right, root.val+1, currentLen);
    }
  }

  class Solution2 {

    private int max =0;
    public int longestConsecutive(TreeNode root) {
      dfsLongest(root,null, 0);
      return max;
    }
    private void dfsLongest(TreeNode root, TreeNode parent, int currentLen){
      if(root==null){
        return;
      }
      if(parent!=null&&root.val == parent.val+1){
        currentLen = currentLen +1;
      }else{
        currentLen =1;
      }
      max = Math.max(max, currentLen);
      dfsLongest(root.left, root, currentLen);
      dfsLongest(root.right, root, currentLen);
    }
  }

  class Solution3 {
    public int longestConsecutive(TreeNode root) {
      return dfsLongest(root,null, 0);
    }
    private int dfsLongest(TreeNode root, TreeNode parent, int currentLen){
      if(root==null){
        return currentLen;
      }
      if(parent!=null&&root.val == parent.val+1){
        currentLen = currentLen +1;
      }else{
        currentLen =1;
      }
      //返回当前root得到的路径值，root的left得到的最大路径值，root的right的最大值，中的最大值
      return Math.max(currentLen, Math.max(dfsLongest(root.left, root, currentLen),
                                           dfsLongest(root.right, root, currentLen)));
    }



  }




}
