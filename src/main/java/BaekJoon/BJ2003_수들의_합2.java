package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2003_수들의_합2 {
	static int left, right, sum, M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //N:숫자의 개수
		int M = Integer.parseInt(st.nextToken()); //M:합
		int number[] = new int [N];

		st = new StringTokenizer(br.readLine());

		for(int i = 0;i<N;i++){
			number[i] = Integer.parseInt(st.nextToken());
		}

		left = right = 0;

//	     /*210326에서 내가 쓴 방법*/
//	     while(true){
//	    	 if(right==N && left == right-1) break;
//
//	    	 if(sum == M){//1. 부분합과 M이 같은 경우
//	    		 ans++;
//			     left ++;
//			     sum -= number[left-1];
//	    	 }else if((sum>M && !(left==right-1)) || right == N){//2. 부분합이 M보다 크거나 right가 N이상인경우 - left가 right-1이 아닌 경우를 따로 넣지 않음
//	    		 left++;
//			     sum -= number[left-1];
//	    	 }else{//3.일반적인 경우
//	    		 right++;
//			     sum += number[right-1];
//	    	 }
//	     }

	     /*
	      시험에서 내가 틀렸던 원인은 break 구문을 잘못주었기 떄문. left가 right-1이고, right가 N인 경우도 검사되어야 한다.
	      하지만 위와같이 구현하면 처음 break 구문에 걸리면서 해당 케이스가 제대로 계산되지 않았을 것,,,,
	      left가 N이상일떄로 break 걸어주면 된다
	     */
		while(true){
			if(left >= N) break;

			if(sum == M){//1. 부분합과 M이 같은 경우
				ans++;
				left ++;
				sum -= number[left-1];
			}else if(sum>M  || right == N){//2. 부분합이 M보다 크거나 right가 N이상인경우 - left가 right-1이 아닌 경우를 따로 넣지 않음
				left++;
				sum -= number[left-1];
			}else{//3.일반적인 경우
				right++;
				sum += number[right-1];
			}
		}

		System.out.println(ans);
		br.close();
		bw.close();

	}

}