package codility.Lesson14_Binary_search_algorithm.NailingPlanks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int solution(int[] A, int[] B, int[] C){
        int N = A.length, max = C.length, min = 1, bestAns = max+1, from = 1, to = (min+max)/2;
        int mid, planks = 0;
        boolean plusYn = true;

        Queue<Point> input = new LinkedList<>();
        for(int i=0; i<A.length;i++)
            input.add(new Point(i, A[i], B[i]));

        while(min<=max){
            mid = (min+max)/2;

            if(plusYn)
                planks += getPlanks(A, C, from, to, input);
            else
                planks -= getPlanks(A, C, from, to, input);

            if(planks == N){
                max = mid -1;
                bestAns = Math.min(bestAns, mid);
                from = (min+max)/2; to = max;
                plusYn = false;
            }else{
                min = mid+1;
                from = min; to = (min+max)/2;
                plusYn = true;
            }
        }

        return bestAns==N+1?-1:bestAns;
    }

    private int getPlanks(int[] A, int[] C, int from, int to, Queue<Point> input){
        Queue<Point> rmnIdx = new LinkedList<>();
        rmnIdx.addAll(input);

        boolean visited[] = new boolean[A.length];
        int planks = 0;
        Point curr;
        for(int j=from;j<=to;j++){
            Arrays.fill(visited, false);
            while (!rmnIdx.isEmpty()){
                if(visited[rmnIdx.peek().idx])
                    break;

                curr = rmnIdx.poll();
                visited[curr.idx] = true;
                if(C[j-1] >= curr.start && C[j-1]<= curr.end){
                    planks++;
                }else{
                    rmnIdx.add(curr);
                }
            }
        }

        return planks;
    }

    class Point{
        int idx;
        int start;
        int end;

        public Point(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,4,5,8};
        int[] B = {4,5,9,10};
        int[] C = {4,6,7,10,2};
        System.out.println(new Solution2().solution(A,B,C));
    }
}
