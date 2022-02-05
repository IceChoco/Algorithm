package programmers.binarySearch;

import java.util.Arrays;
/* [주의해야할 사항]
 * binaraySearch의 max타입은 long형이 되어야한다.
 * -> 이유: times의 최대값은 1,000,000,000이라고 되어있어 처음에 int형으로 매개변수 타입을 설정했다.
 *         하지만 그렇게 되면 n도 int형이기 때문에 int*int가 되어
 *         long right = n*max가 int형 1,0000,000,000 2개를 곱한 모습이 된다.
 *
 *         담는 변수가 long형이라도 int형 2개를 곱하면 이미 정수형을 넘기 때문에
 *         둘 중 하나는 무조건 long형이 되어야 정수형 범위를 넘지 않게 곱할 수 있다.
 *         따라서 max 또는 n 둘 중 하나는 무조건 long값이 되어야 두 곱이 long값으로 생성된다.
 */
public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(n, times, times[times.length-1]);
    }

    private long binarySearch(long n, int[] times, int max){
        long ans = Long.MAX_VALUE;
        long left = 0; long right = n*max; long mid;

        while(left<=right){
            mid = (left+right)/2;
            if(isPassed(n, times, mid)){
                ans = Long.min(ans, mid);
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPassed(long n, int[] times, long mid){
        long cnt = 0;

        for(int t:times){
            cnt += mid/t;
        }

        if(cnt >= n) return true;
        return false;
    }

    public static void main(String[] args) {
//        int n = 6;
//        int[] times = {7,10};
        int n = 3;
        int[] times = {1, 99, 99};
//        System.out.println(new Solution().solution(n, times));
        long a = (long)1000000000 * (int)1000000000;
        System.out.println(a);
    }
}
