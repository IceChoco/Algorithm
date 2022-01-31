package programmers.PlainSquare;

import java.math.BigInteger;

public class Solution {
    public long solution(int w, int h) {
        int big   = Integer.max(w,h);
        int small = Integer.min(w,h);

        long squareThroughLine = w+h-gcd(big,small);

        return (long)w*h-squareThroughLine;
    }

    private long gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8,12));
    }
}
