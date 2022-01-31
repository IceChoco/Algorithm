package programmers.lightPathCycle;

import java.util.ArrayList;
import java.util.Collections;

/* [주의해야할 점]
 * 재귀함수 사용하면 테스트 케이스 7번의 경우 너무 많은 재귀로 인해
 * StackOverFlow 런타임 에러 발생. while문으로 작성할 것
 */

public class Solution {
    private static int[] dr = {1,0,0-1,0};//하,좌,상,우 (시계방향)
    private static int[] dc = {0,-1,0,1};
    private static boolean[][][] visited;
    private static int cnt, C, R;

    public int[] solution(String[] grid) {
        C = grid[0].length();
        R = grid.length;
        ArrayList<Integer> answerList = new ArrayList<>();
        cnt = 0;
        visited = new boolean[R][C][4];

        for (int i = 0; i< R; i++){
            for (int j = 0; j< C; j++){
                for (int d=0;d<4;d++){
                    light(i,j,d, grid);
                    if(cnt != 0){
                        answerList.add(cnt);
                        cnt = 0;
                    }
                }
            }
        }

        Collections.sort(answerList);

        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }

    private void light(int r, int c, int d, String[] grid){
        while(true){
            if(visited[r][c][d])
                break;

            visited[r][c][d] = true;

            cnt++;

            if(grid[r].charAt(c) == 'L')//좌
                d = (d+1)%4;
            else if(grid[r].charAt(c) == 'R')//우
                d = (d+3)%4;

            r = (r+dr[d]+ R)% R;
            c = (c+dc[d]+ C)% C;
        }
    }

    public static void main(String[] args) {
        String[] input = {"SL","LR"};//16
//        String[] input = {"S"};//1,1,1,1
//        String[] input = {"R","R"};//4,4
        int[] result = new Solution().solution(input);

        for (int a:result)
            System.out.println(a);
    }
}
