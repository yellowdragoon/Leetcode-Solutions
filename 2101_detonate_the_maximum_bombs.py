import math
from typing import List

class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        # if bomb A is connected to bomb B and bomb B is connected to bomb C,
        # then bomb A is connected to bomb C

        # function to check if 2 circles overlap
        # for each circle, build adj list with all overlapping circles
        # dfs each circle if unvisited
        # longest dfs wins

        N = len(bombs)
        adjList = [[] for _ in range(N)]
        visited = [False] * N
        

        def overlapping(bomb0: List[int], bomb1: List[int]) -> bool:

            x0, y0, r0 = bomb0
            x1, y1, r1 = bomb1

            x_dist = (x0-x1)**2
            y_dist = (y0-y1)**2

            centre_dist = math.sqrt(x_dist + y_dist)

            if (r1) >= centre_dist:
                return True

            else:
                return False

        # get all permutations of circles

        

        for i in range(N):
            for j in range(i+1, N):
                if overlapping(bombs[i], bombs[j]):
                    #edge between i, j
                    #print(i, j)    
                    adjList[j].append(i)
                
                if overlapping(bombs[j], bombs[i]):
                    adjList[i].append(j)

        def dfs(bombNum):
            if visited[bombNum]:
                return 0

            visited[bombNum] = True
            count = 1

            for adjBomb in adjList[bombNum]:
                count += dfs(adjBomb)

            return count

        #print(adjList)
        #print(visited)
        maxDeto = 0

        for i in range(N):
            visited = [False] * N
            maxDeto = max(maxDeto, dfs(i))


        return maxDeto