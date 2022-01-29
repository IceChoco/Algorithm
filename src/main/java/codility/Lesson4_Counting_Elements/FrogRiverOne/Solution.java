package Lesson4_Counting_Elements.FrogRiverOne;

import java.util.Arrays;

// 시간복잡도: O(N)
public class Solution {
    private static int[] river;
    private static int ans;

    public int solution(int X, int[] A){
        river = new int[X];
        ans = 0;

        int idx =0;
        for(int a:A){
            if(river[a-1] == 0)
                river[a-1] = idx+1;//출력 시 -1 해야함. +1한 이유는 방문 체크를 위함.
            idx++;
        }

        for(int i=0;i<river.length;i++){
            if(river[i]==0){//나뭇잎이 없으면
                return -1;
            }
        }
        Arrays.sort(river);
        return river[X-1]-1;
    }

    public static void main(String[] args) {
        int[] test = {1,3,1,4,2,3,5,4};
        System.out.println(new Solution().solution(5,test));
    }
}
