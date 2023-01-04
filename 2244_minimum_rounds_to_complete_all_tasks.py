from typing import List

class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        taskmap = {}

        for task in tasks:
            if task not in taskmap:
                taskmap[task] = 1

            else:
                taskmap[task] += 1
                
        #print(taskmap)

        count = 0

        for task in taskmap:
            if taskmap[task] < 2:
                return -1

            count += (taskmap[task]+2)//3

        return count