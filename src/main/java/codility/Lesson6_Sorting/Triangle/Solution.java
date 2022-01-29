package codility.Lesson6_Sorting.Triangle;

import java.util.Arrays;

/*
element의 범위가 −2,147,483,648..2,147,483,647이기 때문에 아래 2개 해줘야 오버플로우 나지 않음
1. Long 변수에 담을 것
2. (Long) 형변환 추가할 것
**/
public class Solution {
    public int solution(int[] A){
        Arrays.sort(A);

        int p,q,r;
        long c1, c2, c3;
        for(int i=0;i<A.length-2;i++){
            p = A[i]; q = A[i+1]; r = A[i+2];

            c1 = (long)p+q; c2 = (long)q+r; c3 = (long)q+r;

            if(c1 > r && c2>q && c3>p)
                return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
//        int[] test = {10,2,5,1,8,20}; //1
//        int[] test = {10,50,5,1};//0
//        int[] test = {-100,2,4,5}; //1
        int[] test = {Integer.MAX_VALUE-2,Integer.MAX_VALUE-1,Integer.MAX_VALUE}; //1
        System.out.println(new Solution().solution(test));
    }
}
