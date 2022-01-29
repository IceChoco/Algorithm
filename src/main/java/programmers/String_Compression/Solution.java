package programmers.String_Compression;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    private int sameCnt;

    public int solution(String s) {
        int answer = s.length(), idx, endIdx;
        String fstStr ="", secStr="", compSentence;

        for (int unit=1;unit<s.length();unit++){
            idx = 0;
            sameCnt= 1;
            compSentence = "";

            while(idx+1*unit<s.length()){
                if(idx+2*unit > s.length())
                    endIdx = s.length();
                else
                    endIdx = idx+2*unit;

                fstStr = s.substring(idx,idx+unit);//ab
                secStr = s.substring(idx+unit,endIdx);//cd

                if(fstStr.equals(secStr)){
                    sameCnt++;
                }else{
                    compSentence = makeSenetence(compSentence, fstStr);
                }

                idx+=unit;
            }

            compSentence = makeSenetence(compSentence, secStr);

            if (compSentence.length() != 0)
                answer = Integer.min(answer, compSentence.length());
        }
        return answer;
    }

    private String makeSenetence(String sentence, String fstStr){
        StringBuffer bf = new StringBuffer();

        if(sameCnt == 1)
            sentence += fstStr;
        else{
            bf.append(sentence).append(sameCnt).append(fstStr);
            sentence = bf.toString();
            sameCnt = 1;
        }

        return sentence;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("String_Compression.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String s;
        long start = System.currentTimeMillis();
        for(int t=1;t<=T;t++){
            s = br.readLine();
            System.out.println(new Solution().solution(s));
        }
        System.out.print((float)(System.currentTimeMillis() - start)/1000+"sec");
    }
}

//        String s = "aabbaccc";//7 - 2a2ba3c
//        String s = "ababcdcdababcdcd";//9
//        String s ="abcabcdede";//8
//        String s = "abcabcabcabcdededededede";//7
//    String s = "xababcdcdababcdcd";//17