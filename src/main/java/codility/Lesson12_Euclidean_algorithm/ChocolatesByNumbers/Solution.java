package codility.Lesson12_Euclidean_algorithm.ChocolatesByNumbers;

import java.math.BigInteger;

public class Solution {
    public int solution(int N, int M){
        int ans = N/BigInteger.valueOf(N).gcd(BigInteger.valueOf(M)).intValue();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10,4));
    }
}
