package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LeadsToDestination {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
      if(edges==null||edges.length<n-1){
        System.out.println("path not enough");
        return false;
      }
      if(source==destination){
        return n==1&&edges.length==0;
      }
      Map<Integer, Set<Integer>> nodeNextsMap = getNodeNext(edges);
      if(nodeNextsMap.isEmpty()){
        return false;
      }
      if(nodeNextsMap.get(destination)!=null){
        return false;
      }
      return dfsValidPath(source, destination,nodeNextsMap, new LinkedList<>());
    }

    private Map<Integer, Set<Integer>> getNodeNext(int[][] edges){
      Map<Integer, Set<Integer>> nodeNextMap = new HashMap<>();
      for(int i=0;i<edges.length;i++){
        // if(edges[i][1]==edges[i][0]){
        //     System.out.println("has self circle, node=" + edges[i][0]);
        //     return null;
        // }
        // if(nodeNextMap.get(edges[i][1])!=null&&
        // nodeNextMap.get(edges[i][1]).contains(edges[i][0])){
        //     System.out.println("has circle, node1="+edges[i][0] +",node2="+ edges[i][1]);
        //     return null;
        // }
        nodeNextMap.computeIfAbsent(edges[i][0], k->new HashSet<>());
        nodeNextMap.get(edges[i][0]).add(edges[i][1]);

      }
      return nodeNextMap;
    }

    private boolean dfsValidPath(int start, int dest, Map<Integer, Set<Integer>> nodeNextsMap, LinkedList<Integer> path){
      if(start == dest){
        if(path.indexOf(dest)!=path.size()-1){
          return false;
        }
        return true;
      }
      if(nodeNextsMap.get(start)==null){
        return false;
      }
      Set<Integer> nexts = nodeNextsMap.get(start);
      for(Integer next : nexts){
        if(path.contains(next)){
          return false;
        }
        path.add(next);
        //用if返回
        if(!dfsValidPath(next, dest, nodeNextsMap, path)){
          return false;
        }
        path.removeLast();
      }
      return true;
    }
}
