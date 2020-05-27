package leetcode.algorithms;

//978
public class MaxTurbulanceSize {
  public int maxTurbulenceSize(int[] A) {
    if (A == null) {
      return 0;
    }
    int flag = 0;
    int max = 1;
    int current = 1;
    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i - 1] && (flag == 0 || current == 1)) {
        current++;
        flag = 1;
      } else if (A[i] < A[i - 1] && (flag == 1 || current == 1)) {
        current++;
        flag = 0;
      } else {
        current = 1;
        //不相等时退一位，从上一位开始
        if (A[i] != A[i - 1]) {
          i--;
        }
      }
      max = Math.max(max, current);
    }
    return max;
  }

}
