from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        bestRobs = [0] * len(nums)
        bestRobs[0] = nums[0]
        
        for idx, val in enumerate(nums):
            
            if idx - 2 >= 0:
                bestRobs[idx] = max(bestRobs[idx-1], bestRobs[idx-2] + val)
                
            elif idx - 1 >= 0:
                bestRobs[idx] = max(bestRobs[idx-1],val)
        
        #print(bestRobs)
                
        return bestRobs[-1]
                