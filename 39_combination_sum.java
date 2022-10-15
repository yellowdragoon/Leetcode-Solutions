import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //driver code
        List<List<Integer>> combinations = new ArrayList<>();

        calcSums(target, new ArrayList<Integer>(), combinations, candidates, 0);

        return combinations;
    }


    public void calcSums(int target, ArrayList<Integer> currentSum, List<List<Integer>> combs, int[] cands, int currentCoin){
        if(target < 0){
            return;
        }

        if(target == 0){
            ArrayList<Integer> solution = new ArrayList<Integer>(currentSum);
            combs.add(solution);
            return;
        }

        for(int i = currentCoin; i < cands.length; i++){
            //ArrayList<Integer> newCurrentSum = new ArrayList<Integer>(currentSum);
            currentSum.add(cands[i]);
            calcSums(target-cands[i], currentSum ,combs, cands, i);
            currentSum.remove(currentSum.size()-1);
        }
        
    }
}