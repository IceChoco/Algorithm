package Lesson3_Time_Complexity.FrogJmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public int solution(int X, int Y, int D){
        if(X==Y){//X가 이미 Y에 있다면 한번도 안뛰어도 된다.
            return 0;
        }
        //그게 아니라면 최소 1번은 뛰어야할 것...
        int ans = (int) Math.ceil((double)(Y - X) / D);
        return ans;
    };

    //10 85 30
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Solution s = new Solution();
        System.out.println(s.solution(X,Y,D));
    }
}
