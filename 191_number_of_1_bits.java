class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        for(int i=0; i<32; i++){
            weight += (n >> i) & 1;
        }
        return weight;
    }
}