class Solution {
    public int numTrees(int n) {
        int[]dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            int numTrees = 0;
            for(int j = 0; j< i; j++){
                numTrees += (dp[i-j-1] * dp[j]);
            }

            dp[i] = numTrees;
        }

        return dp[n];
    }
}