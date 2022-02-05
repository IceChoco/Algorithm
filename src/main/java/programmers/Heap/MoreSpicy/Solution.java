package programmers.Heap.MoreSpicy;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int s:scoville)
            q.add((long)s);

        long f1, f2;
        while(true){
            if(q.peek() >= K || q.size()<2) break;

            f1 = q.poll(); f2 = q.poll();
            q.add(f1 + (f2*2));
            answer++;
        }

        return (answer==0||q.peek()<K)?-1:answer;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 9, 10, 12};
        System.out.println(new Solution().solution(input, 7));
    }

}
