class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        boolean[] visited = new boolean[edges.length];
        boolean[] visited2 = new boolean[edges.length];
        int current = node1;
        int current2 = node2;
        while(!visited[current] || !visited2[current2]){
            visited[current] = true;
            visited2[current2] = true;
            if(visited[current] && visited2[current] && visited[current2] && visited2[current2]){
                return Math.min(current, current2);
            }
            if(visited[current] && visited2[current]){
                return current;
            }
            if(visited[current2] && visited2[current2]){
                return current2;
            }
            if(edges[current] != -1){
                current = edges[current];
            }
            if(edges[current2] != -1){
                current2 = edges[current2];
            }
        }
        
        return -1;
    }
}