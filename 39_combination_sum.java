import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //driver code
        List<List<Integer>> combinations = new ArrayList<>();

        this.calcSums(target, new ArrayList<Integer>(), combinations, candidates);

        return combinations;
    }


    public void calcSums(int target, ArrayList<Integer> currentSum, List<List<Integer>> combs, int[] cands){
        if(target < 0){
            return;
        }

        if(target == 0){
            ArrayList<Integer> solution = new ArrayList<Integer>(currentSum);
            combs.add(solution);
            return;
        }

        for(int i: cands){
            //ArrayList<Integer> newCurrentSum = new ArrayList<Integer>(currentSum);
            currentSum.add(i);
            this.calcSums(target-i, currentSum ,combs, cands);
            currentSum.remove(currentSum.size()-1);
        }
        
    }
}