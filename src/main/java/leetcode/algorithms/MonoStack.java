package leetcode.algorithms;

import java.util.Stack;

public class MonoStack {
  //找以每个元素为高，向左向右第一比他矮的界限。
  public int largestRectangleArea(int[] heights) {
    if(heights==null||heights.length==0){
      return 0;
    }
    int maxArea = 0;
    Stack<Integer> incStack = new Stack<>();
    incStack.push(0);
    for(int i=1;i<heights.length;i++){
      //栈里的找到了右边第一个比他小的。
      //以栈顶元素为高！！
      while(!incStack.isEmpty()&&heights[incStack.peek()]>heights[i]){
        int top = incStack.pop();
        int left = incStack.isEmpty()?-1:incStack.peek();
        maxArea = Math.max(maxArea, heights[top]*(i-left-1));
      }
      incStack.push(i);
    }
    while(!incStack.isEmpty()){
      int top = incStack.pop();
      int left = incStack.isEmpty()?-1:incStack.peek();
      maxArea = Math.max(maxArea, heights[top]*(heights.length-left-1));
    }
    return maxArea;
  }


}
