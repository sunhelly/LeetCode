package leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author haxl
 */
//980
public class UniquePath3 {

    public static int uniquePathsIII(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }

        int finishStep = 0;
        int row=0;
        int col=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //记录下0的数量
                if (grid[i][j] == 0) {
                    finishStep++;
                } else if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }

        Set<String> paths = new HashSet<>();
        backtrack(grid, row ,col, new LinkedList<>(), paths, finishStep, 0);
        return paths.size();
    }

    private static void backtrack(int[][] grid, int row, int col, LinkedList<String> subPath, Set<String> paths, int finishStep, int moved){
        if(grid[row][col]==-1){
            return;
        }
        subPath.add("("+row+","+col+")");
        if(grid[row][col]==2 && moved==finishStep){
            paths.add(subPath.toString());
            System.out.println("added path:" + subPath.toString());
            return;
        }
        int origin = grid[row][col];
        if(origin == 0){
            //只有0，表示步数+1了
            moved++;
        }
        grid[row][col]=-1;
        int[] rowOffset = {-1,0,1,0};
        int[] colOffset ={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nextRow = row+rowOffset[i];
            int nextCol = col+colOffset[i];
            if(nextRow>=0&&nextRow<grid.length&&nextCol>=0&&nextCol<grid[0].length&&grid[nextRow][nextCol]!=-1){
                backtrack(grid, nextRow, nextCol, subPath, paths, finishStep, moved);
            }
        }
        grid[row][col]=origin;
        subPath.removeLast();
    }

    public static void main(String[] args){
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        uniquePathsIII(grid);
    }

}