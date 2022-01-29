package codility.Lesson2_Arrays.OddOccurrencesInArray;

import java.util.Arrays;

/*
내가 놓쳤던 케이스
1. 맨마지막 원소가 홀수인 경우,
   for문 종료 후 ans에 tmp를 넣어줘야 함.
2. 원소가 한개인 경우,
   ans = 0; 으로 초기화한다면 답은 0이 나오게 됨. 정답은 그 원소값이어 함.
   그러므로 ans를 첫번째 원소인 A[0]으로 할당 후 시작해야 함.
*/
class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        int ans = A[0];
        int tmp = A[0];
        int cnt = 1;
        for(int i=1;i<A.length;i++){
            if( tmp == A[i] ){
                cnt++;
            }else{
                if(cnt % 2 == 1){//홀수
                    ans = A[i-1];
                    break;
                }
                tmp = A[i];
                cnt = 1;
            }
        }

        if(cnt % 2 == 1) ans = tmp;

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int test[] = {42};
        System.out.println(s.solution(test));
    }
}
