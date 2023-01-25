class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int lowestPoint = -1;
        int lowestValue = 0;
        int sumDiffs = 0;

        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            sumDiffs += diff;
            if(sumDiffs < lowestValue){
                lowestValue = sumDiffs;
                lowestPoint = i;
            }
        }

        if(sumDiffs < 0) return -1;
        
        return (lowestPoint + 1) % gas.length;

    }
}