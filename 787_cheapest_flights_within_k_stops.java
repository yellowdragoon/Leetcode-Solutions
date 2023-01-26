class Solution {

    public int dfs(ArrayList<Integer>[] edges, int currentNode, int dst, int k, Integer[][]mem){
        //System.out.println(currentNode);
        if(currentNode == dst) return 0;
        if(k < 0){
            return Integer.MAX_VALUE;
        }
        if(mem[currentNode][k] != null) return mem[currentNode][k];

        int minDist = Integer.MAX_VALUE;

        ArrayList<Integer> flights = edges[currentNode];
        for(int i = 0; i < flights.size(); i+=2){
            int cost = dfs(edges, flights.get(i), dst, k-1, mem);
            if(cost != Integer.MAX_VALUE){
                minDist = Math.min(minDist, cost + flights.get(i+1));
            }
        }
        return mem[currentNode][k] = minDist;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Integer>[] edges = new ArrayList[n];
        Integer[][]mem = new Integer[n+1][k+1];
        
        // initializing
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for(int[] flight: flights){
            edges[flight[0]].add(flight[1]);
            edges[flight[0]].add(flight[2]);
        }
        int answer = dfs(edges, src, dst, k, mem);
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}