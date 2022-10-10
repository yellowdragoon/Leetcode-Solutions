/*

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Solution:
- Count indegrees and outdegrees for each node, if a node has indegrees n-1 and outdegrees 0 then we found sol, otherwise not.
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n];
        int[] outdegrees = new int[n];

        for(int i = 0; i < trust.length; i++){
            outdegrees[trust[i][0] - 1] += 1;
            indegrees[trust[i][1] - 1] += 1;
        }

        for(int i = 0; i < n; i++){
            if(indegrees[i] == n-1 && outdegrees[i] == 0){
                return i+1;
            }
        }

        return -1;
    }
}