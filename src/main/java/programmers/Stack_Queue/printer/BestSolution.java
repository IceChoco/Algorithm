package programmers.Stack_Queue.printer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BestSolution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        int loc = 2; int[] test = {2,1,3,2};//1
//        int loc = 0; int[] test = {1, 1, 9, 1, 1, 1};//5
//        int loc=3; int[] test ={1,2,3,4,5};//2
        int loc=3; int[] test ={1,5,2,3,4};//2

        System.out.println(new BestSolution().solution(test,loc));
    }

}
