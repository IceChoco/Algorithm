package programmers.Stack_Queue;

import java.util.ArrayList;
import java.util.Stack;

public class functionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        Stack<Integer> day = new Stack<>();
        ArrayList<Integer> release = new ArrayList<>();

        int dayPerWork, cnt = 1;
        for(int i=0;i<N;i++) {
            dayPerWork = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) dayPerWork++;

            while(!day.isEmpty()){
                if(day.peek() >= dayPerWork) {
                    cnt++;
                    break;
                }else{
                    day.pop();
                    if(day.isEmpty()){
                        release.add(cnt);
                        cnt = 1;
                    }
                }
            }

            day.add(dayPerWork);
        }

        release.add(cnt);
        return release.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55}; //2,1
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99}; //1,3,2
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = new functionDevelopment().solution(progresses,speeds);

        for(int r:result)
            System.out.println(r);
    }
}
