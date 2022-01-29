package BaekJoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2672_Calculate_totalArea_of_severalRectangles {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BJ2672_Calculate_totalArea_of_severalRectangles.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] p = new Point[N*2];

        StringTokenizer st;
        int x,y,width,height;
        //입력: x,y,폭,높이
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            x = (int)(Double.parseDouble(st.nextToken())*10);
            y = (int)(Double.parseDouble(st.nextToken())*10);
            width = (int)(Double.parseDouble(st.nextToken())*10);
            height = (int)(Double.parseDouble(st.nextToken())*10);

            p[i]   = new Point(x,y, height,1);//x좌표, y좌표, height, 시작여부
            p[i+N] = new Point(x+width,y,height,-1);
        }
        Arrays.sort(p);

        double area = 0;
        /*
         * 각 수의 최대는 1000. 히지만 계산상 편의를 위해 *10을 하므로 최대가 10,000이 된다.
         * y의 높이도 10,000이 올 수 있으므로 10,000 + 10,000 인 20,000이 최대가 된다.
         * 따라서 10,000이 아닌 20,000으로 설정해줘야 ArrayIndexOutOfBounds가 발생할 수 있다.
         */
        int[] ylist = new int[20001];
        int ylen = 0;

        for (int i = 0; i<p.length-1 ; i++){
            Point now = p[i];
            if(now.startYn == 1){
                for(int j=now.y;j<now.maxY;j++){
                    if(ylist[j] == 0) ylen++;
                    ylist[j] += 1;
                }
            }else{//닫힌다~!
                for(int j=now.y;j<now.maxY;j++) {
                    ylist[j] -= 1;
                    //하나의 사각형도 겹쳐져 있지 않을 떄에만 ylen을 줄여주고
                    //그렇지 않은 점은 ylen을 줄여주지 않는다.
                    if (ylist[j] == 0) ylen--;
                }
            }
            area += (p[i+1].x - now.x)*ylen;
        }

        area /= 100;
        if(area - (int)area > 0){
            System.out.printf("%.2f",area);
        }else{
            System.out.println((int)area);
        }
    }

    //x좌표, y좌표, maxY, 시작여부
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int maxY;
        int startYn;

        public Point(int x, int y, int height, int startYn) {
            this.x = x;
            this.y = y;
            this.maxY = y + height;
            this.startYn = startYn;
        }

        @Override
        public int compareTo(Point o) {
            return x - o.x;//오름차순
        }
    }
}
