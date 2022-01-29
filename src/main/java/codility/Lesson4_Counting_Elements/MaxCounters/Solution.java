package codility.Lesson4_Counting_Elements.MaxCounters;
/*
헤맸던 곳: 카운터 다 끝나고 mc 더할 때, mc보다 이전이면 엎어치기해야하고 이후면 더하기 해줘야하는데 어떻게 해야할지 헤맸음
해결방법: increase연산 수행 시, mc보다 작으면 mc+1 부분을 추가함.
* */
public class Solution {
    private static int[] counter;
    private static int a, maxValue, maxCounter ;

    public int[] solution(int N, int[] A){
        counter = new int[N];
        a = 0;
        maxCounter = 0;
        maxValue = Integer.MIN_VALUE;

        for(int i=0;i<A.length;i++){
            a = A[i];
            if(a == N+1){
                maxCounter = maxValue;
            }
            else{
                if(counter[a-1] < maxCounter) //이부분! 카운터가 mc보다 작으면 mc+1해준다!
                    counter[a-1] =  maxCounter + 1;
                else
                    counter[a-1]++;

                maxValue = Integer.max(maxValue,counter[a-1]);
            }
        }

        for (int i=0;i<counter.length;i++){
            if(counter[i] < maxCounter)
                counter[i] = maxCounter;
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] test = {3,4,4,6,1,4,4};
        int[] result = new Solution().solution(5,test);

        for (int r:result)
            System.out.println(r);
    }
}