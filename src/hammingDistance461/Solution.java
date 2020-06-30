package hammingDistance461;

public class Solution {
    public int hammingDistance(int x, int y) {
        int sum = 0;
        int z = x ^ y;
        for(int i = 0; i < 32; ++i){
            if( (z & 1) == 1){
                ++sum;
            }
            z >>= 1;
        }
        return sum;
    }
}
