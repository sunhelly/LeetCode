package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+hashmap
 */
public class SubArraysDivByK {
  public int subarraysDivByK(int[] A, int K) {
    Map<Integer, Integer> preMode = new HashMap<>();
    int ans = 0;
    int sum = 0;
    //遍历数组 A 之前，map 提前放入 0:1，表示 求第 0 项前缀和之前，前缀和 mod K 等于 0 已经出现了 1 次
    preMode.put(0, 1);
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      //前缀和为负数
      int mode = (sum % K + K) % K;
      //当前这个sub array与前面所有sub array的组合，累加变为乘
      ans += preMode.getOrDefault(mode, 0);
      preMode.put(mode, preMode.getOrDefault(mode, 0) + 1);
    }
    return ans;
  }
}
