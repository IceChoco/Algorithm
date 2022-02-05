package programmers.Heap.DoublePriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        String[] operation;
        String sign;
        int num;
        for(String s:operations){
            operation = s.split(" ");
            sign = operation[0]; num = Integer.parseInt(operation[1]);

            if(sign.equals("I")){
                maxHeap.add(num);
                minHeap.add(num);
            }else{
                if(num == 1){
                    Integer max = maxHeap.poll();
                    minHeap.remove(max);
                }else{
                    Integer min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        int min = 0, max = 0;
        int[] answer = new int[2];
        if(!maxHeap.isEmpty()){
            min = minHeap.poll();
            max = maxHeap.poll();
        }
        answer[0] = max; answer[1] = min;
        return answer;
    }

    public static void main(String[] args) {
//        String[] input = {"I 16","D 1"};//0,0
        String[] input = {"I 7","I 5","I -5","D -1"};//0,0
        int[] result = new Solution().solution(input);
        for(int r:result)
            System.out.println(r);
    }
}
