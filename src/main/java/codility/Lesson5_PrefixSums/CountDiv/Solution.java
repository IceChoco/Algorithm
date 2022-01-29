package codility.Lesson5_PrefixSums.CountDiv;

import java.io.*;
import java.util.StringTokenizer;
/*
Solution_indexTree
 1) A이상 가장 작은 배수인 num을 찾는다
   ex) 5%2 = 1 (나머지), num = a + (a%k)
 2) B보다 크기 전 까지 while문을 반복하며 num+=k; cnt++;
=> 시간복잡도: O((B-A))/K
   A: 101, B:2000000000, K:2 인 경우, 999,999,949.5(9억 9천번) 반복해야함. 타임아웃 에러.

해결방법: B/K - A/K (B를 K로 나눈 몫과, A를 K로 나눈 몫의 차를 구한다)
 - 예외 케이스:
   A가 K의 배수(나머지가 0) or A가 0인 경우: B/K - A/K +1
    -> A가 0인 경우에도 k가 무엇이든 간에 0을 k로 나눈 나머지는 무조건 0이므로(A mok k = 0);
=> 시간복잡도: O(1)
**/
public class Solution {
    private static int num, cnt;

    public int solution(int A, int B, int K){
        if((A % K) == 0 || A==0)
            cnt = B/K - A/K +1;
        else
            cnt = B/K - A/K;

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Lesson5_PrefixSums_CountDiv.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int a, b, k;
        StringTokenizer st;
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            System.out.println(new Solution().solution(a,b,k));
        }
    }
}

/*
6 11 2 -> 3
10 10 7 -> 0
11 345 17 -> 20
100 12345999 1000 -> 12345
0 0 11 -> 1
* */
