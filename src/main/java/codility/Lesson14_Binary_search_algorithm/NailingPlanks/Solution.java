package codility.Lesson14_Binary_search_algorithm.NailingPlanks;

import java.util.*;

public class Solution {
    public int solution(int[] A, int[] B, int[] C){
        /* 1. nails: nail들을 value값으로 오름차순 정렬
           2. nailsSeen: nail의 idx를 증복 제거하기 위해 HashSet으로 선언.
                         동일한 indx의 못들을 여러개 가질 필요가 없기 때문
         */
        Set<Integer> nailsSeen = new HashSet<>();
        ArrayList<Nail> nails = new ArrayList<>();
        for(int i=0; i<C.length;i++){
            if(!nailsSeen.contains(C[i])){
                nails.add(new Nail(i+1, C[i]));
                nailsSeen.add(C[i]);
            }
        }
        Collections.sort(nails);

        ArrayList<Plank> planks = new ArrayList<>();
        for(int i=0; i<A.length;i++)
            planks.add(new Plank(i, A[i], B[i]));
        Collections.sort(planks);

        for(int i=0;i<planks.size()-2;i++){
            /* 지금 보고 있는 판자가 다음 판자의 끝보다 뒤에 있다면, 다음 판자에 속해있는 것이기 때문에 지금 판자를 remove한다.
               start는 어차피 오름차순으로 정렬했기 때문에 따로 체크를 안해줘도
               두번째 판자가 지금 판자보다 start가 같거나 클 것이다. */
            while(i>0 && planks.get(i).end > planks.get(i+1).end){
                planks.remove(i--);//remove하면 인덱스 하나가 빠질테니까 i--를 해줌. 안그럼 아웃오브 인덱스 에러 남.
            }
        }

        int minIdx, bestAns = 0;
        for(Plank plank : planks){
            minIdx = getMinNailIndex(nails, plank);//이 판자를 박을 수 있는 최소 못 인덱스를 구함
            if(minIdx == -1)
                return -1;
            bestAns = Math.max(bestAns, minIdx);//전체 판자 기준 최소 못 인덱스이기 때문에 max로 구함
        }
        return bestAns;
    }

    private int getMinNailIndex(List<Nail> nails, Plank plank){
        int start = 0, end = nails.size() - 1, mid, result = -1;
        while(start<=end){
            mid = (start+end)/2;
            if(nails.get(mid).value < plank.start){
                start = mid+1;
            }else if(nails.get(mid).value > plank.end){
                end = mid-1;
            }else{
                result = mid;
                end = mid-1; //범위에 들어오더라도 최소 못질로 이 판자를 박을 수 있는지 확인하기 위해 범위를 더 작은 쪽으로 줄여본다.
            }
        }

        if(result == -1)
            return result;

        int minIdx = nails.get(result).idx;
        for(int i=result+1; i<nails.size(); i++){
            if(nails.get(i).value <= plank.end){
                minIdx = Math.min(minIdx, nails.get(i).idx);
            }else{
                return minIdx;
            }
        }
        return minIdx;
    }

    /* [판자를 정렬하는 이유]
     * 1~10, 2~5인 판자 2개가 있을 때
     * 2~5인 판자가 만약에 못질이 되는 경우 1~10도 자동으로 못질이 된다.
     * 왜냐하면 2~5는 1~10에 완전히 포함되기 때문이다.
     * 따라서 이런 경우의 수를 파악하기 위해 start로 오름차순 정렬한다.
     */
    class Plank implements Comparable<Plank>{
        int idx;
        int start;
        int end;

        public Plank(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Plank o) {
            return this.start - o.start;
        }
    }

    class Nail implements Comparable<Nail>{
        int idx;
        int value;

        public Nail(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Nail o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,4,5,8};
        int[] B = {4,5,9,10};
        int[] C = {4,6,7,10,2};
        System.out.println(new Solution().solution(A,B,C));
    }
}
