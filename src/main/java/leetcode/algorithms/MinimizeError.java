package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MinimizeError {

  //先求floor和，然后从大到小排序ceil-原始值的误差，误差大的变为ceil。最后一起求出总误差。
  public String minimizeError(String[] prices, int target) {
    if (prices == null || target < 0) {
      return "";
    }
    int canInc = 0;
    int minSum = 0;
    Double[] priceNumbers = new Double[prices.length];
    for (int i = 0; i < prices.length; i++) {
      double num = Double.parseDouble(prices[i]);
      priceNumbers[i] = num;
      int floor = (int) Math.floor(num);
      minSum += floor;
      if (floor != num) {
        canInc++;
      }
    }
    if (target < minSum || target > minSum + canInc) {
      return "-1";
    }
    //数组参数
    Arrays.sort(priceNumbers, new Comparator<Double>() {
      public int compare(Double o1, Double o2) {
        //ceil误差从大到小排序，转为ceil后，误差就是从小到大了
        return o1 - Math.floor(o1) > o2 - Math.floor(o2) ? -1 : 1;
      }
    });
    int incCount = target - minSum;
    double ans = 0.0;
    for (int i = 0; i < priceNumbers.length; i++) {
      if (i < incCount) {
        ans += Math.abs(Math.ceil(priceNumbers[i]) - priceNumbers[i]);
      } else {
        ans += Math.abs(Math.floor(priceNumbers[i]) - priceNumbers[i]);
      }
    }

    return String.format("%.3f", ans);
  }

}
