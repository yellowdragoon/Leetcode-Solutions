from typing import List

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        # dfs for every node
        # adjacency matrix
        n = len(isConnected)
        searched = [0] * n
        searched[0] = 0
        


        def dfs(node):
            if searched[node]:
                return

            searched[node] = 1

            for i in range(n):
                if isConnected[node][i]:
                    dfs(i)

        prov = 0

        for i in range(n):
            if searched[i]:
                continue
            else:
                dfs(i)
                prov += 1

        return prov