package codility.Lesson1_Iteration.binaryGap;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    private static final char ONE = '1';

    public int solution(int N) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0; //Longest binary Gap
        String binaryString = Integer.toBinaryString(N);
        char now;
        int cnt = 0;
        boolean startChk = false;

        pq.add(0);
        for(int i=0;i<binaryString.length();i++){
            now = binaryString.charAt(i);
            if(ONE == now){//now가 1이다.
                if(!startChk){ //처음 시작
                    startChk = true;
                }else{//마지막
                    pq.add(cnt);
                }
                cnt = 0; //초기화
            }else{                             //now가 0이다.
                if(startChk){
                    cnt++;
                }
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        Solution s = new Solution();

        int input;
        for(int i=0;i<T;i++){
            input = Integer.parseInt(st.nextToken());
            s.solution(input);
        }
    }
}

/*
5
9 529 20 15 32
* */
