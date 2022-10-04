'''
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 Solution:
 - Simple backtracking algorithm. We use a recursive dfs to keep track of the current subword.
 - Keep bool array to avoid using same letter twice.
'''



from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        searched = [[0 for _ in board[0]] for _ in board]

        m = len(board)
        n = len(board[0])

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def dfs(word, i, j):
            if word == "":
                return True

            if i < 0 or i >= m or j < 0 or j >= n:
                return False

            if searched[i][j]:
                return False

            if board[i][j] == word[0]:

                searched[i][j] = True

                for x, y in directions:
                    i_ = i + x
                    j_ = j + y

                    if dfs(word[1:], i_, j_):
                        searched[i][j] = False
                        return True

                searched[i][j] = False

            return False

        for i in range(m):
            for j in range(n):
                if dfs(word, i, j):
                    return True

        return False