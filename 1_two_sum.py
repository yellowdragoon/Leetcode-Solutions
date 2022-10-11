from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
         
        arrayMap  = {}
                
        for i, num in enumerate(nums):
            
            if num in arrayMap:
                return [arrayMap[num], i]
            arrayMap[target - num] = i