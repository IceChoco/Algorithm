package BaekJoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2261_Closest_two_points {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BJ2261_Closest_two_points.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] p = new Point[N];

        StringTokenizer st;
        int x,y;
        for(int i=0;i<N;i++){//입력
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x,y);
        }
        Arrays.sort(p);

        TreeSet<Point> node = new TreeSet(sortByY);//y좌표 정렬 시 사용
        int minDist = dist(p[0], p[1]); //첫 번쨰 원소와 두번쨰 원소를 최소거리라고 가정하고 시작

        //탐색은 p[2] 부터 시작하므로 p[0], p[1]을 후보군이라 가정하고 Treeset에 넣음
        node.add(p[0]);
        node.add(p[1]);

        int lowestIdx = 0; //왼쪽 끝점

        int xDist;
        for(int i=2;i<p.length;i++){
            Point benchPoint = p[i];//기준점

            while(lowestIdx < i) {
                Point targetPoint = p[lowestIdx];

                xDist = benchPoint.x - targetPoint.x;

                /* [밝은 회색 영역 후보군 필터링]
                 * 왼쪽 끝 점부터 p[i] 이전 원소들에 대해 minDist보다 더 멀리 떨어진 원소들은 대상에서 제외한다.
                 */
                if (xDist * xDist > minDist) {
                    node.remove(targetPoint);
                    lowestIdx++;
                } else {//x축에 대해 정렬된 상태이기 때문에, 처음 만족하는 후보군을 마주치면 이 후의 후보군들은 x축에 대해 모두 만족하므로 break한다.
                    break;
                }
            }

            /* [진한 회색 영역 필터링]
             * p[(-10000, 기준점-root(minDist)) : 10000, 기준점+root(minDist)] 사이에 있는 원소들에 대해 subTree를 얻고,
             * 해당 원소들에 대해 기준점과의 거리를 측정한다.
             */

            int sqrtMinDist = (int)Math.sqrt(minDist) + 1;//소수점 버림 방지를 위해 1을 더한다.

            TreeSet<Point> ySub = (TreeSet<Point>) node.subSet(new Point(-10000, benchPoint.y - sqrtMinDist), new Point(100000, benchPoint.y + sqrtMinDist));
            for(Point v : ySub){
                minDist = Math.min(minDist, dist(benchPoint, v));
            }

            //위 과정이 모두 끝나면 기준점을 후보군에 넣는다.
            node.add(benchPoint);
        }

        System.out.println(minDist);

    }

    //모든 x,y가 같은 경우 중복 포인트를 없애주기 위해 y가 같다면 x값에 대해서도 비교를 해주도록 해야한다.
    static Comparator<Point> sortByY = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        }
    };

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return x - o.x;
        }
    }

    private static int dist(Point a, Point b){
        return (int)Math.pow(b.x - a.x,2) + (int)Math.pow(b.y - a.y,2);
    }
}

