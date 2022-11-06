from typing import List

class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            currentElement = matrix[i][0]
            for j in range(m-i+1):
                if(i+j) >= m:
                    break
                if(j >= n):
                    break
                if not matrix[i+j][j] == currentElement:
                    return False

        for j in range(n):
            currentElement = matrix[0][j]
            for i in range(n-j+1):
                if(j+i) >= n:
                    break
                if(i >= m):
                    break
                if not matrix[i][j+i] == currentElement:
                    return False

        return True