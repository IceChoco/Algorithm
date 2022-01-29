package codility.Lesson5_PrefixSums.GenomicRangeQuery;

import java.io.*;
/*
첫번째 풀이 - 인덱스 트리를 이용하는 방법(맞지만 두번째 풀이보다 느림)
          - 소스: Solution_indexTree
=> 시간복잡도: O(N+M)

두번째 풀이 - 누적합을 이용하는 방법(첫번째보다 빠름)
=> 시간복잡도: O(N+M)

인덱스 트리로 풀어도 되지만 이 문제는 시간복잡도가 매우 타이트함.
원소가 이 문제처럼 1234와 같이 정해져있는 경우 누적합을 이용하는게 최적이 됨!
들어올 숫자의 범위를 모르면 그냥 인덱스 트리 써도 됨!
* */
public class Solution {
    private static final int DNA_MAXIMUM = 4;
    private static int from, to;
    private static int[] ans;
    private static int[][] dna;

    public int[] solution(String S, int[] P, int[] Q){
        ans = new int[P.length];
        dna = new int[S.length()+1][DNA_MAXIMUM];

        for(int i=1;i<=S.length();i++){
            dna[i][getIdx(S.charAt(i-1))]++;

            if(i != 1){
                dna[i][0] += dna[i-1][0];
                dna[i][1] += dna[i-1][1];
                dna[i][2] += dna[i-1][2];
                dna[i][3] += dna[i-1][3];
            }
        }

        for(int i=0;i<P.length;i++){//질의의 갯수만큼 반복
            from = P[i];
            to = Q[i];
            if(from == to)
                ans[i] = getIdx(S.charAt(from))+1;
            else{
                for(int j=0;j<DNA_MAXIMUM;j++){//질의 하나 당 4번 반복
                    if(dna[to+1][j] - dna[from][j] > 0){
                        ans[i] = j+1;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    private static int getIdx(char input){
        int idx;

        if(input == 'A') idx = 0;
        else if(input == 'C') idx = 1;
        else if(input == 'G') idx = 2;
        else idx = 3;

        return idx;
    }

    public static void main(String[] args) throws IOException {
        String s = "CAGCCTA";
        int[] p = {2,5,0};
        int[] q = {4,5,6};

//        String s = "AC";
//        int p[] = {0,0,1};
//        int q[] = {0,1,1};

//        String s = "TC";
//        int p[] = {0,0,1};
//        int q[] = {0,1,1};

        int result[] = new Solution().solution(s,p,q);
        for (int r:result) System.out.println(r);
    }
}
