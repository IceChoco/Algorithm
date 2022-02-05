package programmers.sort.KthNumber;

import java.util.Arrays;

/* 나는 clone 후 arrays.sort로 범위를 줘서 새로운 배열에 넣었음
 * -> 아예 복사할 때 부터 Arrays.copyOfRange를 쓰면 편리함!
 */
public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int[] now;
        int from,to,k;
        for(int i=0;i<commands.length;i++){
            now = array.clone();
            from = commands[i][0]; to = commands[i][1]; k = commands[i][2];

            Arrays.sort(now, from-1, to);
            answer[i] = now[from+k-2];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = new Solution().solution(a,b);

        for(int r:result)
            System.out.println(r);
    }
}
