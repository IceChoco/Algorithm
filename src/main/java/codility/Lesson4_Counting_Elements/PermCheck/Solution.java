package codility.Lesson4_Counting_Elements.PermCheck;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A){
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            if(A[i] != i+1) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] test = {4,1,3,2};//순열
        int[] test2 = {4,1,3};//순열

        System.out.println(new Solution().solution(test2));
    }
}
