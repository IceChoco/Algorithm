package codility.Lesson10_PrimeAndCompositeNumbers.CountFactors;
/* [주의할 점]
 * 입력값이 정수 최대 범위인 Intger.MAX_VALUE가 오는 경우
 * 정수 최대의 루트 값인 46340이 되기 전에 i*i 값이 int 정수 최대 범위를 넘어
 * N보다 작을 때 까지만 반복하려는 로직이 제대로 수행되지 않아 무한루프를 돌 수 있다.
 *
 * 따라서 i*i 앞에 (long)형을 추가하여 루트n번만에 체크할 수 있도록 해야한다.
 */
public class Solution {
    public int solution(int N){
        int ans = 0, i=1, cnt = 0;
        while((long)i*i<N){
            cnt++;
            if(N % i == 0) ans+=2;
            i++;
        }
        if(i*i == N) ans++;
        System.out.println("cnt: "+cnt);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(Integer.MAX_VALUE));
    }
}
