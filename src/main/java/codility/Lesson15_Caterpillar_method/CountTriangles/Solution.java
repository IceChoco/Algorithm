package codility.Lesson15_Caterpillar_method.CountTriangles;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A){//삼각형 p,q,r
        int n = A.length;
        int result = 0;
        Arrays.sort(A);
        for(int p=0;p<n;p++){
            int r = p+2;//+1이면 p+q = r이 되기 때문. 삼각형의 조건인 p+q>r을 만족하지 않음.
            for(int q=p+1;q<n;q++){
                while(r <n && A[p] + A[q] > A[r]){
                    r++;
                }
                result += r-q-1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {10,2,5,1,8,12};
        System.out.println(new Solution().solution(A));
    }
}
