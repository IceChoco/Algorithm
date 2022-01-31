package programmers.RotateMatrixBorders;

public class Solution {
    private static int[][] num;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] dr = {0,1,0,-1};//우하좌상
        int[] dc = {1,0,-1,0};
        num = new int[rows+1][columns+1];

        int r1,c1, r2,c2, last, temp, d;

        for(int i=0;i<queries.length;i++){
            int[] a = queries[i];
            r1 = a[0]; c1 = a[1]; r2 = a[2]; c2 = a[3];

            last = getNum(r1,c1,columns);
            d = 0;

            int nowR = r1+dr[d], nowC = c1+dc[d], min = 10001;
            while(true){
                min = Integer.min(last,min);

                temp = getNum(nowR,nowC,columns);
                num[nowR][nowC] = last;
                last = temp;

                if(r1 == nowR && c1 == nowC) break;

                if(nowR+dr[d] > r2 || nowC+dc[d]>c2 || nowC+dc[d]<c1 || nowR+dr[d] < r1)
                    d = (d+1)%4;

                nowR += dr[d]; nowC += dc[d];
            }
            answer[i] = min;
        }

        return answer;
    }

    private int getNum(int r, int c, int cLen){
        if(num[r][c] == 0)
            return ((r-1)*cLen+c);
        return num[r][c];
    }

    public static void main(String[] args) {
        int[][] test = {{2,2,5,6},{3,3,5,6},{4,1,5,3}};
        int[] result = new Solution().solution(5,6,test);//8, 10, 25

//        int[][] test = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//        int[] result = new Solution().solution(6,6,test);//8, 10, 25

//        int[][] test = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
//        int[] result = new Solution().solution(3,3,test);//1,1,5,3

//        int[][] test = {{1,1,100,97}};
//        int[] result = new Solution().solution(100,97,test);//1

        for (int r:result)
            System.out.println(r);
    }
}