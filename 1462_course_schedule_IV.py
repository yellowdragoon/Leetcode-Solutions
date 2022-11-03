from typing import List

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:

        # 1: DAG: adj list build

        adjList = {}
        for i in range(numCourses):
            adjList[i] = []

        #print(adjList)

        for a,b in prerequisites:
            adjList[a].append(b)

        #print(adjList)

        visited = [False] * numCourses

        def dfs(node, dest):
            if visited[node]:
                return False

            visited[node] = True
            reachable = False

            if node == dest:
                reachable = True

            else:
                for adj in adjList[node]:
                    if dfs(adj, dest):
                        reachable = True
                        break

            return reachable

        queries_arr = []

        for start, end in queries:
            if dfs(start, end):
                queries_arr.append(True)
            else:
                queries_arr.append(False)

            visited = [False] * numCourses


        return queries_arr

        