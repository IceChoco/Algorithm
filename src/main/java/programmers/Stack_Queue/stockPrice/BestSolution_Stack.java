package programmers.Stack_Queue.stockPrice;

import java.util.Stack;

public class BestSolution_Stack {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 3};//43110
//        int[] input = {12, 9, 8, 7, 5,5,2,3,4,4};//1111213210
//        int[] input = {7,4,5,6};//1210
//        int[] input = {7,7,7,6,7,7};//321210
        int[] result = new BestSolution_Stack().solution(input);

        for(int r:result)
            System.out.print(r);
    }
}
