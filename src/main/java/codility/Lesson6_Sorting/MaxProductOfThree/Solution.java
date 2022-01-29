package codility.Lesson6_Sorting.MaxProductOfThree;

import java.util.Arrays;
public class Solution {
    public int solution(int[] A){
        Arrays.sort(A);
        int case1 = A[0] * A[1] * A[A.length-1];
        int case2 = A[A.length-3] * A[A.length-2] * A[A.length-1];
        return Integer.max(case1, case2);
    }

    public static void main(String[] args) {
        //int[] test = {-3,1,2,-2,5,6};
        int[] test = {-5,5,-5,4};
        System.out.println(new Solution().solution(test));
    }
}
