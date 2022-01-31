package programmers.PlainSquare;

import java.math.BigInteger;

public class shorterSolution {
    public long solution(int w,int h){
        long totalCount = (long)w * (long) h;
        long diagonalCount = w+h- BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return totalCount - diagonalCount;
    }

    public static void main(String[] args) {
        System.out.println(new shorterSolution().solution(8,12));
    }
}
