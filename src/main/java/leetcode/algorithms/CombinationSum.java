package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, combine, result, 0);
        return result;
    }
    private void dfs(int[] candidates, int target, List<Integer> combine, List<List<Integer>> result, int start){
        if (start == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, combine, result, start + 1);
        // 选择当前数
        if (target - candidates[start] >= 0) {
            combine.add(candidates[start]);
            dfs(candidates, target - candidates[start], combine, result, start);
            combine.remove(combine.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);

        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(candidates, 0, len, target, path, res);
        return res;
    }
    private void dfs2(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }
}
