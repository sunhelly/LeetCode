package leetcode.algorithms;

public class DuplicateNumber {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int l = 1;
    int r = nums.length - 1;
    int ans = -1;
    while (l <= r) {
      int mid = (l + r) >> 1;
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }
      if (count <= mid) {
        l = mid + 1;
      } else {
        r = mid - 1;
        ans = mid;
      }
    }
    return ans;
  }
}
