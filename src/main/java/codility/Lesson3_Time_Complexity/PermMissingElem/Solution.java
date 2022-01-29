package Lesson3_Time_Complexity.PermMissingElem;

import com.sun.jdi.Value;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A){
        boolean[] booleans = new boolean[A.length+1];
        int ans = 0;
        for(int a:A){
            booleans[a-1] = true;
        }
        for(int i=0;i<booleans.length;i++){
            if(!booleans[i]){
                ans = i+1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,5};
        System.out.println(new Solution().solution(test));
    }
}
