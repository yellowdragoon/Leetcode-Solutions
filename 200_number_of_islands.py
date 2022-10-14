from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        cardinal_dir = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        visited = [[0 for _ in grid[0]] for _ in grid]
        
        #print(visited)
        
        def dfs(x, y):
            #print(x, y)
            if visited[x][y] or grid[x][y] == "0":
                return False
            else:
                visited[x][y] = 1
                for i, j, in cardinal_dir:
                    x_ = x + i
                    y_ = y + j
                    
                    if x_ < 0 or x_ >= m or y_ < 0 or y_ >= n:
                        continue
                    else:
                        dfs(x_, y_)            
                        
                return True
                
                
        numIslands = 0
        for i in range(m):
            for j in range(n):
                if(dfs(i, j)):
                    numIslands += 1
                    
        return numIslands
            