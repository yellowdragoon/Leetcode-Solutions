from typing import List

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:

        # directed graph, dfs from start, can reach all nodes?

        # note: rooms already in adj list form

        visited = set()

        def dfs(roomNum):
            for room in rooms[roomNum]:
                if room not in visited:
                    visited.add(room)
                    dfs(room)

        visited.add(0)
        dfs(0)

        return len(visited) == len(rooms)