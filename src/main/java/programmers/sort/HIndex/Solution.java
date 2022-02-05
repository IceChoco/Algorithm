package programmers.sort.HIndex;

import java.util.Arrays;
/* [나의 풀이]
 * 원소 값 이상인 것의 개수가 원소 값보다 같거나 크다면
 * -> 그 다음 원소의 인덱스 vs 지금 원소값을 비교, 둘 중 더 큰 값을 반환한다.
 */
public class Solution {
    public int solution(int[] citations) {
        int N = citations.length;

        Arrays.sort(citations);

        for(int i=N-1;i>=0;i--){
            if(N-i >= citations[i]){
                if(N-(i+1)>citations[i])
                    return N-(i+1);
                return citations[i];
            }
        }

        return N;
    }

    public static void main(String[] args) {
        int[] input = {3,0,6,1,5};//3
//        int[] input = {6,6,6,6,6};//5
//        int[] input = {1,1,5,8,9};//3
//        int[] input = {1,2,3,5,6,7,4};//4
//        int[] input = {1,1,1,1,1};//1

        System.out.println(new Solution().solution(input));
    }
}
