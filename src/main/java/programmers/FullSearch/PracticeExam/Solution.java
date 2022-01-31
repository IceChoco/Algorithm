package programmers.FullSearch.PracticeExam;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] ans = new int[3];
        int idx = 0, max = -1;
        ArrayList<Integer> list = new ArrayList<>();

        for(int a:answers){
            if(p1[(idx+p1.length)%p1.length] == a) ans[0]++;
            if(p2[(idx+p2.length)%p2.length] == a) ans[1]++;
            if(p3[(idx+p3.length)%p3.length] == a) ans[2]++;

            max = Integer.max(ans[0],Integer.max(ans[1], ans[2]));
            idx++;
        }

        for(int i=0;i< ans.length;i++)
            if(ans[i] == max){
                list.add(i+1);
            }

        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
//        int[] input = {1,2,3,4,5};//1
        int[] input = {1,3,2,4,2};//1,2,3
        int[] result = new Solution().solution(input);
        for (int r:result)
           System.out.println(r);
    }
}
