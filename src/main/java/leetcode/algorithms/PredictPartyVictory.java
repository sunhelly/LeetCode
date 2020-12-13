package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        if(senate == null || senate.length()==0){
            return "no win";
        }
        Queue<Integer> rList = new LinkedList<>();
        Queue<Integer> dList = new LinkedList<>();
        int n = senate.length();
        for(int i = 0;i<n;i++){
            if(senate.charAt(i)=='R'){
                rList.offer(i);
            }else{
                dList.offer(i);
            }
        }
        while(!rList.isEmpty()&&!dList.isEmpty()){
            int rMin = rList.poll();
            int dMin = dList.poll();
            if(rMin<dMin){
                rList.offer(rMin+n);
            }else{
                dList.offer(dMin+n);
            }
        }

        return rList.isEmpty()?"Dire":"Radiant";
    }
}
