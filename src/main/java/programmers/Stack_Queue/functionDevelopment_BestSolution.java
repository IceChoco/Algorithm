package programmers.Stack_Queue;

import java.util.Arrays;

public class functionDevelopment_BestSolution {
    public int[] solution(int[] progresses, int[] speeds){
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0;i<progresses.length;i++){
            // while 문에서 하루 하루 증가하다가 100을 넘으면 '배포일' 입니다.
            // 다음 작업이 100을 넘었으면 같은 '배포일'의 배포 횟수가 올라갑니다. 100 미만이면 다음 '배포일'을 만날 때까지 반복합니다.
            while (progresses[i] + (day*speeds[i])<100)
                day++;
            //'배포일'에 해당 작업을 배포하고 다음 작업으로 넘어갑니다(for 문).
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i->i!=0).toArray();
    }

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55}; //2,1
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99}; //1,3,2
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = new functionDevelopment_BestSolution().solution(progresses,speeds);

        for(int r:result)
            System.out.println(r);
    }
}
