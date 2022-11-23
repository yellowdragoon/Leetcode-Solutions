class Solution {
    public int numSquares(int n) {
        //iterative dp
        //coin change problem with 100 coins

        int[] coins = new int[(int)Math.ceil(Math.sqrt(n))];

        for(int i=0; i<coins.length; i++){
            coins[i] = (i+1)*(i+1);
            //System.out.println(coins[i]);
        }

        int[] dp = new int[n+1];

        for(int i=1; i<dp.length; i++){
            int minVal = 100;
            for(int c: coins){
                if(c > i){
                    break;
                }
                minVal = Math.min(minVal, dp[i-c]);
            }

            dp[i] = minVal + 1;
        }
        return dp[n];
    }
}