package codility.Lesson15_Caterpillar_method.AbsDistinct;

import java.util.HashSet;

public class Solution {
    public int solution(int[] A){
        HashSet<Integer> hs = new HashSet<>();
        for(int a:A){
            hs.add(Math.abs(a));
        }

        return hs.size();
    }

    public static void main(String[] args) {
        int[] A = {-5,-3,-1,0,3,6};
        System.out.println(new Solution().solution(A));
    }
}