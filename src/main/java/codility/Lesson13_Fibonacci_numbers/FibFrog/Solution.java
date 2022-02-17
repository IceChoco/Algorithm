package codility.Lesson13_Fibonacci_numbers.FibFrog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] A){
        int N = A.length;
        ArrayList<Integer> fib = getFiboList(N+1);
        Collections.sort(fib, Collections.reverseOrder());

        boolean[] visited = new boolean[N+1];
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(-1,0));
        while(!q.isEmpty()){
            Point curr = q.poll();

            for(int f:fib){
                int next = curr.idx + f;
                if(next == N){
                    return curr.times + 1;
                }else if(next < N){
                    if(A[next]==1 && !visited[next]){
                        visited[next] = true;
                        q.add(new Point(next, curr.times+1));
                    }
                }
            }
        }

        return -1;
    }

    private ArrayList<Integer> getFiboList(int N){
        int i=1, num=0;
        ArrayList<Integer> fib = new ArrayList<>();
        while(num<=N){
            num = (int)((Math.pow(((1+Math.sqrt(5))/2),i)-Math.pow(((1-Math.sqrt(5))/2),i))/Math.sqrt(5));
            fib.add(num);
            i++;
        }
        return fib;
    }

    class Point{
        int idx;
        int times;

        public Point(int idx, int times) {
            this.idx = idx;
            this.times = times;
        }
    }

    public static void main(String[] args) {
        int[] test = {0,0,0,1,1,0,1,0,0,0,0};
        System.out.println(new Solution().solution(test));
    }
}