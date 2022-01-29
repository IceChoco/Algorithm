package BaekJoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11658_Calculate_prifexSum3 {
//class Main{
	static long data[][];
	static long tree[][];
	static int C, N, M, W, X, Y, Y1, Y2, X1, X2;
	static long answer;

	/*
	 * 2���� ����Ʈ��
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BJ11658_in_������_���ϱ�3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // ���� ����
		M = Integer.parseInt(st.nextToken()); // ���� ������ �Ͼ�� Ƚ��
		
		data = new long[N+1][N+1];
		tree = new long[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				data[i][j] = Long.parseLong(st.nextToken());
				update(i, j, data[i][j]);
			}
		}
		answer = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			if (W == 0) {//w = 0�� ���� (x, y)�� c�� �ٲٴ� ����
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				
				long offset = C - data[X][Y];//���� �� ���� ���� �� ���� ��
				data[X][Y] = C;
				update(X, Y, offset);
			} else {
				X1 = Integer.parseInt(st.nextToken()); //��
				Y1 = Integer.parseInt(st.nextToken()); //��
				X2 = Integer.parseInt(st.nextToken());
				Y2 = Integer.parseInt(st.nextToken()); 
				
				long temp = query(X2,Y2) - query(X2, Y1-1) - query(X1-1, Y2) + query(X1-1, Y1-1);
				System.out.println(temp);
			}
		}

	}

	static void update(int r_position, int c_position, long offset) {//��, ��
		while(r_position < data.length){
			int c_temp = c_position;
			while(c_temp < data[r_position].length){	
				tree[r_position][c_temp] += offset;
				c_temp += c_temp & -c_temp;
			}
			r_position += r_position & -r_position;
		}
	}

	static long query(int r_position, int c_position) {
		long retval = 0;
		while (r_position > 0) {
			int c_temp = c_position;
			while(c_temp > 0){	
				retval += tree[r_position][c_temp];
				c_temp -= c_temp & -c_temp;
			}
			r_position -= r_position & -r_position;
		}
		return retval;
	}

}