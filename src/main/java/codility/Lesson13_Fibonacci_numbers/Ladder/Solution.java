package codility.Lesson13_Fibonacci_numbers.Ladder;

/* [주의해야 할 점]
 * 공식으로하면 Overflow가 나기 때문에 for문으로 구해야하며
 * 각 원소마다 나머지 연산하는 값이 달라지지만 가장 큰 값인 2의 30을 기준으로 저장해두고
 * 나중에 꺼내쓸 때 각 원소의 기준대로 나눈 나머지 연산을 또 수행하면된다.
 *
 * 2의 30승으로 저장한 값을 2의 30승으로 다시 나눈 나머지 값을 구하든, 2의 1승으로 다시 나눈 나머지 값을 구하든 값에는 지장을 주지 않는다.
 * 2의 30승과 같거나 그보다 작은 값을 기준으로 나눌 때만 유효하다.
 * 왜냐 2의 30승은 그보다 작은 값, 예를들어 2의 배수이기 때문에 몫에서 이미 처리되기 때문이다.
 */

public class Solution {
    public int[] solution(int[] A, int[] B){
        int N = A.length;
        int[] ans = new int[N];
        int[] fibo = getFibo(50001);

        for(int i=0;i<N;i++){
            ans[i] = (int)(fibo[A[i]+1]%Math.pow(2,B[i]));
        }

        return ans;
    }

    private int[] getFibo(int N){
        int[] fibo = new int[N+1];
        fibo[0] = 0; fibo[1] = 1;
        for(int i=2;i<=N;i++){
            fibo[i] = (int)((fibo[i-1] + fibo[i-2])%Math.pow(2,30));
        }

        return fibo;
    }

    public static void main(String[] args) {
        int[] A = {4,4,5,5,1};
        int[] B = {3,2,4,3,1};
        int[] result = new Solution().solution(A,B);

        for(int r:result){
            System.out.println(r);
        }
    }
}
