package codility.Lesson10_PrimeAndCompositeNumbers.MinPerimeterRectangle;
/* [주의할 점]
 * i*i가 N이하인 경우뿐만 아니라
 * i^2이 N과 같은 경우도 고려해야 함!
 */
public class Solution {
    public int solution(int N){
        int ans = Integer.MAX_VALUE;
        int i = 1;

        while(i*i<=N){
            if(N%i == 0){//약수입니당
                ans = Integer.min(ans, (N/i + i)*2);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(30));
    }
}
