package codility.Lesson9_MaximumSliceProblem.MaxProfit;

public class Solution {
    public int solution(int[] A){
        int maxValue, minValue, profit;
        profit = 0;

        if(A.length != 0){ //empty Array check
            maxValue = minValue = A[0];

            for(int i=1;i<A.length;i++){
                if(A[i] < minValue) {// 최소값 변경
                    minValue = maxValue = A[i];
                }else if(A[i] > maxValue){ //최대값 변경
                    maxValue = A[i];
                }

                profit = Integer.max(profit, maxValue - minValue);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
//int[] test = {23171, 21011, 21123, 21366, 21013, 21367}; //356
//int[] test = {1000, 981, 959, 935, 905, 894};//
// int[] test = {6830, 6880, 6900, 6810, 6620, 6220};//70
        int[] test = {128500, 129500, 128500, 127000, 126500, 128000};//1500

        System.out.println(new Solution().solution(test));

// A[0] = 23171
// A[1] = 21011
// A[2] = 21123
// A[3] = 21366
// A[4] = 21013
// A[5] = 21367
    }
}