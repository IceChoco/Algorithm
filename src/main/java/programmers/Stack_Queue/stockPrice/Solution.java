package programmers.Stack_Queue.stockPrice;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> stock = new LinkedList<>();
        for(int p:prices)
            stock.add(p);

        int s, cnt = 0, idx = 0;
        while(!stock.isEmpty()){
            s = stock.poll();
            cnt = 0;
            for(int next:stock){
                cnt++;
                if(s>next) break;
            }

            answer[idx] = cnt;
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] input = {1, 2, 3, 2, 3};//43110
//        int[] input = {12, 9, 8, 7, 5,5,2,3,4,4};//1111213210
//        int[] input = {7,4,5,6};//1210
        int[] input = {7,7,7,6,7,7};//321210
        int[] result = new Solution().solution(input);

        for(int r:result)
            System.out.print(r);
    }
}
