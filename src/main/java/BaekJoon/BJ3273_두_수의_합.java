package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3273_두_수의_합 {
	static int left, right, N, X, sum, ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BJ3273_in_두_수의_합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sum = 0;
		N = Integer.parseInt(br.readLine()); // 수열의 크기 N
		int number[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(number);// 오름차순으로 정렬

		X = Integer.parseInt(br.readLine()); // 자연수 X

		left = 0;
		right = N - 1;
		while (true) {// ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하라

			if (left >= right)
				break;

			sum = number[left] + number[right];

			if (sum == X) {// 1. 두 수의 합이 X와 같은 경우
				ans++;
				left++; right--;
			} else if (sum > X) {// 2. 두 수의 합이 X보다 크다면 right를 1 감소시킨다.
				right--;
			} else {// 3. 두 수의 합이 X보다 크다면 left를 1 증가시킨다.
				left++;
			}
		}
		System.out.println(ans);
		br.close();

	}

}
 