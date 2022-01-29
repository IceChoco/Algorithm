package programmers.Kakao_ColoringBook;

public class Solution {
    private boolean[][] visited;
    private int[][] globalPicture;
    private int gM, gN, result;
    private static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};// 0:상, 1:하, 2:좌, 3:우

    public int[] solution(int m, int n, int[][] picture) {
        globalPicture = picture;
        gM = m; gN = n;
        visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]>0 && !visited[i][j]){
                    result=0;
                    recursiveFine(i,j,picture[i][j]);
                    maxSizeOfOneArea = Integer.max(maxSizeOfOneArea, result);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private void recursiveFine(int r, int c, int num){
        if(visited[r][c]) return;

        visited[r][c] = true;
        result++;

        for (int i=0;i<4;i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextC >= gN || nextR >= gM || nextC<0 || nextR < 0)
                continue;

            if(globalPicture[nextR][nextC] == num && !visited[nextR][nextC])
                recursiveFine(nextR,nextC,num);
        }
    }

    public static void main(String[] args) {
//        int[][] input = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};//4,5
        int[][] input =  {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};//2,6

        int[] result = new Solution().solution(6,4,input);
        for(int r:result)
            System.out.println(r);
    }
}


