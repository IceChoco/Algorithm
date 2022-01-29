package BaekJoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042_구간합_구하기 {
   static long tree[];
   static long cLong;
   static int N, M, K, answer, a, b, c, number;//N: 수의 개수, M: 수의 변경이 일어나는 횟수, K: 구간의 합을 구하는 횟수


   /*
    * index : 트리 노드 인덱스
    * left, right : 노드가 커버하는 범위
    * target : 변경하고자 하는 인덱스
    * value : 변경하고자 하는 값
    */
   public static void main(String[] args) throws Exception {
      System.setIn(new FileInputStream("BJ2042_in_구간합_구하기.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken()); // 수의 개수
      M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나느 횟수
      K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수 횟수

      tree = new long[N*4];

      //그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다
      init();

      for(int i=1;i<=N;i++) {
         number = Integer.parseInt(br.readLine());
         update(1,1,N,i,number);
      }

      for(int i=1;i<=M+K;i++){
         st = new StringTokenizer(br.readLine());
         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
         if( a == 1){//a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고
            cLong = Long.parseLong(st.nextToken());
            update(1,1,N,b,cLong);
         }else {//a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 출력
            c = Integer.parseInt(st.nextToken());
            System.out.println(query(1,1,N,b,c));
         }
      }

   }

   static void init() {
      answer = 0;
      for (int i = 0; i < N * 4; i++)
         tree[i] = 0;
   }

   static void update(int index, int left, int right, int target, long value){
      //범위 벗어난 경우
      if(target < left || right < target)
         return;
      //도착한 경우
      if(left == right){
         tree[index] = value; //트리 노드 번호(index)를 가지고 위치에다가 value값을 넣어줘야함
         return;
      }
      //올바르게 가고 있는 경우
      update(index * 2, left, (left+right)/2, target, value); //왼쪽에 대한 처리
      update(index * 2+1, (left+right)/2 +1, right, target, value); //오른쪽에 대한 처리
      tree[index] = tree[index*2] + tree[index * 2 + 1];//구간들의 합을 더함
   }

   static long query(int index, int left, int right, int query_left, int query_right){
      //범위 벗어난 경우
      if(query_right < left || right < query_left)
         return 0; //쿼리로 알고싶은 구간이 이 범위를 넘어선 경우
      //도착한 경우
      if(query_left <= left && right <= query_right)
         return tree[index];
      //올바르게 가고 있는 경우
      return query(index*2, left, (left+right)/2, query_left, query_right) + query(index*2+1, (left+right)/2+1, right, query_left, query_right); //왼쪽 + 오른쪽
   }

}


/*
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가
 * 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가
 * 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤
 * N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면
 * 된다. 입력으로 주어지는 모든 수는 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
 * 
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
 */