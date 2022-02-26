package codility.Lesson15_Caterpillar_method.MinAbsSumOfTwo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public int solution(int[] A){
        Integer[] copyA = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(copyA, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });

        return 0;
    }

    public static void main(String[] args) {
//        int[] A = {1,4,-3};//1
//        int[] A = {-8,4,5,-10,3};//3
        int[] A = {4,-3,1,-4};//
        System.out.println(new Solution().solution(A));
    }
}
