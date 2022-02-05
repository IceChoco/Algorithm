package programmers.Stack_Queue.truckPassingThroughBridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int weightSum = 0, time = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> waitTruck = new LinkedList<>();

        for(int w:truck_weights)
            waitTruck.add(w);

        int w;
        while(!waitTruck.isEmpty()){
            w = waitTruck.peek();

            if(bridge.size() == bridge_length){
                weightSum -= bridge.peek();
                bridge.poll();
            }

            if(weightSum + w <= weight){
                weightSum += w;
                bridge.add(w);
                waitTruck.poll();
            }else{
                bridge.add(0);
            }
            time++;
        }

        return time+bridge_length;
    }

    public static void main(String[] args) {
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6}; //8

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10}; //101

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; //110

        System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
    }
}
