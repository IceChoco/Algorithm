package programmers.String_Compression;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class bestSolution {
    public int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat+1);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("String_Compression.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String s;
        long start = System.currentTimeMillis();
        for(int t=1;t<=T;t++){
            s = br.readLine();
            System.out.println(new bestSolution().solution(s));
        }
        System.out.print((float)(System.currentTimeMillis() - start)/1000+"sec");
    }
}
