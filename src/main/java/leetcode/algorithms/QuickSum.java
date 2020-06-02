package leetcode.algorithms;

public class QuickSum {

  public int quickSum(int n){
    // (n * n+1)/2
    int ans = 0;
    int A = n;
    int B = n+1;
    boolean flag = true;
    while(flag){
      if((B&1)>0){
        ans+=A;
      }
      B>>=1;
      A<<=1;
      flag = B>0;
    }
    return ans>>1;
  }
  

}
