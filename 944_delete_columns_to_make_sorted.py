from typing import List

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        count = 0
        for i in range(len(strs[0])):
            currentLetter = strs[0][i]
            for j in range(1,len(strs)):
                if strs[j][i] < currentLetter:
                    count += 1
                    break
                currentLetter = strs[j][i]
                

        return count