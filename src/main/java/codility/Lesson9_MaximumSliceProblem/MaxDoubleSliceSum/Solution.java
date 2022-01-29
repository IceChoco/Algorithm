package codility.Lesson9_MaximumSliceProblem.MaxDoubleSliceSum;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] A){
        int max = 0, ans = Integer.MIN_VALUE;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(A[1]); queue.add(A[2]);

        for(int i=3;i<A.length;i++){
            max = Integer.max(max+queue.peek(),queue.poll());
            ans = Integer.max(max, ans);
            queue.add(A[i]);
        }

        if(A.length==3) ans = 0;
        return ans;
    }

    public static void main(String[] args) {
// int[] test = {3,2,6,-1,4,5,-1,2};//17
// int[] test = {5,-7,3,5,-2,4,-1};//10
// int[] test = {2,9,4,3,5,8,2,7,9,5,3};//50
// int[] test = {1,2,3,4,5,6,7,8,9,10};//42
//        int[] test = {-2,-3,-4,1,-5,-6,-7};//1
        int[] test = {5,5,5};//0

        System.out.println(new Solution().solution(test));
    }
}