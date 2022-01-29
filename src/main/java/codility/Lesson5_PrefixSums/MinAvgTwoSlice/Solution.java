package codility.Lesson5_PrefixSums.MinAvgTwoSlice;

public class Solution {
    public int solution(int[] A) {
        //구간합구하기
        Double min = Double.MAX_VALUE;

        int minIdx = 0;
        double avg = Double.MAX_VALUE;
        for(int p=0;p<A.length-1;p++){
            if((double)(A[p] + A[p+1])/2 < avg){
                avg = (double)(A[p]+A[p+1])/2;
                minIdx = p;
            }else if((p+2<A.length)&&(double)(A[p] + A[p+1]+ A[p+2])/3 < avg){
                avg = (double)(A[p]+A[p+1]+ A[p+2])/3;
                minIdx = p;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        //int[] test = {4,2,2,5,1,5,8}; //1
        int[] test = {5,6,3,4,9}; //2
        System.out.println(new Solution().solution(test));
    }
}
