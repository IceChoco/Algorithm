package codility.Lesson12_Euclidean_algorithm.CommonPrimeDivisors;

/* [주의해야할 점]
 * BigInteger 클래스의 gcd 메서드를 사용하는 것 보다, 직접 유클리드 호제법으로 gcd를 구현하여 쓰는 것이 훨씬 빠르다.
 * 실제로 이 문제에서도 BigInteger 클래스의 gcd 메서드를 사용했을 때는 타임아웃이 나고
 * gcd를 직접 구현했을 때는 통과했다.
 */
public class Solution {
    public int solution(int[] A, int[] B){
        int gcd, gcdA, gcdB, ans = 0, a, b;
        for(int i=0;i<A.length;i++){
            a = A[i]; b = B[i];
            gcd = gcd(a,b);
            gcdA = gcdB = 0;

            while(gcdA !=1){
                gcdA = gcd(a, gcd);
                a /= gcdA;
            }

            while(gcdB !=1){
                gcdB = gcd(b, gcd);
                b /= gcdB;
            }

            if(a==1 && b== 1) ans++;
        }

        return ans;
    }

    private int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        return gcd(b,a%b);
//        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    public static void main(String[] args) {
        int A[] = {15,10,3,2};
        int B[] = {75,30,5,50};//1
//        int A[] = {1};
//        int B[] = {1};//1

        System.out.println(new Solution().solution(A,B));
    }
}
