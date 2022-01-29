package codility.Lesson6_Sorting.NumberOfDiscIntersections;

import java.util.Arrays;

/*
유의할 점:
1. x 뿐만 아니라 direct(방향)도 왼쪽부터 검사해야 하므로,
   x와 direct 모두 오름차순으로 정렬해야 함
2. e의 범위가 0~2,147,483,647 이므로 long형으로 x좌표를 선언해야 함
* */
public class Solution {
    public int solution(int[] A){
        Point[] point = new Point[A.length*2];

        int idx = 0;
        for (int i=0;i<A.length;i++){
            point[idx] = new Point((long)i-A[i],-1);//좌
            point[idx+1] = new Point((long)i+A[i],1);//우
            idx+=2;
        }

        Arrays.sort(point);

        int ans = 0;//교차하는 쌍의 갯수
        int intervals = 0;//체크 시작했으나 아직 닫혀지지 않은 원의 갯수

        for(int i=0;i< point.length;i++){
            if(point[i].direction == -1){//디스크의 왼쪽
                ans += intervals;//아직 닫혀지지 않은 원의 갯수를 더한다. 왜냐하면 다음 포인트에서 그 원이 닫힌다 하더라도 내가 이미 새로운 원을 열었기 때문에 무조건 겹칠 것이기 때문!
                intervals++;//원이 하나 열렸다!
            }else if(point[i].direction == 1){//디스크의 오른쪽
                intervals--;
            }
        }

        if(ans > 10000000) ans = -1;

        return ans;
    }

    private static class Point implements Comparable<Point>{
        long x;
        int direction;

        public Point(long x, int direction) {
            this.x = x;
            this.direction = direction;
        }

        @Override
        public int compareTo(Point o) {//x좌표를 기준으로 정렬한다.
            int num = Long.compare(x,o.x);
            if(num == 0)
                num = Long.compare(direction,o.direction);
            return num;
        }
    }

    public static void main(String[] args) {
        //int[] test = {1,5,2,1,4,0};//1
        //int[] test = {1,1,1};//3
        int[] test = {1, 2147483647, 0};
        System.out.println(new Solution().solution(test));
    }
}
