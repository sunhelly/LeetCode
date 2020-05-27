package leetcode.algorithms;

public class SortedSquares {
  public int[] sortedSquares(int[] A) {
    if (A == null || A.length <= 0) {
      return A;
    }
    int i = 0;
    while (i < A.length && A[i] < 0) {
      i++;
    }
    int j = i - 1;
    int[] result = new int[A.length];
    int r = 0;
    while (j >= 0 && i < A.length) {
      if (A[j] * A[j] <= A[i] * A[i]) {
        result[r++] = A[j] * A[j];
        j--;
      } else {
        result[r++] = A[i] * A[i];
        i++;
      }
    }
    while (j >= 0) {
      result[r++] = A[j] * A[j];
      j--;
    }
    while (i < A.length) {
      result[r++] = A[i] * A[i];
      i++;
    }
    return result;
  }
}
