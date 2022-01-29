package codility.Lesson10_PrimeAndCompositeNumbers.Peaks;

import java.util.ArrayList;

/* [주의해야할 사항]
 * 1. We want to divide this array into blocks containing the "same number of elements"
 *  - 문제 잘 읽자... 모든 block의 elements 수가 동일해야하는지 몰랐음ㅠ
 *    알아 차리고 난 후 if(A.length % block == 0)가 아니라면 pass하도록 로직 개선함
 *
 * 2. accmList.get(j) < e
 *  - 지금 블럭의 peak는 다음블럭의 시작 인덱스보다 작아야 한다.
 *   → 1개의 블럭 당 1개의 peak만 갖고 있는 최적의 결과를 찾아야 하기 때문
 *   → 1개의 블럭에 2개의 peak를 갖고 있는 경우 block의 수를 더 늘려 element의 수를 줄이는 것이 더 이득이다.
 */

public class Solution {
    public int solution(int[] A){

        int ans = 1;

        ArrayList<Integer> accmList = new ArrayList<Integer>();

        //배열의 길이가 3 미만인 경우 peak가 있을 수 없으므로, 계산 불필요
        if(A.length < 3)
            return 0;



        for(int i=1;i<A.length-1;i++)
            if(A[i-1]<A[i] && A[i]>A[i+1])
                accmList.add(i);



        int maxPeak = accmList.size();



        //만약 봉우리가 없다면 block도 0개이다.
        //봉우리가 1개라면 최대 block 수도 0개이다.
        if(maxPeak < 2) return maxPeak;



        int eCnts, idx, cnt, s, e;



        for(int block=maxPeak;block>=2;block--){

            if(A.length % block == 0){//동일한 eCnts로 block이 나눠지지 않는 경우는 고려하지 않는다.

                //eCnts: 한 block 당 elements의 수

                eCnts = A.length/block;

                idx = 0;

                cnt = 0;//peak를 포함한 블럭으ㅣ 수



                for(int j=0;j<accmList.size();j++){

                    s = cnt * eCnts;    //지금 블럭의 시작 인덱스 - 0, 4

                    e = (cnt+1) * eCnts;//다음 블럭의 시작 인덱스 - 4, 8



                    // 지금 블럭의 peak는 다음블럭의 시작 인덱스보다 작아야 한다.
                    // → 1개의 블럭 당 1개의 peak만 갖고 있는 최적의 결과를 찾아야 하기 때문
                    // → 1개의 블럭에 2개의 peak를 갖고 있는 경우 block의 수를 더 늘려 element의 수를 줄이는 것이 더 이득이다.
                    if(s <= accmList.get(j) && accmList.get(j) < e){

                        cnt++;

                    }

                }

                if(cnt >= block) return block;

            }

        }

        return ans;

    }



    public static void main(String[] args) {

//        int[] test = {1,2,3,4,3,4,1,2,3,4,6,2,5};//1 (원소갯수: 13)
        int[] test = {1,2,3,4,3,4,1,2,3,4,6,2};//3
//        int[] test = {5};//0
//        int[] test = {0,1,0,0,1,0,0,1,0};//3

        System.out.println(new Solution().solution(test));

    }

}