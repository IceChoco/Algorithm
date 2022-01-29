package codility.Lesson6_Sorting.Distinct;

import java.util.HashSet;

public class Solution {
    public int solution(int[] A){
        HashSet<Integer> distinctA = new HashSet<>();
        for(int a:A){
            distinctA.add(a);
        }
        return distinctA.size();
    }

    public static void main(String[] args) {
        int[] test = {2,1,1,2,3,1};
        System.out.println(new Solution().solution(test));
    }
}
