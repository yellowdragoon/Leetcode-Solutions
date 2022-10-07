'''
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights,
where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west
if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

Solution:
- we run run 2 seperate dfs searches: one for Atlantic, one for Pacific. We start from the ocean and propagate backwards to find all connected nodes.
- build 2 boolean arrays that stores these values. Finally we return the intersection boolean array of these arrays.
'''


from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        
        canReachPac = [[False for _ in heights[0]] for _ in heights]
        canReachAtl = [[False for _ in heights[0]] for _ in heights]
        
        
        m = len(heights)
        n = len(heights[0])
        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        
        def dfs(x, y, boolArr):
            
            if x < 0 or x >= m or y < 0 or y >= n:
                return 
            
            if boolArr[x][y]:
                return
            
            else:
                boolArr[x][y] = True
                for i, j in directions:
                    x_ = x+i
                    y_ = y+j
                    
                    if x_ < 0 or x_ >= m or y_ < 0 or y_ >= n:
                        continue
                    elif heights[x_][y_] >= heights[x][y]:               
                    
                        dfs(x_, y_, boolArr)
                        
        winningTiles = []
                        
                        
        for i in range(m):
            dfs(i, 0, canReachPac)
            dfs(i, n-1, canReachAtl)
            
        for j in range(n):
            dfs(0, j, canReachPac)
            dfs(m-1, j, canReachAtl)
            
        for i in range(m):
            for j in range(n):
                if canReachPac[i][j] and canReachAtl[i][j]:
                    winningTiles.append([i, j])
    
        #print(canReachAtl)
        #print(canReachPac)
                    
        return winningTiles