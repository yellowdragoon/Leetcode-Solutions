from typing import List
import math

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        #print(n, m)

        dp = [[math.inf for _ in range(m+2)] for _ in range(n+1)]
        for i in range(m):
            for j in range(n):
                dp[j][i+1] = matrix[j][i]

        #print(dp)

        for i in range(1, n):
            for j in range(m):
                dp[n-i-1][j+1] += min(dp[n-i][j], dp[n-i][j+1], dp[n-i][j+2])

            #print(dp)


        return min(dp[0])