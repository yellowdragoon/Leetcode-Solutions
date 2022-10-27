class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i=0; i<16; i++){
            int rightSet = (n >> i) & 1;
            int leftSet = (n >> (31 - i)) & 1;
            n = (~(1 << i) & n) | (leftSet << i);
            n = (~(1 << (31-i)) & n) | (rightSet << (31-i));
        }

        return n;
    }
}