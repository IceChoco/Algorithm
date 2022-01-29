package codility.Lesson9_MaximumSliceProblem.MaxSliceSum;

public class Solution {
    public int solution(int[] A){
        int max_slice, ans;
        ans = Integer.MIN_VALUE;
        max_slice = 0;

        for(int i=0;i<A.length;i++){
            max_slice = Integer.max(max_slice+A[i], A[i]);
            ans = Integer.max(max_slice, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = {3,2,-6,4,0};//5
// int[] test = {5,-7,3,5,-2,4,-1};//10
// int[] test = {-10};//-10
        System.out.println(new Solution().solution(test));
    }
}