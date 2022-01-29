package codility.Lesson10_PrimeAndCompositeNumbers.Flags;

import java.util.ArrayList;

/* [유의해야 할 점]
 * 모든 peak에 깃발을 꽂을 수 있다고 생각했을 때 가능한 최대 깃발의 수는 peak의 개수?
 * 이렇게 하면 불필요한 계산이 많이 따라서 모든 performance test를 통과할 수 없다.
 * => size가 N일 때 설치 할 수 있는 최대 flag의 갯수 = peak(N-1)과 peak(0)의 거리차의 제곱근 + 1을 정수로 표현한 값
 *    을 활용하면 모든 TC에 대해 타임아웃 없이 Complete 할 수 있다.
 *
 * [ 보고서 ]
 * 1. 첫번째 풀이: 정답률 80% - 워스트 케이스에 대해 타임아웃 발생
 *  - https://app.codility.com/demo/results/training3QYM2D-WFW/
 *
 * 2. 최종 풀이: 정답률 100%
 *  - https://app.codility.com/demo/results/trainingSBYGJ2-TT6/
 */
public class Solution {
    public int solution(int[] A){
        ArrayList<Integer> peak = new ArrayList<>();

        for(int i=1;i<A.length-1;i++)//O(n)의 시간복잡도
            if(A[i]>A[i-1] && A[i]>A[i+1])
                peak.add(i);

        //만약 봉우리가 없다면 깃발도 꽂을 수 없다.
        //봉우리가 1개라면 거리에 대한 비교가 필요 없기 때문에 1을 바로 리턴한다.
        if(peak.size() < 2)
            return peak.size();

        int ans = -1;
        int idx, cnt;
        /* 모든 peak에 깃발을 꽂을 수 있다고 생각했을 때 가능한 최대 깃발의 수는 peak의 개수?
         * -> 이렇게 하면 불필요한 계산이 많이 따라서 모든 performance test를 통과할 수 없다.
         *
         * size가 N일 때 설치 할 수 있는 최대 flag의 갯수 = peak(N-1)과 peak(0)의 거리차의 제곱근 + 1을 정수로 표현한 값
         */
        int maxFlag = (int)Math.sqrt( peak.get(peak.size()-1)-peak.get(0))+1;

        for(int flag=maxFlag;flag>=2;flag--){
            cnt = 1;
            idx = peak.get(0);
            for(int j=1;j< peak.size();j++){
                if( idx+flag <= peak.get(j)){
                    idx = peak.get(j);
                    cnt++;
                }
            }
            if (cnt >= flag) return flag;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(new Solution().solution(test));
    }
}
