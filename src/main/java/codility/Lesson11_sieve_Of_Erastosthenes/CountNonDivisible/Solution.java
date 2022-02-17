package codility.Lesson11_sieve_Of_Erastosthenes.CountNonDivisible;
/* [주의해야 할 점]
 * 전체적인 방향은 맞았으나 방향을 너무 어렵게 생각해서 1트는 못한 문제.
 * 배열의 총 element의 수에서 약수의 수를 빼면 "약수가 아닌 element의 수"를 구할 수 있다.
 *
 *  1. 너무 어렵게 생각하지 말자. 기본에 충실하자.
 *  2. 약수를 구할 때는 i는 1부터 시작하여 i*i이 n 보다 같거나 작을 때 까지 구하면 빠르다.
 */
public class Solution {
    public int[] solution(int[] A){
        int N = A.length;//배열의 길이
        int[] ans = new int[N];
        int[] cntE = new int[100001];//각 element별 cnt 배열

        for(int a:A){
            cntE[a]++;
        }

        int divisors;
        for(int i=0;i<N;i++){
            divisors = N;

            for(int j=1;j*j <= A[i];j++){//3의 약수를 구하자. 루트 3까지만 구하면 된다.
                if(A[i] % j == 0){//약수다
                    divisors -= cntE[j];
                    if(A[i]/j != j){//j의 제곱이 아니라면, 쌍을 이루는 수도 약수임
                        divisors -= cntE[A[i]/j];
                    }
                }
            }

            if(divisors == N) divisors = 0;
            ans[i] = divisors;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = {3,1,2,3,6};
        int[] result = new Solution().solution(input);
        for (int a:result)
            System.out.print(a+" ");
    }
}
