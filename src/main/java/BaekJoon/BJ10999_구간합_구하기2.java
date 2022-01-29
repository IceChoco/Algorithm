package BaekJoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10999_구간합_구하기2 {
	static long tree[], lazy[];
	static long d;
	static int N, M, K, answer, a, b, c, number;// N: 수의 개수, M: 수의 변경이 일어나는 횟수, K: 구간의 합을 구하는 횟수

	/*
	 * index : 트리 노드 인덱스 left, right : 노드가 커버하는 범위 target : 변경하고자 하는 인덱스 value :
	 * 변경하고자 하는 값
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BJ10999_in_구간합_구하기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수의 개수
		M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나느 횟수
		K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수 횟수

		tree = new long[N * 4]; // 각 노드에 대해 실제로 구하는 값(구간의 합)
		lazy = new long[N * 4]; // 각 노드에 대한 표시(구간에 공통적으로 더해진 수)

		// 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다
		init();

		for (int i = 1; i <= N; i++) {
			number = Integer.parseInt(br.readLine());
			update(1, 1, N, i, i, number);
		}

		for (int i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				d = Long.parseLong(st.nextToken());
				update(1, 1, N, b, c, d);
			} else {// a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 출력
				System.out.println(query(1, 1, N, b, c));
			}
		}

	}

	static void init() {
		answer = 0;
		for (int i = 0; i < N * 4; i++) {
			tree[i] = 0;
			lazy[i] = 0;
		}
	}

	// 내려가기 전에 표시를 전파하는 함수. index번 노드([left, right] 구가을 담당)에서 아래로 전파
	static void propagate(int index, int left, int right) {
		tree[index * 2] += ((left + right) / 2 - left + 1) * lazy[index]; // 실제로 얼마만큼 더해져야 하는가
		lazy[index * 2] += lazy[index];
		tree[index * 2 + 1] += (right - (left + right) / 2) * lazy[index];
		lazy[index * 2 + 1] += lazy[index];
		lazy[index] = 0;
	}

	static void update(int index, int left, int right, int target_left, int target_right, long value) {
		// 범위 벗어난 경우
		if (target_right < left || right < target_left)
			return;
		// 도착한 경우
		if (target_left <= left && right <= target_right) {
			tree[index] += (right - left + 1) * value; // 트리 노드 번호(index)를 가지고 위치에다가 value값을 넣어줘야함
			lazy[index] += value;
			return;
		}
		// 올바르게 가고 있는 경우
		propagate(index, left, right);
		update(index * 2, left, (left + right) / 2, target_left, target_right, value); // 왼쪽에 대한 처리
		update(index * 2 + 1, (left + right) / 2 + 1, right, target_left, target_right, value); // 오른쪽에 대한 처리
		tree[index] = tree[index * 2] + tree[index * 2 + 1];// 구간들의 합을 더함
	}

	static long query(int index, int left, int right, int query_left, int query_right) {
		// 범위 벗어난 경우
		if (query_right < left || right < query_left)
			return 0; // 쿼리로 알고싶은 구간이 이 범위를 넘어선 경우
		// 도착한 경우
		if (query_left <= left && right <= query_right)
			return tree[index];
		propagate(index, left, right);
		// 올바르게 가고 있는 경우
		return query(index * 2, left, (left + right) / 2, query_left, query_right)
				+ query(index * 2 + 1, (left + right) / 2 + 1, right, query_left, query_right); // 왼쪽 + 오른쪽
	}

}