package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

  //O(nlogn)
  public int longestRepeatingSubstring(String S) {
    if(S==null||S.length()==0){
      return 0;
    }
    //以子串长度（1-n）作为二分查找对象
    int left = 1;
    int right = S.length();
    while(left<=right){
      int midLength = left + (right-left)/2;
      if(find(S, midLength)!=-1){
        left = midLength + 1;
      }else{
        right = midLength-1;
      }
    }
    //最后终止left>right，left是下一要找的长度，right是当前找到的重复的长度
    return right;

//    while(left<right){
//      int midLength = left + (right-left)/2;
//      if(find(S, midLength)!=-1){
//        left = midLength + 1;
//      }else{
//        right = midLength;
//      }
//    }
//    return left-1;
  }

  private int find(String S, int len){
    Set<String> subs = new HashSet<>();
    for(int i=0;i<S.length()-len+1;i++){
      if(subs.contains(S.substring(i, i+len))){
        return 1;
      }else{
        subs.add(S.substring(i,i+len));
      }
    }
    return -1;
  }

}
