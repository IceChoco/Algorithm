package codility.Lesson5_PrefixSums.PassingCars;
/*
놓쳤던 곳: 1. 1,000,000,000 이상인 경우 -1을 리턴해야 한다를 놓치고 구현 안해서 fail
           → 구현 후 다시 제출
          2. 1,000,000,000 이상체크를 for문 제일 처음에 놔서 fail
           → sum연산까지 끝난 후인 for문 가장 마지막으로 배치. 100% 나옴
시간복잡도: O(N)
* */
public class Solution {
    private static int zeroCnt;
    private static int[] sum;

    public int solution(int[] A){
        if(A[0] == 0)
            zeroCnt = 1;
        else
            zeroCnt = 0;

        sum = new int[A.length];

        for(int i=1;i<A.length;i++){
            if(A[i] == 0) zeroCnt++;
            sum[i] = sum[i-1] + zeroCnt*A[i];
            if(sum[i] > 1000000000) return -1;
        }

        return sum[A.length-1];
    }

    public static void main(String[] args) {

        int test[] = {0,1,0,1,1};
        System.out.println(new Solution().solution(test));
    }
}
