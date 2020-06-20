package leetcode.algorithms;

import java.util.Stack;

public class SubArray {

  //乘法变加法
  //左边第一个比后面所有的都小的子数组
  public int validSubarrays(int[] nums) {
    if(nums==null||nums.length==0){
      return 0;
    }
    int res = 0;
    Stack<Integer> incStack = new Stack<>();
    for(int i=0;i<nums.length;i++){
      while(!incStack.isEmpty()&&nums[incStack.peek()]>nums[i]){
        res += i-incStack.pop();
      }
      incStack.push(i);
    }

    while(!incStack.isEmpty()){
      res += nums.length-incStack.pop();
    }
    return res;
  }
}
