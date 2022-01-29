package Lesson4_Counting_Elements.MissingInteger;

import java.util.ArrayList;
import java.util.Arrays;

/*
헤맸던 곳: treeSet을 사용했더니 정확도 100, 성능은 시간 초과가 나왔음 => O(N^2).
          treeSet은 삽입/삭제/검색 한 번에 O(log n)이 소요된다는 걸 알게되었음.
해결방법: treeSet 안쓰고 그냥 배열 정렬 ->
         i번째 원소랑 i+1번째 원소가 다른 경우에만 ArrayList에 추가 이런식으로 중복제거해서 넣고
         그 다음 비교로직은 처음과 똑같이 두었음 => O(N) or O(N*log(N))
* */
public class Solution {
    private static int ans;
    private static ArrayList<Integer> arr;

    public int solution(int[] A){
        ans = 0;//정답
        arr = new ArrayList<>();

        Arrays.sort(A);

        for(int i=0;i<A.length-1;i++){
            if(A[i]>0 && A[i]!=A[i+1]){ //그 수가 0보다 크고, 다음 element와 같지 않을 때만 tmp에 넣음
                arr.add(A[i]);
            }
        }
        arr.add(A[A.length-1]);

        int value;
        for(int i=0;i<arr.size();i++){
            value = arr.get(i);
            if(value < 1){
                ans = 1; break;
            }
            else if(!(value == i+1)){
                ans = i+1; break;
            }
        }

        if(ans==0) ans = arr.size()+1;
        return ans;
    }

    public static void main(String[] args) {
        //int[] test = {-1000000,5,1,2,3,4};
        //int[] test = {1,3,6,4,1,2};
        int[] test = {1,2,3,3,3,3,3};
        //int[] test = {-1,-3};
        System.out.println(new Solution().solution(test));
    }
}
