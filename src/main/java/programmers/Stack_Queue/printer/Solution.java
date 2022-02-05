package programmers.Stack_Queue.printer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution{
    public int solution(int[] priorities, int location) {
        Queue<Printer> q = new LinkedList();
        for(int i=0;i<priorities.length;i++){
            q.add(new Printer(priorities[i], i));
        }

        boolean biggerYn;
        int cnt = 0;
        while(!q.isEmpty()){
            Printer now = q.poll();
            biggerYn = false;

            for(Printer next:q){
                if(now.priority < next.priority){
                    biggerYn = true;
                    break;
                }
            }

            if(biggerYn){
                q.add(now);
            }else{
                cnt++;
                if(location == now.idx){
                    return cnt;
                }
            }
        }

        return cnt;
    }

    class Printer{
        int priority;
        int idx;

        public Printer(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
//        int loc = 2; int[] test = {2,1,3,2};//1
//        int loc = 0; int[] test = {1, 1, 9, 1, 1, 1};//5
        int loc=3; int[] test ={1,2,3,4,5};//2

        System.out.println(new Solution().solution(test,loc));
    }
}